package com.graetprox.worldtech.entity;

import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.world.World;

public class ExplodeArrowEntity extends ArrowEntity {

    public ExplodeArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }
}
