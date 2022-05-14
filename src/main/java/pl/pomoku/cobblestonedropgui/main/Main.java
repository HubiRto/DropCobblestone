package pl.pomoku.cobblestonedropgui.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pomoku.cobblestonedropgui.cmds.DropCmds;
import pl.pomoku.cobblestonedropgui.cmds.AddItem;
import pl.pomoku.cobblestonedropgui.cmds.Reload;
import pl.pomoku.cobblestonedropgui.cmds.tab_compliters.AddItemCompliter;
import pl.pomoku.cobblestonedropgui.events.*;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.system.TntSystem;

public final class Main extends JavaPlugin {

    public static Main main;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "DropCobblestone v1.0 by" + ChatColor.DARK_PURPLE + " HubiRto");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Action:" + ChatColor.GREEN + " Enabling" + ChatColor.GRAY + "...");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(" ");

        getConfig().options().copyDefaults(true);
        saveConfig();

        PlayerDropConfig.setup();
        PlayerDropConfig.get().options().copyDefaults(true);
        PlayerDropConfig.save();

        main = this;

        new OnBreak(this);
        new OnJoin(this);
        new OnInventoryClickForDropGui(this);

        new OpenDropGui(this);

        new DropCmds(this);
        new Reload(this);
        new AddItem(this);
        new AddItemCompliter(this);

        getServer().getPluginManager().registerEvents(new OnPlaceForUltraBlock(this), this);
        getServer().getPluginManager().registerEvents(new OnPlaceForCobbleX(this), this);

        getServer().getPluginManager().registerEvents(new OnBreak(this), this);
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        getServer().getPluginManager().registerEvents(new TntSystem(), this);

        getServer().getPluginManager().registerEvents(new OnInventoryClickForDropGui(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForUltraBlockGui(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForCobbleXGui(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "DropCobblestone v1.0 by" + ChatColor.DARK_PURPLE + " HubiRto");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Action:" + ChatColor.RED + " Disabling" + ChatColor.GRAY + "...");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(" ");
    }

    public static Main getMain() {
        return main;
    }
}
