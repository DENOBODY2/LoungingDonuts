package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LoungingDonuts.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("lounging_donuts", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.PINK_DONUT.get()))
            .title(Component.translatable("itemGroup.loungingdonuts"))
            .displayItems((pParameters, pOutput) -> {
                for (var item : ModItems.ITEMS.getEntries()) {
                    pOutput.accept(item.get());
                }
                /*for (var block: ModBlocks.BLOCKS.getEntries()){
                    pOutput.accept(block.get());
                }*/
            }).build());
}
