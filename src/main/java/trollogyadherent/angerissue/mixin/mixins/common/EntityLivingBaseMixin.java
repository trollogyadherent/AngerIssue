package trollogyadherent.angerissue.mixin.mixins.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import trollogyadherent.angerissue.AngerIssue;
import trollogyadherent.angerissue.config.Config;

@Mixin(value = EntityLivingBase.class)
public abstract class EntityLivingBaseMixin {
    private EntityLivingBase thiz() {
        return (EntityLivingBase)(Object)this;
    }

    @Inject(method = "attackEntityAsMob",
            at = @At("TAIL"),
            require = 1)
    public void attackEntityAsMob(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        //System.out.println("BRUH, entity is: " + entity.getClass().getCanonicalName());
        if (AngerIssue.varInstanceCommon.affectedMobs.contains(thiz().getClass().getCanonicalName())) {
            entity.attackEntityFrom(DamageSource.causeMobDamage(thiz()), Config.damage);
        }
    }
}
