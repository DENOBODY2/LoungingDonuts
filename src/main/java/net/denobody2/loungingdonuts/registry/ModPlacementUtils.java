package net.denobody2.loungingdonuts.registry;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacementUtils {
    public static final PlacementModifier RANGE_DONUT_RUINS = HeightRangePlacement.uniform(VerticalAnchor.absolute(4), VerticalAnchor.absolute(64));
    public static final PlacementModifier RANGE_DEEPSLATE_DONUT_RUINS = HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(-10));

}
