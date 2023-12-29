package net.denobody2.loungingdonuts.event;


import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.registry.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LoungingDonuts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEvents {
    @SubscribeEvent
    public static void onDonutShieldBlock(ShieldBlockEvent event){
        if(event.getEntity() instanceof Player player){
            if(player.getItemInHand(InteractionHand.OFF_HAND).getItem() == ModItems.DONUT_SHIELD.get()){
                if(event.getDamageSource().getDirectEntity() != null){
                    if(event.getDamageSource().getDirectEntity() instanceof LivingEntity attacker){
                        double enemyX = attacker.getDeltaMovement().x;
                        double enemyY = attacker.getDeltaMovement().y;
                        double enemyZ = attacker.getDeltaMovement().z;
                        if(Math.abs(enemyY)*10 > 3){
                            enemyY = 0.1;
                        }
                        if(Math.abs(enemyY) < 0.1 && Math.abs(enemyX) < 0.4 && Math.abs(enemyZ) < 0.4){
                            attacker.setDeltaMovement((-10*enemyX),(Math.abs(10*enemyY)),(-10*enemyZ));
                        }else if(Math.abs(enemyX) < 0.4 && Math.abs(enemyY) <0.1){
                            attacker.setDeltaMovement((-10*enemyX),(Math.abs(10*enemyY)),(-5*enemyZ));
                        }else if(Math.abs(enemyZ) < 0.4 && Math.abs(enemyY) <0.1){
                            attacker.setDeltaMovement((-5*enemyX),(Math.abs(10*enemyY)),(-10*enemyZ));
                        }else if(Math.abs(enemyZ) < 0.4 && Math.abs(enemyX) <0.1){
                            attacker.setDeltaMovement((-10*enemyX),(Math.abs(2*enemyY)),(-10*enemyZ));
                        }else if(Math.abs(enemyX) < 0.4){
                            attacker.setDeltaMovement((-10*enemyX),(Math.abs(2*enemyY)),(-5*enemyZ));
                        }else if(Math.abs(enemyY) < 0.1){
                            attacker.setDeltaMovement((-10*enemyX),(Math.abs(2*enemyY)),(-10*enemyZ));
                        }else if(Math.abs(enemyZ) < 0.4){
                            attacker.setDeltaMovement((-5*enemyX),(Math.abs(2*enemyY)),(-10*enemyZ));
                        } else{
                            attacker.setDeltaMovement((-5*enemyX),(Math.abs(2*enemyY)),(-5*enemyZ));
                        }
                    } else if(event.getDamageSource().getDirectEntity() instanceof Projectile projectile){
                        double projectileX = projectile.getDeltaMovement().x;
                        double projectileY = projectile.getDeltaMovement().y;
                        double projectileZ = projectile.getDeltaMovement().z;
                        projectile.setDeltaMovement((-15*projectileX),(Math.abs(10*projectileY)),(-15*projectileZ));
                    }
                }
            }
        }
    }
}
