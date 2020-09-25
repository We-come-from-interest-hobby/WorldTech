package com.graetprox.worldtech.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class OnePlus6GUIy extends Screen {

    private static final Identifier GUI_TEXTURE = new Identifier("worldtech:textures/gui/oneplus6gui.png");
    private boolean isMainHand = true;
    private int selectedApp = 0;

    public OnePlus6GUIy(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int selectOutlineColor = 0xFFFFFFFF;
        this.client.getTextureManager().bindTexture(GUI_TEXTURE);

        int xStart = 100;
        int xStartSelectOutline = xStart;
        int yStartSelectOutline = xStart;
        if(isMainHand){
            xStart = 370;
            xStartSelectOutline = xStart;
            yStartSelectOutline = xStart;
        }
        switch (selectedApp){
            case 0:
                xStartSelectOutline = xStart;
                yStartSelectOutline = xStart;
                break;
            case 1:
                xStartSelectOutline = xStartSelectOutline + 33;
                break;
            case 2:
                yStartSelectOutline = yStartSelectOutline + 33;
                break;
            case 3:
                xStartSelectOutline = xStartSelectOutline + 33;
                yStartSelectOutline = yStartSelectOutline + 33;
                break;
        }

        this.fillGradient(matrices, xStartSelectOutline + 5, 110, yStartSelectOutline+5+2, 110+30, selectOutlineColor, selectOutlineColor);
        this.fillGradient(matrices, xStartSelectOutline + 5, 110, yStartSelectOutline+5+30, 110+2, selectOutlineColor, selectOutlineColor);
        this.fillGradient(matrices, xStartSelectOutline + 5 +28, 110, yStartSelectOutline+5+30, 110+30, selectOutlineColor, selectOutlineColor);
        this.fillGradient(matrices, xStartSelectOutline + 5, 110+28, yStartSelectOutline+5+30, 110+30, selectOutlineColor, selectOutlineColor);

        this.fillGradient(matrices, xStart, 100, xStart+74, 244, 0x88000000, 0x88000000);

        this.fillGradient(matrices, xStart + 5, 110, xStart+5+30, 110+30, 0x880099FF, 0x880099FF);
        this.fillGradient(matrices, xStart + 5 + 30 + 3, 110, xStart+5+30+3+30, 110+30, 0x880099FF, 0x880099FF);
        this.fillGradient(matrices, xStart + 5, 110+30+3, xStart+5+30, 110+30+3+30, 0x880099FF, 0x880099FF);
        drawCenteredText(matrices, this.textRenderer, new TranslatableText("op6gui.title"), xStart, 100, 16777215);
        drawCenteredText(matrices, this.textRenderer, new TranslatableText("op6gui.button.redstone"+selectedApp), 100 + 5, 100 + 33, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 69) {
            this.onClose();
        }else if (keyCode == 76){
            this.onClose();
            MinecraftClient.getInstance().openScreen(new OnePlus6GUIy(new TranslatableText("op6")).isMainHand(true).selectedApp(this.selectedApp + 1));
        }
        return true;
    }

    public boolean isPauseScreen() {
        return false;
    }

    public OnePlus6GUIy isMainHand(boolean a){
        isMainHand = a;
        return this;
    }

    public OnePlus6GUIy selectedApp(int i){
        selectedApp = i;
        return this;
    }
}
