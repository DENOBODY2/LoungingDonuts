package net.denobody2.loungingdonuts.client;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation DONUT_HOLE = create("donut_hole");


    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(LoungingDonuts.MOD_ID, name), "main");
    }
}
