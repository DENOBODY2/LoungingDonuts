package net.denobody2.loungingdonuts.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EnchantedDonutItem extends Item {

    public EnchantedDonutItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
