package net.denobody2.loungingdonuts.event;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.client.geo.ModSimpleGeoModel;
import net.denobody2.loungingdonuts.client.geo.ModSimpleGeoRenderer;
import net.denobody2.loungingdonuts.client.renderer.DonutBlobRenderer;
import net.denobody2.loungingdonuts.registry.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LoungingDonuts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        EntityRenderers.register(ModEntities.DONUT_BLOB.get(), DonutBlobRenderer::new);

    }
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers e) {
        // Geckolib models

        //e.registerEntityRenderer(ModEntities.DONUT_BLOB.get(), mgr -> new ModSimpleGeoRenderer<>(mgr, new ModSimpleGeoModel<>(new ResourceLocation(LoungingDonuts.MOD_ID, "donut_blob"))));
        //e.registerEntityRenderer(ModEntities.DONUT_HOLE.get(), mgr -> new SimpleGeoRenderer<>(mgr, new SimpleGeoModel<>(new ResourceLocation(Loungingdonuts.MOD_ID, "donut_hole"))));
    }
    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        //e.registerLayerDefinition(ModModelLayers.X, Xmodel::createBodyLayer);
    }
}
