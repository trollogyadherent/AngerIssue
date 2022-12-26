package trollogyadherent.angerissue.varinstances;

import cpw.mods.fml.common.Loader;

public class VarInstanceClient {
    public boolean configMaxxingLoaded;

    public void preInitHook() {
        configMaxxingLoaded = Loader.isModLoaded("configmaxxing");
    }
}
