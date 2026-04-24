package com.github.sladki.gtnhrates.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.github.sladki.gtnhrates.ModConfig;
import com.github.sladki.gtnhrates.Utils;
import com.gtnewhorizon.cropsnh.tileentity.TileEntityCropSticks;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

@Mixin(value = TileEntityCropSticks.class, remap = false)
public abstract class CropsNHCrops {

    @ModifyVariable(method = "harvest", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private double scaleDropMultiplier(double dropMultiplier) {
        return dropMultiplier * ModConfig.Rates.ic2CropsYield;
    }

    @ModifyReturnValue(method = "calcGrowthRate", at = @At("RETURN"))
    private int scaleGrowthRate(int original) {
        return Utils.applyRate(original, ModConfig.Rates.cropsnhGrowthRate);
    }
}
