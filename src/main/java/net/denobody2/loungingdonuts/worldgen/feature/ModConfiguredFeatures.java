package net.denobody2.loungingdonuts.worldgen.feature;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> DONUT_ORE_KEY = registerKey("donut_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_DONUT_ORE_KEY = registerKey("deepslate_donut_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DONUT_GEODE_KEY = registerKey("donut_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_DONUT_GEODE_KEY = registerKey("deepslate_donut_geode");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> donutOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        ModBlocks.DONUT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, Blocks.DEEPSLATE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> deepDonutOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        Blocks.STONE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_DONUT_ORE.get().defaultBlockState()));

        register(context, DONUT_ORE_KEY, Feature.ORE, new OreConfiguration(donutOres, 9));

        register(context, DEEPSLATE_DONUT_ORE_KEY, Feature.ORE, new OreConfiguration(deepDonutOres, 9));

        register(context, DONUT_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.STONE),
                        BlockStateProvider.simple(ModBlocks.DONUT_ORE.get()),
                        BlockStateProvider.simple(Blocks.TUFF),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.DONUT_ORE.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.8D, 2.0D, 2), 0.1D, 0.2D,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -18, 18, 0.05D, 1));

        register(context, DEEPSLATE_DONUT_ORE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(ModBlocks.DEEPSLATE_DONUT_ORE.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.DEEPSLATE_DONUT_ORE.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.6D, 1.0D, 2), 0.1D, 0.2D,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -18, 18, 0.05D, 1));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(LoungingDonuts.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
