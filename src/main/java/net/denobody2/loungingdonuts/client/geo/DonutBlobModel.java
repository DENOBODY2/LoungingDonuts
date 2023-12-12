package net.denobody2.loungingdonuts.client.geo;

import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.common.entity.DonutBlob;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class DonutBlobModel extends GeoModel<DonutBlob> {
    @Override
    public ResourceLocation getModelResource(DonutBlob animatable) {
        return new ResourceLocation(LoungingDonuts.MOD_ID, "geo/donut_blob.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DonutBlob animatable) {
        return new ResourceLocation(LoungingDonuts.MOD_ID, "textures/entity/donut_blob.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DonutBlob animatable) {
        return new ResourceLocation(LoungingDonuts.MOD_ID, "animations/donut_blob.animation.json");
    }

    @Override
    public void setCustomAnimations(DonutBlob animatable, long instanceId, AnimationState<DonutBlob> animationState) {

    }

}
