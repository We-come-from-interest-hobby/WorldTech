package com.graetprox.worldtech;

import com.graetprox.worldtech.block.RemoteRedstoneReceiver;
import com.graetprox.worldtech.entity.CubeEntity;
import com.graetprox.worldtech.entity.ExplodeArrowEntity;
import com.graetprox.worldtech.entity.MagicTridentEntity;
import com.graetprox.worldtech.entity.render.CubeEntityRenderer;
import com.graetprox.worldtech.entity.render.ExplodeArrowEntityRender;
import com.graetprox.worldtech.entity.render.MagicTridentEntityRender;
import com.graetprox.worldtech.item.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WorldTech implements ModInitializer {

    public static final String namespace="worldtech";
    public static final OnePlus6 oneplus6= new OnePlus6(new Item.Settings().group(WorldTech.ITEM_GROUP).maxCount(1));
    public static final ElectronicElytra electronicElytra=new ElectronicElytra(new Item.Settings().group(WorldTech.ITEM_GROUP).maxCount(1));
    public static final HandGun handgun=new HandGun(new Item.Settings().group(WorldTech.ITEM_GROUP).maxCount(1));
    public static final Item magic_ingot=new Item(new Item.Settings().group(WorldTech.ITEM_GROUP).maxCount(64));
    public static final MagicSword magic_sword = new MagicSword(ToolMaterials.DIAMOND,10,-1.0F, (new Item.Settings()).group(WorldTech.ITEM_GROUP));
    public static final ElectronicBow electronicBow = new ElectronicBow(new Item.Settings().group(WorldTech.ITEM_GROUP).maxCount(1));
    public static final Block remoteredstonereceiver=new RemoteRedstoneReceiver(FabricBlockSettings.of(Material.STONE).strength(5).requiresTool()./*透明*/nonOpaque());
    public static final Block magic_block=new Block(FabricBlockSettings.of(Material.STONE).strength(5).requiresTool());

    public static final EntityType<ExplodeArrowEntity> EXPLODE_ARROW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(namespace, "explode_arrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ExplodeArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build()
    );

    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("worldtech", "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<MagicTridentEntity> MAGIC_TRIDENT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("worldtech", "magic_trident"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, MagicTridentEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {

        FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());

        Registry.register(Registry.ITEM, new Identifier(namespace, "oneplus6"),oneplus6);
        Registry.register(Registry.ITEM, new Identifier(namespace, "electronic_elytra"),electronicElytra);
        Registry.register(Registry.ITEM, new Identifier(namespace, "handgun"),handgun);
        Registry.register(Registry.ITEM, new Identifier(namespace, "magic_ingot"),magic_ingot);
        Registry.register(Registry.ITEM, new Identifier(namespace, "magic_sword"),magic_sword);
        Registry.register(Registry.ITEM, new Identifier(namespace, "electronic_bow"),electronicBow);


        Registry.register(Registry.BLOCK, new Identifier(namespace, "remoteredstonereceiver"), remoteredstonereceiver);
        Registry.register(Registry.ITEM, new Identifier(namespace, "remoteredstonereceiver"), new BlockItem(remoteredstonereceiver, new Item.Settings().group(WorldTech.ITEM_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(namespace, "magic_block"), magic_block);
        Registry.register(Registry.ITEM, new Identifier(namespace, "magic_block"), new BlockItem(magic_block, new Item.Settings().group(WorldTech.ITEM_GROUP)));

        EntityRendererRegistry.INSTANCE.register(WorldTech.CUBE, (dispatcher, context) -> {
            return new CubeEntityRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(WorldTech.EXPLODE_ARROW, (dispatcher, context) -> {
            return new ExplodeArrowEntityRender(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(WorldTech.MAGIC_TRIDENT, (dispatcher, context) -> {
            return new MagicTridentEntityRender(dispatcher);
        });
    }
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(namespace, "main"))
            .icon(() -> new ItemStack(WorldTech.oneplus6))
            .appendItems(stacks ->
            {
                Item[] a = {oneplus6,electronicElytra,handgun,magic_ingot,magic_sword,electronicBow};
                Block[] b = {remoteredstonereceiver,magic_block};
                for(Item item : a){
                    stacks.add(new ItemStack(item));
                }
                for(Block block : b){
                    stacks.add(new ItemStack(block));
                }
            })
            .build();

   /* ModelPredicateProviderRegistry.register(Items.BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
        if (livingEntity == null) {
            return 0.0F;
        } else {
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (float)(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
        }
    });
    register(Items.BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
        return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
    });*/
}
