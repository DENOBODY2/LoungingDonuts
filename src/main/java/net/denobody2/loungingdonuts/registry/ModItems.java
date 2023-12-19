package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.common.item.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LoungingDonuts.MOD_ID);

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
    //overworld donuts
    public static final RegistryObject<Item> PINK_DONUT = ITEMS.register("pink_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.DONUT).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> BLUE_DONUT = ITEMS.register("blue_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.HAIR_DYE_DONUT).stacksTo(64).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GOLD_DONUT = ITEMS.register("gold_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.GOLD_DONUT).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENCHANTED_GOLD_DONUT = ITEMS.register("enchanted_gold_donut",
            ()-> new EnchantedDonutItem(new Item.Properties().food(ModFoodProperties.ENCHANTED_GOLD_DONUT).stacksTo(64).rarity(Rarity.EPIC)));
    //deepslate donuts
    public static final RegistryObject<Item> GREEN_DONUT = ITEMS.register("green_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.GREEN_DONUT).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> BLACK_DONUT = ITEMS.register("black_donut",
            ()-> new ModFuelItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(ModFoodProperties.BLACK_DONUT), 3200));
    public static final RegistryObject<Item> AMETHYST_DONUT = ITEMS.register("amethyst_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.AMETHYST_DONUT).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENCHANTED_AMETHYST_DONUT = ITEMS.register("enchanted_amethyst_donut",
            ()-> new EnchantedDonutItem(new Item.Properties().food(ModFoodProperties.ENCHANTED_AMETHYST_DONUT).stacksTo(64).rarity(Rarity.EPIC)));
    //first donut tool items
    public static final RegistryObject<Item> DONUT_MUSH = ITEMS.register("donut_mush", ()-> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DONUT_INGOT = ITEMS.register("donut_ingot", ()-> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DONUT_KNIFE = ITEMS.register("donut_knife",
            ()-> new DonutKnifeItem(ModToolTiers.DONUT, 3, -2.0f,
                    new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final RegistryObject<Item> DONUT_SHIELD = ITEMS.register("donut_shield",
            () -> new DonutShieldItem(new Item.Properties().durability(500)));
    //nether donuts
    /*public static final RegistryObject<Item> RED_DONUT = ITEMS.register("red_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.RED_DONUT).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ORANGE_DONUT = ITEMS.register("orange_donut",
            ()-> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(ModFoodProperties.ORANGE_DONUT)));
    public static final RegistryObject<Item> BLAZING_DONUT = ITEMS.register("blazing_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.BLAZING_DONUT).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENCHANTED_BLAZING_DONUT = ITEMS.register("enchanted_blazing_donut",
            ()-> new EnchantedDonutItem(new Item.Properties().food(ModFoodProperties.ENCHANTED_BLAZING_DONUT).stacksTo(64).rarity(Rarity.EPIC)));

     */
    //end donuts
    /*public static final RegistryObject<Item> PURPLE_DONUT = ITEMS.register("purple_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.PURPLE_DONUT).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CHORUS_DONUT = ITEMS.register("chorus_donut",
            ()-> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(ModFoodProperties.CHORUS_DONUT)));
    public static final RegistryObject<Item> PEARL_DONUT = ITEMS.register("pearl_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.PEARL_DONUT).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> DRAGON_DONUT = ITEMS.register("dragon_donut",
            ()-> new EnchantedDonutItem(new Item.Properties().food(ModFoodProperties.DRAGON_DONUT).stacksTo(64).rarity(Rarity.EPIC)));

     */
    //donut armor
    /*
    public static final RegistryObject<Item> DONUT_HELMET = ITEMS.register("donut_helmet",
            () -> new DonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> DONUT_CHESTPLATE = ITEMS.register("donut_chestplate",
            () -> new DonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> DONUT_LEGGINGS = ITEMS.register("donut_leggings",
            () -> new DonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> DONUT_BOOTS = ITEMS.register("donut_boots",
            () -> new DonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    */
    //infused donut gear
    /*
    public static final RegistryObject<Item> INFUSED_DONUT_HELMET = ITEMS.register("infused_donut_helmet",
            () -> new InfusedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFUSED_DONUT_CHESTPLATE = ITEMS.register("infused_donut_chestplate",
            () -> new InfusedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFUSED_DONUT_LEGGINGS = ITEMS.register("infused_donut_leggings",
            () -> new InfusedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFUSED_DONUT_BOOTS = ITEMS.register("infused_donut_boots",
            () -> new InfusedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFUSED_DONUT_KNIFE = ITEMS.register("infused_donut_knife",
            ()-> new InfusedDonutKnifeItem(ModToolTiers.DONUT, 3, -2.0f,
                    new Item.Properties().rarity(Rarity.RARE).fireResistant()));

     */
    //damaged donut gear
    /*public static final RegistryObject<Item> DAMAGED_DONUT_KNIFE = ITEMS.register("damaged_donut_knife",
            ()-> new InfusedDonutKnifeItem(ModToolTiers.DONUT, -100, -10000f,
                    new Item.Properties().rarity(Rarity.COMMON).fireResistant()));
    public static final RegistryObject<Item> DAMAGED_DONUT_HELMET = ITEMS.register("damaged_donut_helmet",
            () -> new DamagedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DAMAGED_DONUT_CHESTPLATE = ITEMS.register("damaged_donut_chestplate",
            () -> new DamagedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DAMAGED_DONUT_LEGGINGS = ITEMS.register("damaged_donut_leggings",
            () -> new DamagedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DAMAGED_DONUT_BOOTS = ITEMS.register("damaged_donut_boots",
            () -> new DamagedDonutArmorItem(ModArmorMaterials.DONUT, DonutArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.COMMON)));
    */
    public static final RegistryObject<Item> DONUT_BLOB_SPAWN_EGG = ITEMS.register("donut_blob_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DONUT_BLOB, 0x523000, 0xff4ac3, new Item.Properties()));


}
