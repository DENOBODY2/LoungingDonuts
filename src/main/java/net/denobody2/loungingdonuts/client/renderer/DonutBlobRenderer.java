package net.denobody2.loungingdonuts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.denobody2.loungingdonuts.LoungingDonuts;
import net.denobody2.loungingdonuts.client.geo.DonutBlobModel;
import net.denobody2.loungingdonuts.common.entity.DonutBlob;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DonutBlobRenderer extends GeoEntityRenderer<DonutBlob> {
    public DonutBlobRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DonutBlobModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DonutBlob animatable) {
        return new ResourceLocation(LoungingDonuts.MOD_ID, "textures/entity/donut_blob.png");
    }

    @Override
    public void render(DonutBlob entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {


        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
