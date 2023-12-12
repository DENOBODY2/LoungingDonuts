package net.denobody2.loungingdonuts.event;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.common.entity.DonutBlob;
import net.denobody2.loungingdonuts.registry.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LoungingDonuts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerAttributes(final EntityAttributeCreationEvent e) {
        e.put(ModEntities.DONUT_BLOB.get(), DonutBlob.setAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.DONUT_BLOB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DonutBlob::checkSlimeSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
