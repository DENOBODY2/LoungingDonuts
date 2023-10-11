package net.denobody2.loungingdonuts.worldgen;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE = registerKey("add_donut_ore");
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE_FORESTS = registerKey("add_donut_ore_forests");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);



        context.register(ADD_DONUT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DONUT_ORE_FORESTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));



    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(LoungingDonuts.MOD_ID, name));
    }
}
