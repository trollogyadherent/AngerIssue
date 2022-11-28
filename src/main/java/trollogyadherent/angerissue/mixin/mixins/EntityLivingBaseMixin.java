package trollogyadherent.angerissue.mixin.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = EntityLivingBase.class)
public class EntityLivingBaseMixin {
    @Inject(method = "attackEntityAsMob",
            at = @At("HEAD"),
            require = 1,
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void attackEntityAsMob(Entity p_70652_1_, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("BRUH");
    }
}
