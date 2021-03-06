package pl.pomoku.cobblestonedropgui.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pomoku.cobblestonedropgui.cmds.DropCmds;
import pl.pomoku.cobblestonedropgui.cmds.AddItem;
import pl.pomoku.cobblestonedropgui.cmds.Reload;
import pl.pomoku.cobblestonedropgui.cmds.tab_compliters.AddItemCompliter;
import pl.pomoku.cobblestonedropgui.events.*;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenAutoCraftGui;
import pl.pomoku.cobblestonedropgui.items.Items;
import pl.pomoku.cobblestonedropgui.recipes.CustomRecipes;
import pl.pomoku.cobblestonedropgui.system.TntSystem;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main main;

    @Override
    public void onEnable() {
        main = this;


        new OnInventoryClickForCobbleXGui(this);
        new AddItem(this);
        new OnPlaceCustomBlock_A_B_S(this);
        new OpenAutoCraftGui(this);

        //Loading
        startConsoleMes();
        loadConfig();
        loadCustomRecipes();

        //Commands
        new DropCmds(this);
        new Reload(this);
        new AddItem(this);

        //Items
        new Items(this);

        //Compliter's
        new AddItemCompliter(this);

        //OnPlace
        getServer().getPluginManager().registerEvents(new OnPlaceStoneGen(this), this);
        getServer().getPluginManager().registerEvents(new OnPlaceForUltraBlock(this), this);
        getServer().getPluginManager().registerEvents(new OnPlaceForCobbleX(this), this);
        getServer().getPluginManager().registerEvents(new OnPlaceCustomBlock_A_B_S(this), this);

        //System's
        getServer().getPluginManager().registerEvents(new OnBreak(this), this);
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        getServer().getPluginManager().registerEvents(new TntSystem(), this);

        //OnInventoryClickEvent's
        getServer().getPluginManager().registerEvents(new OnInventoryClickForDropGui(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForUltraBlockGui(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForCobbleXGui(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForAutoCraftGui(this), this);
        getServer().getPluginManager().registerEvents(new AutoCraft(this), this);

        getServer().getPluginManager().registerEvents(new BlockAnvilsCustomBlock(this), this);



    }

    @Override
    public void onDisable() {
        endConsoleMes();
    }

    public void loadConfig(){
        //getConfig().options().copyDefaults(true);
        //saveConfig();
        File file = new File("plugins/CobbleStoneDropGUI", "config.yml");
        if(file.exists()) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plik config.yml sie wczytal!");
        }else {
            saveDefaultConfig();
            getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Plik config.yml zostal utworzony!");
        }


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
        items.stoniarka();
    }
    public void startConsoleMes() {
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "DropCobblestone v1.0 by" + ChatColor.DARK_PURPLE + " HubiRto");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Action:" + ChatColor.GREEN + " Enabling" + ChatColor.GRAY + "...");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=============================");
        getServer().getConsoleSender().sendMessage(" ");
    }
    public void endConsoleMes() {
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
