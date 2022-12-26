package trollogyadherent.angerissue.varinstances;

import trollogyadherent.angerissue.Util;
import trollogyadherent.angerissue.config.Config;

import java.util.HashSet;

public class VarInstanceCommon {
    public HashSet<String> affectedMobs = new HashSet<>();

    public void updateAffectedMobs() {
        for (String mobName : Config.mobList) {
            affectedMobs.add(Util.getClassByName(mobName));
        }
    }
}
