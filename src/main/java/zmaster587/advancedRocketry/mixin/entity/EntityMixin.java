package zmaster587.advancedRocketry.mixin.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityTNTPrimed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zmaster587.advancedRocketry.util.GravityHandler;

@Mixin(value = {Entity.class, EntityMinecart.class, EntityFallingBlock.class, EntityTNTPrimed.class})
public abstract class EntityMixin {

    @Inject(method = "onUpdate", at = @At(value = "HEAD"))
    private void handleGravity(CallbackInfo ci) {
        GravityHandler.applyGravity((Entity) (Object) this);
    }
}
