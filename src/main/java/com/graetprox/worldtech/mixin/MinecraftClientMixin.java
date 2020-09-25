package com.graetprox.worldtech.mixin;

import com.mojang.datafixers.util.Either;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.Window;
import net.minecraft.util.snooper.Snooper;
import net.minecraft.util.snooper.SnooperListener;
import net.minecraft.util.thread.MessageListener;
import net.minecraft.util.thread.ReentrantThreadExecutor;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin{
    public MinecraftClientMixin(RunArgs args) {

    }
    @Inject(at = @At("RETURN") , method = "getWindowTitle()Ljava/lang/String;", cancellable = true)
    private void getWindowTitle(CallbackInfoReturnable<String> cir) {
           cir.setReturnValue("Minecraft 2.0");
    }
}
