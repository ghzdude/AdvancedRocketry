package zmaster587.advancedRocketry.mixin.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import zmaster587.advancedRocketry.util.RocketInventoryHelper;

@Mixin(EntityPlayer.class)
public abstract class PlayerMixin {

//    @Inject(method = "onUpdate",
//            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;onUpdate()V", shift = At.Shift.AFTER))
    @Redirect(method = "onUpdate",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/World;isRemote:Z", ordinal = 1))
    private boolean ignoreReach(World instance) {
        return instance.isRemote && !RocketInventoryHelper.allowAccess(this);
    }
}
