package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.common.item.ModFuelBlockItem;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LoungingDonuts.MOD_ID);

    public static final RegistryObject<Block> DONUT_ORE = registerBlock("donut_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE),UniformInt.of(2, 4)));

    public static final RegistryObject<Block> DEEPSLATE_DONUT_ORE = registerBlock("deepslate_donut_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE),UniformInt.of(3, 5)));

    public static final RegistryObject<Block> PINK_DONUT_BLOCK = registerBlock("pink_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLUE_DONUT_BLOCK = registerBlock("blue_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> GOLD_DONUT_BLOCK = registerBlock("gold_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> GREEN_DONUT_BLOCK = registerBlock("green_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> BLACK_DONUT_BLOCK = registerBlock("black_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> AMETHYST_DONUT_BLOCK = registerBlock("amethyst_donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
            .requiresCorrectToolForDrops()
            .sound(SoundType.AMETHYST)));
    //stone
    public static final RegistryObject<Block> DONUT_BATTER = registerBlock("donut_batter", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DONUT_BATTER_BRICKS = registerBlock("donut_batter_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DONUT_BATTER_TILES = registerBlock("donut_batter_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DONUT_BATTER = registerBlock("polished_donut_batter", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    //slab
    public static final RegistryObject<Block> DONUT_BATTER_BRICK_SLAB = registerBlock("donut_batter_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DONUT_BATTER_TILE_SLAB = registerBlock("donut_batter_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DONUT_BATTER_SLAB = registerBlock("polished_donut_batter_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    //stair
    public static final RegistryObject<Block> DONUT_BATTER_BRICK_STAIRS = registerBlock("donut_batter_brick_stairs", () -> new StairBlock(ModBlocks.DONUT_BATTER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DONUT_BATTER_TILE_STAIRS = registerBlock("donut_batter_tile_stairs", () -> new StairBlock(ModBlocks.DONUT_BATTER_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DONUT_BATTER_STAIRS = registerBlock("polished_donut_batter_stairs", () -> new StairBlock(ModBlocks.POLISHED_DONUT_BATTER.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    //wall
    public static final RegistryObject<Block> DONUT_BATTER_BRICK_WALL = registerBlock("donut_batter_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DONUT_BATTER_TILE_WALL = registerBlock("donut_batter_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DONUT_BATTER_WALL = registerBlock("polished_donut_batter_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));

    //to do: DONUT_BATTER brick stairs, walls, slab. polished DONUT_BATTER slab, walls, stair. tiles slab, wall, stair
    //TBA BLOCKS
    /*
    public static final RegistryObject<Block> NETHER_DONUT_ORE = registerBlock("nether_donut_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERRACK),UniformInt.of(3, 5)));

    public static final RegistryObject<Block> END_DONUT_ORE = registerBlock("end_donut_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE),UniformInt.of(4, 6)));
    public static final RegistryObject<Block> DONUT_BLOCK = registerBlock("donut_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
            .requiresCorrectToolForDrops()));

     */

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if(name.equals("gold_donut_block") || name.equals("amethyst_donut_block")){
            registerBlockItemWithFireRes(name, toReturn);
        }
        else if(name.equals("black_donut_block")){
            registerFuelBlockItem(name, toReturn);
        } else {
            registerBlockItem(name, toReturn);
        }
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new ModFuelBlockItem(block.get(), new Item.Properties(), 28800));
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItemWithFireRes(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

}
