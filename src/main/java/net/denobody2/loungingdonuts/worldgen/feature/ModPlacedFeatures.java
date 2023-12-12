package net.denobody2.loungingdonuts.worldgen.feature;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.worldgen.ModOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> DONUT_ORE_PLACED_KEY = registerKey("donut_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_DONUT_ORE_PLACED_KEY = registerKey("deepslate_donut_ore_placed");
    public static final ResourceKey<PlacedFeature> DONUT_GEODE_PLACED_KEY = registerKey("donut_geode_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_DONUT_GEODE_PLACED_KEY = registerKey("deepslate_donut_geode_placed");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);



        register(context, DONUT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DONUT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-4), VerticalAnchor.absolute(80))));

        register(context, DEEPSLATE_DONUT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_DONUT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(4))));

        register(context, DONUT_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DONUT_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(30)),
                        BiomeFilter.biome()));

        register(context, DEEPSLATE_DONUT_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_DONUT_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(55), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-30), VerticalAnchor.absolute(-10)),
                        BiomeFilter.biome()));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(LoungingDonuts.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
