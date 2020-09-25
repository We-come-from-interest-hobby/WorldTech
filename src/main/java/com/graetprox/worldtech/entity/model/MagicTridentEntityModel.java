package com.graetprox.worldtech.entity.model;

import com.graetprox.worldtech.entity.MagicTridentEntity;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;

public class MagicTridentEntityModel extends Model {
    private final ModelPart field_3593 = new ModelPart(32, 32, 0, 6);

    public MagicTridentEntityModel() {
        super(RenderLayer::getEntitySolid);
        this.field_3593.addCuboid(-0.5F, 2.0F, -0.5F, 1.0F, 25.0F, 1.0F, 0.0F);
        ModelPart modelPart = new ModelPart(32, 32, 4, 0);
        modelPart.addCuboid(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 1.0F);
        this.field_3593.addChild(modelPart);
        ModelPart modelPart2 = new ModelPart(32, 32, 4, 3);
        modelPart2.addCuboid(-2.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F);
        this.field_3593.addChild(modelPart2);
        ModelPart modelPart3 = new ModelPart(32, 32, 0, 0);
        modelPart3.addCuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F);
        this.field_3593.addChild(modelPart3);
        ModelPart modelPart4 = new ModelPart(32, 32, 4, 3);
        modelPart4.mirror = true;
        modelPart4.addCuboid(1.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F);
        this.field_3593.addChild(modelPart4);
        System.out.println("Magic_trident model loaded");
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.field_3593.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
