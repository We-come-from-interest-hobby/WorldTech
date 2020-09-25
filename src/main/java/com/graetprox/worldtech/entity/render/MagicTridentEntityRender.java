package com.graetprox.worldtech.entity.render;

import com.graetprox.worldtech.entity.MagicTridentEntity;
import com.graetprox.worldtech.entity.model.CubeEntityModel;
import com.graetprox.worldtech.entity.model.MagicTridentEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class MagicTridentEntityRender extends EntityRenderer<MagicTridentEntity> {

    public static final Identifier TEXTURE = new Identifier("minecraft:textures/entity/trident.png");
    private final TridentEntityModel model = new TridentEntityModel();

    public MagicTridentEntityRender(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
        System.out.print("MagicTridentEntity render struce method created");
    }

    @Override
    public void render(MagicTridentEntity tridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        System.out.println("Magic_trident render lodaded");
        matrixStack.push();
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, tridentEntity.prevYaw, tridentEntity.yaw) - 90.0F));
        matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, tridentEntity.prevPitch, tridentEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectGlintVertexConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(tridentEntity)), false, false);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(tridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(MagicTridentEntity tridentEntity) {
        return TEXTURE;
    }

}
