package net.denobody2.loungingdonuts.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(6).saturationMod(0.8f)
            .build();

    public static final FoodProperties HAIR_DYE_DONUT = new FoodProperties.Builder().nutrition(5).saturationMod(0.8f)
            .build();
    public static final FoodProperties GOLD_DONUT = new FoodProperties.Builder().nutrition(8).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).alwaysEat().build();
    public static final FoodProperties ENCHANTED_GOLD_DONUT = new FoodProperties.Builder().nutrition(8).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).alwaysEat().build();

    public static final FoodProperties GREEN_DONUT = new FoodProperties.Builder().nutrition(5).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 1), 1.0f).build();

    public static final FoodProperties BLACK_DONUT = new FoodProperties.Builder().nutrition(4).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0f).build();

    public static final FoodProperties AMETHYST_DONUT = new FoodProperties.Builder().nutrition(7).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0), 1.0f).alwaysEat().build();

    public static final FoodProperties ENCHANTED_AMETHYST_DONUT = new FoodProperties.Builder().nutrition(8).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0), 1.0f).alwaysEat().build();

    public static final FoodProperties RED_DONUT = new FoodProperties.Builder().nutrition(5).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0f).build();

    public static final FoodProperties ORANGE_DONUT = new FoodProperties.Builder().nutrition(5).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1.0f).build();

    public static final FoodProperties BLAZING_DONUT = new FoodProperties.Builder().nutrition(7).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 2400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0f).alwaysEat().build();

    public static final FoodProperties ENCHANTED_BLAZING_DONUT = new FoodProperties.Builder().nutrition(8).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 2), 1.0f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 6000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1), 1.0f).alwaysEat().build();

    public static final FoodProperties PURPLE_DONUT = new FoodProperties.Builder().nutrition(6).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1), 1.0f).build();

    public static final FoodProperties CHORUS_DONUT = new FoodProperties.Builder().nutrition(6).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 300, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0), 1.0f).build();

    public static final FoodProperties PEARL_DONUT = new FoodProperties.Builder().nutrition(7).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0), 1.0f).alwaysEat().build();

    public static final FoodProperties DRAGON_DONUT = new FoodProperties.Builder().nutrition(9).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 5), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 3), 1.0f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 6000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 1), 1.0f).alwaysEat().build();

}
