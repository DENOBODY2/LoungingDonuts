package net.denobody2.loungingdonuts.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(8).saturationMod(0.8f)
            .build();

    public static final FoodProperties HAIR_DYE_DONUT = new FoodProperties.Builder().nutrition(6).saturationMod(0.8f)
            .build();
    public static final FoodProperties GOLD_DONUT = new FoodProperties.Builder().nutrition(10).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f).alwaysEat().build();
    public static final FoodProperties ENCHANTED_GOLD_DONUT = new FoodProperties.Builder().nutrition(10).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).alwaysEat().build();

}
