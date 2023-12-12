package net.denobody2.loungingdonuts.client.geo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ModSimpleGeoModel<T extends LivingEntity & GeoEntity> extends DefaultedEntityGeoModel<T> {
    public ModSimpleGeoModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }
}
