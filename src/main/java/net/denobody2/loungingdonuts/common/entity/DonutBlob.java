package net.denobody2.loungingdonuts.common.entity;

import net.denobody2.loungingdonuts.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.*;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class DonutBlob extends Monster implements GeoEntity {
    private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(DonutBlob.class, EntityDataSerializers.INT);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, true);
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(DonutBlob.class, EntityDataSerializers.INT);

    public DonutBlob(EntityType pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
        this.moveControl = new DonutBlobMoveControl(this);
        this.navigation = new GroundPathNavigation(this, pLevel);
        this.setCombatTask();

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new RandomStollJumpGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
    }
    public void setCombatTask() {
        if (this.level() != null && !this.level().isClientSide) {
            this.goalSelector.addGoal(1, this.aiAttackOnCollide);
        }

    }

    public static AttributeSupplier.Builder setAttributes(){
        return createMobAttributes()
                .add(Attributes.ARMOR, 1.5D)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.MAX_HEALTH, 25D)
                .add(Attributes.JUMP_STRENGTH, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0f);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
    }
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("wasOnGround", this.wasOnGround);
    }
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.wasOnGround = pCompound.getBoolean("wasOnGround");
    }
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }
    protected int getJumpDelay() {
        return this.random.nextInt(10)+20;
    }


    public void push(Entity pEntity) {
        super.push(pEntity);
        if (pEntity instanceof IronGolem) {
            this.dealDamage((LivingEntity)pEntity);
        }

    }
    public void playerTouch(Player pEntity) {
        this.dealDamage(pEntity);

    }
    protected void dealDamage(LivingEntity pLivingEntity) {
        if (this.isAlive()) {
            if (this.distanceToSqr(pLivingEntity) < 0.6D * (double)2 * 0.6D * (double)2 && this.hasLineOfSight(pLivingEntity) && pLivingEntity.hurt(this.damageSources().mobAttack(this), this.getAttackDamage())) {
                this.playSound(SoundEvents.SLIME_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.doEnchantDamageEffects(this, pLivingEntity);
            }
        }
    }
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.625F * pSize.height;
    }
    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
    }
    public boolean doHurtTarget(Entity entityIn) {
        return true;
    }
    protected float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return SoundEvents.SLIME_SQUISH;
    }
    public static boolean checkSlimeSpawnRules(EntityType<DonutBlob> pSlime, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            //System.out.println("HI DENOBODY2 " + pLevel.getMoonBrightness());
            if (0.5F > pLevel.getMoonBrightness() && pPos.getY() > 50) {
                //System.out.println("HI DENOBODY2, WE MADE IT TO STAGE 2" +checkMonsterSpawnRules(pSlime, (ServerLevelAccessor) pLevel, pSpawnType, pPos, pRandom));
                return checkMonsterSpawnRules(pSlime, (ServerLevelAccessor) pLevel, pSpawnType, pPos, pRandom);
                //BlockPos blockpos = pPos.below();
                //return pSpawnType == MobSpawnType.SPAWNER || pLevel.getBlockState(blockpos).isValidSpawn(pLevel, blockpos, pSpawnType);
            }
        }

        return false;
    }
    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }
    public boolean hurt(DamageSource source, float amount) {
        return super.hurt(source, amount);
    }
    public void tick() {
        super.tick();
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        if (this.onGround() && !this.wasOnGround) {

            for (int j = 0; j < 8; ++j) {
                float f = this.random.nextFloat() * Mth.TWO_PI;
                float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                float f2 = Mth.sin(f) * 0.5F * f1;
                float f3 = Mth.cos(f) * 0.5F * f1;
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(ModItems.DONUT_MUSH.get())), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.35F;
        } else if (!this.onGround() && this.wasOnGround) {
            this.squishAmount = 2F;
        }
        if(this.isInWater()){
            this.setDeltaMovement(this.getDeltaMovement().add(0, 0.05D, 0));
        }
        this.wasOnGround = this.onGround();
        this.alterSquishAmount();
        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && this.distanceToSqr(livingentity) < 144D) {
            this.moveControl.setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), this.moveControl.getSpeedModifier());
            this.wasOnGround = true;
        }

        if (this.getTarget() != null && this.distanceTo(this.getTarget()) < 1.0D) {
            super.doHurtTarget(this.getTarget());
        }

    }
    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F;
    }

    /**
     * The speed it takes to move the entity's head rotation through the faceEntity method.
     */
    public int getMaxHeadXRot() {
        return 0;
    }

    /**
     * Returns {@code true} if the slime makes a sound when it jumps (based upon the slime's size)
     */
    protected boolean doPlayJumpSound() {
        return true;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jumpFromGround() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, (double)this.getJumpPower(), vec3.z);
        this.hasImpulse = true;
    }

    float getSoundPitch() {
        float f =  0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected SoundEvent getJumpSound() {
         return SoundEvents.SLIME_JUMP;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }
    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> state) {
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private static class DonutBlobMoveControl extends MoveControl {
        private final DonutBlob slime;
        private float yRot;
        private int jumpDelay;
        private boolean isAggressive;

        public DonutBlobMoveControl(DonutBlob slimeIn) {
            super(slimeIn);
            this.slime = slimeIn;
            this.yRot = 180.0F * slimeIn.getYRot() / Mth.PI;
        }

        public void setDirection(float yRotIn, boolean aggressive) {
            this.yRot = yRotIn;
            this.isAggressive = aggressive;
        }

        public void setSpeed(double speedIn) {
            this.speedModifier = speedIn;
            this.operation = MoveControl.Operation.MOVE_TO;
        }

        public void tick() {
            if (this.mob.onGround()) {
                this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                if (this.operation != Operation.WAIT && this.jumpDelay <= 0) {
                    this.slime.getJumpControl().jump();
                    this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), this.slime.getVoicePitch());
                    this.jumpDelay = slime.getJumpDelay();
                } else {
                    this.slime.xxa = 0.0F;
                    this.slime.zza = 0.0F;
                    this.mob.setSpeed(0.0F);
                    this.jumpDelay/=3;
                }
            }
            super.tick();
        }
    }
    public static class RandomStollJumpGoal extends RandomStrollGoal {

        public RandomStollJumpGoal(PathfinderMob pMob, double pSpeedModifier) {
            super(pMob, pSpeedModifier);
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return true;
        }
    }






}
