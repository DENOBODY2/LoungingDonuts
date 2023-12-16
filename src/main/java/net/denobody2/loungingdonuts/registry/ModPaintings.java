package net.denobody2.loungingdonuts.registry;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, LoungingDonuts.MOD_ID);

    public static final RegistryObject<PaintingVariant> AMETHYST_DONUT = PAINTING_VARIANT_DEFERRED_REGISTER.register("amethyst_donut", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> BLUE_DONUT = PAINTING_VARIANT_DEFERRED_REGISTER.register("blue_donut", () -> new PaintingVariant(32, 16));

    public static void register(IEventBus eventBus){
        PAINTING_VARIANT_DEFERRED_REGISTER.register(eventBus);
    }
}
