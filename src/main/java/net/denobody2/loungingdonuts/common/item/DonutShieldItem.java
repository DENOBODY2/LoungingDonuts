package net.denobody2.loungingdonuts.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class DonutShieldItem extends ShieldItem {
    private final Multimap<Attribute, AttributeModifier> donutShieldAttributes;
    public DonutShieldItem(Properties pProperties) {
        super(pProperties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.fromString("F9AB505F-B93A-4fAB-B594-91413A8EA9E0"), "Tool modifier", 0.05F, AttributeModifier.Operation.ADDITION));
        this.donutShieldAttributes = builder.build();
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        return super.onBlockStartBreak(itemstack, pos, player);
    }
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.donutShieldAttributes : super.getDefaultAttributeModifiers(equipmentSlot);
    }
}
