package pl.pomoku.cobblestonedropgui.main;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pomoku.cobblestonedropgui.cmds.DropCmds;
import pl.pomoku.cobblestonedropgui.events.OnBreak;
import pl.pomoku.cobblestonedropgui.events.OnInventoryClick;
import pl.pomoku.cobblestonedropgui.events.OnJoin;
import pl.pomoku.cobblestonedropgui.gui.*;

import java.lang.reflect.Field;

public final class Main extends JavaPlugin {

    public static Main main;

    @Override
    public void onEnable() {
        getLogger().info("Plugin sie uruchamia");

        getConfig().options().copyDefaults(true);
        saveConfig();

        main = this;

        new OnBreak(this);
        new OnJoin(this);
        new OnInventoryClick(this);

        new Emerald(this);
        new Gold(this);
        new Iron(this);
        new Obsidian(this);
        new Hopper(this);
        new DropCmds(this);
        new Cobblestone(this);
        new Limestainedglasspane(this);
        new Blackstainedglasspane(this);


        getServer().getPluginManager().registerEvents(new OnBreak(this), this);
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClick(this), this);


    }

    public static Main getMain() {
        return main;
    }


}
