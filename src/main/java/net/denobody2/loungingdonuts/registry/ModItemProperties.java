package net.denobody2.loungingdonuts.registry;


import net.denobody2.loungingdonuts.LoungingDonuts;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        /*ItemProperties.register(ModItems.INFUSED_DONUT_KNIFE.get(), new ResourceLocation(LoungingDonuts.MOD_ID, "infusion"),
                (pStack, pLevel, pEntity, pSeed) -> pStack.getTag() ? 1f : 0f);

         */
        ItemProperties.register(ModItems.DONUT_SHIELD.get(), new ResourceLocation("blocking"), (p_174575_, p_174576_, p_174577_, p_174578_) -> {
            return p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F;
        });
    }



}