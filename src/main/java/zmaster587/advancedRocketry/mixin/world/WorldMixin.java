package zmaster587.advancedRocketry.mixin.world;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zmaster587.advancedRocketry.atmosphere.AtmosphereHandler;

import java.util.List;

@Mixin(World.class)
public abstract class WorldMixin {
    @Inject(method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z", at = @At("TAIL"))
    private void handleAtmospheric(BlockPos pos, IBlockState newState, int flags, CallbackInfoReturnable<Boolean> cir) {
        AtmosphereHandler.onBlockChange((World) (Object) this, pos);
    }

    @Inject(method = "getCollisionBoxes(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/AxisAlignedBB;ZLjava/util/List;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos$PooledMutableBlockPos;release()V",
                    shift = At.Shift.AFTER), cancellable = true)
    private void returnEarly(Entity entityIn, AxisAlignedBB aabb, boolean p_191504_3_, List<AxisAlignedBB> outList, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!outList.isEmpty());
    }

    @Inject(method = "getRawLight",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos$PooledMutableBlockPos;release()V",
            shift = At.Shift.AFTER), cancellable = true)
    private void test(BlockPos pos, EnumSkyBlock lightType, CallbackInfoReturnable<Integer> cir, @Local(print = true) int var10) {
        cir.setReturnValue(var10);
    }
}
