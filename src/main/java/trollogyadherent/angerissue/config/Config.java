package trollogyadherent.angerissue.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import trollogyadherent.angerissue.AngerIssue;
import trollogyadherent.angerissue.Util;
import trollogyadherent.configmaxxing.configpickers.mob.MobEntryPoint;

import java.io.File;

public class Config {
    public static Configuration config = new Configuration(AngerIssue.confFile);
    static boolean loaded = false;
    
    private static class Defaults {
        public static final String  mobList[] = new String[0];
        public static final float   damage = 1;
    }

    public static class Categories {
        public static final String general = "general";
    }

    public static String  mobList[] = Defaults.mobList;
    public static float   damage = Defaults.damage;


    public static void synchronizeConfigurationClient(File configFile, boolean force, boolean load) {
        if (!loaded || force) {
            if (load) {
                config.load();
            }
            loaded = true;

            synchronizeConfigurationCommon();

        }
        if(config.hasChanged()) {
            config.save();
        }
    }

    public static void synchronizeConfigurationServer(File configFile, boolean force) {
        if (!loaded || force) {
            if (loaded) {
                config.load();
            }
            loaded = true;

            synchronizeConfigurationCommon();
        }
        if(config.hasChanged()) {
            config.save();
        }
    }

    public static void synchronizeConfigurationCommon() {
        Property mobListProperty = config.get(Categories.general, "mobList", Defaults.mobList, "List of mobs being able to deal damage.");
        if (!Util.isServer() && AngerIssue.varInstanceClient.configMaxxingLoaded) {
            mobListProperty.setConfigEntryClass(MobEntryPoint.class);
        }
        mobList = mobListProperty.getStringList();

        Property damageProperty  = config.get(Categories.general, "damage", Defaults.damage, "How much damage affected mobs deal.");
        damage = (float) damageProperty.getDouble();

        if(config.hasChanged()) {
            config.save();
        }
        AngerIssue.varInstanceCommon.updateAffectedMobs();
    }
}