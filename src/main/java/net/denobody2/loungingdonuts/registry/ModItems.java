package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.common.item.EnchantedGoldenDonutItem;
import net.denobody2.loungingdonuts.common.item.ModFoodProperties;
import net.minecraft.world.item.Item;
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
    public static final RegistryObject<Item> PINK_DONUT = ITEMS.register("pink_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.DONUT).stacksTo(64)));
    public static final RegistryObject<Item> BLUE_DONUT = ITEMS.register("blue_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.HAIR_DYE_DONUT).stacksTo(64)));
    public static final RegistryObject<Item> GOLD_DONUT = ITEMS.register("gold_donut",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.GOLD_DONUT).stacksTo(64)));
    public static final RegistryObject<Item> ENCHANTED_GOLD_DONUT = ITEMS.register("enchanted_gold_donut",
            ()-> new EnchantedGoldenDonutItem(new Item.Properties().food(ModFoodProperties.ENCHANTED_GOLD_DONUT).stacksTo(64)));

}
