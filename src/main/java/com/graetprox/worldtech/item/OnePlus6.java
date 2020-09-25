package com.graetprox.worldtech.item;

import com.graetprox.worldtech.WorldTech;
import com.graetprox.worldtech.gui.OnePlus6GUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class OnePlus6 extends Item {

    public OnePlus6(Settings settings) {
        super(settings);
    }
    BlockPos receiverPos;
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
       tooltip.add(new TranslatableText("item.worldtech.oneplus6.d").formatted(Formatting.GRAY));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            MinecraftClient.getInstance().openScreen(new OnePlus6GUI(new TranslatableText("op6")));
        }
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().getBlockState(context.getBlockPos()).getBlock() == WorldTech.remoteredstonereceiver){
            receiverPos = context.getBlockPos();
            context.getPlayer().sendMessage(new TranslatableText("successfull"), true);
        }
        return super.useOnBlock(context);
    }

    public BlockPos getReceiverPos(){
        return this.receiverPos;
    }
}
