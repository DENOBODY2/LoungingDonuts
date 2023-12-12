package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> DONUTS = tag("donuts");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(LoungingDonuts.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Blocks {
        public static final TagKey<Block> NEEDS_DONUT_TOOL = tag("needs_donut_tool");

        public static final TagKey<Block> DONUT_BLOCKS = tag("donut_blocks");



        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LoungingDonuts.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
