package net.denobody2.loungingdonuts.common.item;
import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.registry.ModItems;
import net.denobody2.loungingdonuts.registry.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier DONUT = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1250, 9.0f, 3f, 23,
                    ModTags.Blocks.NEEDS_DONUT_TOOL, () -> Ingredient.of(ModItems.DONUT_INGOT.get())),
            new ResourceLocation(LoungingDonuts.MOD_ID, "donut"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

}
