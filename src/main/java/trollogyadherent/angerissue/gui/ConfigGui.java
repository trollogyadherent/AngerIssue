package trollogyadherent.angerissue.gui;

import com.google.common.collect.ImmutableList;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import trollogyadherent.angerissue.AngerIssue;
import trollogyadherent.angerissue.Tags;
import trollogyadherent.angerissue.config.Config;

public class ConfigGui extends GuiConfig {

    private static IConfigElement ceGeneral = new ConfigElement(Config.config.getCategory(Config.Categories.general));

    public ConfigGui(GuiScreen parent) {
        //this.parentScreen = parent;
        super(parent, ImmutableList.of(ceGeneral), Tags.MODID, Tags.MODID, false, false, I18n.format(Tags.MODID + ".configgui.title"), AngerIssue.confFile.getAbsolutePath());
        AngerIssue.debug("Instantiating config gui");
    }

    @Override
    public void initGui()
    {
        // You can add buttons and initialize fields here
        super.initGui();
        AngerIssue.debug("Initializing config gui");
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton b) {
        AngerIssue.debug("Config button id " + b.id + " pressed");
        super.actionPerformed(b);
        /* "Done" button */
        if (b.id == 2000) {
            /* Syncing config */
            Config.synchronizeConfigurationClient(AngerIssue.confFile, true, false);
        }
    }

}
