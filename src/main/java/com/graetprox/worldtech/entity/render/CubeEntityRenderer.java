package com.graetprox.worldtech.entity.render;

import com.graetprox.worldtech.entity.CubeEntity;
import com.graetprox.worldtech.entity.model.CubeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {

    public CubeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CubeEntityModel(), 0.5f);
        System.out.print("CubeEntity render struce method created");
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("worldtech", "textures/entity/cube/cube.png");
    }

    @Override
    public void render(CubeEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        System.out.println("Cube render lodaded");
    }
}