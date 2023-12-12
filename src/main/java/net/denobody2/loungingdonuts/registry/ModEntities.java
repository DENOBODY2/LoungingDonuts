package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;

import net.denobody2.loungingdonuts.common.entity.DonutBlob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LoungingDonuts.MOD_ID);

    public static final RegistryObject<EntityType<DonutBlob>> DONUT_BLOB =
            ENTITY_TYPES.register("donut_blob", () -> EntityType.Builder.of(DonutBlob::new, MobCategory.MONSTER)
                    .sized(1.0F, 1.0F)
                    .setTrackingRange(16)
                    .updateInterval(1)
                    .build("donut_blob"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
