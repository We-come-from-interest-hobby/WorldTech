package com.graetprox.worldtech.gui;

import com.graetprox.worldtech.WorldTech;
import com.graetprox.worldtech.block.RemoteRedstoneReceiver;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.AccessibilityOptionsScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class OnePlus6GUI extends Screen {

    private static final Identifier GUI_TEXTURE = new Identifier("worldtech:textures/gui/oneplus6gui.png");
    int guiDirectionx , guiDirectiony;
    public OnePlus6GUI(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        guiDirectionx = (this.width / 2) - 200;
        guiDirectiony = (this.height / 2) - 20;
        this.addButton(new TexturedButtonWidget(guiDirectionx + 5, guiDirectiony + 12, 30, 30, 79, 44, 31, GUI_TEXTURE, 256, 256, (buttonWidget) -> {
            BlockPos rrpos = WorldTech.oneplus6.getReceiverPos();
            if(rrpos != null && this.client.getServer().getOverworld().getBlockState(rrpos).getBlock() == WorldTech.remoteredstonereceiver){
                this.client.getServer().getOverworld().setBlockState(rrpos, this.client.getServer().getOverworld().getBlockState(rrpos).get(RemoteRedstoneReceiver.LIT)?this.client.getServer().getOverworld().getBlockState(rrpos).with(RemoteRedstoneReceiver.LIT,false):this.client.getServer().getOverworld().getBlockState(rrpos).with(RemoteRedstoneReceiver.LIT,true));
                this.client.player.sendMessage(new TranslatableText("switch"), true);
            }else{
                this.client.player.sendMessage(new TranslatableText("null"), true);
            }
        }));
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.client.getTextureManager().bindTexture(GUI_TEXTURE);
        //this.drawTexture(matrices, guiDirectionx, guiDirectiony, 0, 0, 74, 144);
        this.fillGradient(matrices, guiDirectionx, guiDirectiony, guiDirectionx+74, guiDirectiony+144, 0x88000000, 0x88000000);
        drawCenteredText(matrices, this.textRenderer, new TranslatableText("op6gui.title"), guiDirectionx + 40, guiDirectiony + 3, 16777215);
        //drawCenteredText(matrices, this.textRenderer, new TranslatableText("op6gui.button.redstone"), guiDirectionx + 5, guiDirectiony + 33, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 69) {
            this.onClose();
        }
        return true;
    }

    public boolean isPauseScreen() {
        return false;
    }
}
