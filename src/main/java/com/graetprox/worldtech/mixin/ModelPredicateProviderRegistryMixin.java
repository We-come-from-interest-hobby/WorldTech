package com.graetprox.worldtech.mixin;

import net.minecraft.client.gui.screen.options.AccessibilityOptionsScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelPredicateProviderRegistry.class)
public class ModelPredicateProviderRegistryMixin {
    @Inject(at = @At("HEAD") , method = "init()V")
    public void initx(CallbackInfo ci){

    }
}
