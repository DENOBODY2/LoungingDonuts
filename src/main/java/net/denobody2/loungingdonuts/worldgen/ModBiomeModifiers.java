package net.denobody2.loungingdonuts.worldgen;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.registry.ModEntities;
import net.denobody2.loungingdonuts.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE = registerKey("add_donut_ore");
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE_BEACH = registerKey("add_donut_ore_beach");
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE_DESERT = registerKey("add_donut_ore_desert");
    public static final ResourceKey<BiomeModifier> ADD_DONUT_ORE_FORESTS = registerKey("add_donut_ore_forests");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_DONUT_ORE = registerKey("add_deepslate_donut_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_DONUT_ORE_JUNGLE = registerKey("add_deepslate_donut_ore_jungle");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_DONUT_ORE_BADLANDS = registerKey("add_deepslate_donut_ore_badlands");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_DONUT_ORE_DEEP_DARK = registerKey("add_deepslate_donut_ore_deep_dark");
    public static final ResourceKey<BiomeModifier> ADD_DONUT_GEODE = registerKey("add_donut_geode");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_DONUT_GEODE = registerKey("add_deepslate_donut_geode");

    public static final ResourceKey<BiomeModifier> SPAWN_DONUT_BLOB = registerKey("spawn_donut_blob");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(ADD_DONUT_GEODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        context.register(ADD_DEEPSLATE_DONUT_GEODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_DONUT_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        context.register(ADD_DONUT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DONUT_ORE_BEACH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BEACH),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DONUT_ORE_DESERT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.SPAWNS_GOLD_RABBITS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DONUT_ORE_FORESTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_DONUT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_DONUT_ORE_JUNGLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_DONUT_ORE_BADLANDS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_DONUT_ORE_DEEP_DARK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.HAS_ANCIENT_CITY),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_DONUT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_DONUT_BLOB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DONUT_BLOB.get(), 20, 10, 20))));



    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(LoungingDonuts.MOD_ID, name));
    }
}
