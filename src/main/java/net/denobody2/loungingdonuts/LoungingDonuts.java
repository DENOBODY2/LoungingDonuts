package net.denobody2.loungingdonuts;

import com.mojang.logging.LogUtils;
import net.denobody2.loungingdonuts.registry.ModBlocks;
import net.denobody2.loungingdonuts.registry.ModCreativeTabs;
import net.denobody2.loungingdonuts.registry.ModEntities;
import net.denobody2.loungingdonuts.registry.ModItems;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.DelegatingPackResources;
import org.slf4j.Logger;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;


import java.nio.file.Path;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LoungingDonuts.MOD_ID)
public class LoungingDonuts
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "loungingdonuts";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


    public LoungingDonuts()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::packSetup);
        ModEntities.ENTITY_TYPES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code

    }
    public void packSetup(AddPackFindersEvent event) {
        // Resource Packs
        //this.setupRealisticPack(event);
    }
    private void setupRealisticPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(LoungingDonuts.MOD_ID).getFile().findResource("packs/realistic_donuts");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById(LoungingDonuts.MOD_ID).getFile().getFileName() + ":" + resourcePath, resourcePath, false);
            System.out.println("System.out.println READ THIS DENOBODY2!" + pack);
            Path baseResourcePath = ModList.get().getModFileById(LoungingDonuts.MOD_ID).getFile().findResource("packs/realistic_donuts");
            PathPackResources basePack = new PathPackResources(ModList.get().getModFileById(LoungingDonuts.MOD_ID).getFile().getFileName() + ":" + baseResourcePath, baseResourcePath, false);
            String name = "builtin/realistic_donuts";
            String title = "pack.loungingdonuts.realistic_donuts.title";
            String description = "pack.loungingdonuts.realistic_donuts.description";
            List<PathPackResources> mergedPacks = List.of(pack,basePack);
            Pack.ResourcesSupplier resourcesSupplier =(string) -> new DelegatingPackResources(name, true, new PackMetadataSection(Component.translatable(description), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES)), mergedPacks);
            Pack.Info info = Pack.readPackInfo(name, resourcesSupplier);
            if (info != null) {
                event.addRepositorySource((source) ->
                        source.accept(Pack.create(
                                name,
                                Component.translatable(title),
                                false,
                                resourcesSupplier,
                                info,
                                PackType.CLIENT_RESOURCES,
                                Pack.Position.TOP,
                                false,
                                PackSource.BUILT_IN)
                        ));
            }
        }
    }

    // Add the example block item to the building blocks tab

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
