package zmaster587.advancedRocketry.mixin.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zmaster587.advancedRocketry.atmosphere.AtmosphereHandler;

@Mixin(World.class)
public abstract class WorldMixin {
    @Inject(method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z", at = @At("TAIL"))
    private void handleAtmospheric(BlockPos pos, IBlockState newState, int flags, CallbackInfoReturnable<Boolean> cir) {
        AtmosphereHandler.onBlockChange((World) (Object) this, pos);
    }
}
