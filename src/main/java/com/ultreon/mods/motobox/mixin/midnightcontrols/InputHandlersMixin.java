package com.ultreon.mods.motobox.mixin.midnightcontrols;

import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.util.midnightcontrols.AutomobilityMidnightControls;
import eu.midnightdust.midnightcontrols.client.controller.ButtonBinding;
import eu.midnightdust.midnightcontrols.client.controller.InputHandlers;
import net.minecraft.client.MinecraftClient;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Pseudo
@Mixin(value = InputHandlers.class, remap = false)
public class InputHandlersMixin {
    @Inject(method = "inGame", at = @At("HEAD"), cancellable = true)
    private static void automobility$makeAutomobileInputsWork(@NotNull MinecraftClient client, @NotNull ButtonBinding binding, CallbackInfoReturnable<Boolean> cir) {
        var player = client.player;
        if (!(player == null || !(player.getVehicle() instanceof AutomobileEntity))) {
            for (ButtonBinding ab : AutomobilityMidnightControls.AUTOMOBILITY_BINDINGS) {
                if (Arrays.equals(ab.getButton(), binding.getButton())) cir.setReturnValue(false);
            }
        }
    }
}
