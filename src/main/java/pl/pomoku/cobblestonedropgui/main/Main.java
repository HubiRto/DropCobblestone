package pl.pomoku.cobblestonedropgui.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pomoku.cobblestonedropgui.cmds.DropCmds;
import pl.pomoku.cobblestonedropgui.cmds.AddItem;
import pl.pomoku.cobblestonedropgui.cmds.Reload;
import pl.pomoku.cobblestonedropgui.cmds.tab_compliters.AddItemCompliter;
import pl.pomoku.cobblestonedropgui.events.*;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.recipes.CustomRecipes;
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

        loadConfig();
        loadCustomRecipes();

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

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();

        PlayerDropConfig.setup();
        PlayerDropConfig.get().options().copyDefaults(true);
        PlayerDropConfig.save();
    }

    public void loadCustomRecipes(){
        CustomRecipes items = new CustomRecipes();
        items.autoFosa();
        items.boyFarmer();
        items.sandFarmer();
        items.cobbleX();
        items.throwTnt();
    }

    public static Main getMain() {
        return main;
    }
}
