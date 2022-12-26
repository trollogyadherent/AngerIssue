package trollogyadherent.angerissue;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.EntityList;

public class Util {
    public static boolean isServer() {
        return FMLCommonHandler.instance().getSide() == Side.SERVER;
    }
    public static String getClassByName(String name) {
        Object res = EntityList.stringToClassMapping.get(name);
        if (res != null) {
            return ((Class) res).getCanonicalName();
        }
        return null;
    }
}
