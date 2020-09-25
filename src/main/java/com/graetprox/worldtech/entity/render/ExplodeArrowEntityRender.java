package com.graetprox.worldtech.entity.render;

import com.graetprox.worldtech.entity.ExplodeArrowEntity;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class ExplodeArrowEntityRender extends ProjectileEntityRenderer<ExplodeArrowEntity> {

    public ExplodeArrowEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(ExplodeArrowEntity entity) {
        return TEXTURE;
    }

    public static final Identifier TEXTURE = new Identifier("textures/entity/projectiles/arrow.png");
    public static final Identifier TIPPED_TEXTURE = new Identifier("textures/entity/projectiles/tipped_arrow.png");

}
