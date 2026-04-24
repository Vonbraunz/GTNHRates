package com.github.sladki.gtnhrates.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.github.sladki.gtnhrates.ModConfig;

import com.gtnewhorizon.cropsnh.tileentity.TileEntityCropSticks;

@Mixin(value = TileEntityCropSticks.class, remap = false)
public abstract class CropsNHCrops {

    @ModifyVariable(method = "harvest", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private double scaleDropMultiplier(double dropMultiplier) {
        return dropMultiplier * ModConfig.Rates.ic2CropsYield;
    }
}
