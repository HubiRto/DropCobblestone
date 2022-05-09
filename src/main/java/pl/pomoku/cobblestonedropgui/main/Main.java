package pl.pomoku.cobblestonedropgui.main;

//import net.md_5.bungee.api.ChatColor;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pomoku.cobblestonedropgui.cmds.DropCmds;
import pl.pomoku.cobblestonedropgui.cmds.AddItem;
import pl.pomoku.cobblestonedropgui.events.*;
import pl.pomoku.cobblestonedropgui.gui.items.*;
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
        new AddItem(this);

        new Cobblestone(this);
        new Limestainedglasspane(this);
        new Blackstainedglasspane(this);
        new Redstainedglasspane(this);
        new Diamond(this);
        new Redstone(this);
        new Tnt(this);
        new Slimeball(this);
        new Oaklog(this);
        new Netherite(this);
        new ThrowTnt(this);
        new Enderpearl(this);
        new Enderchest(this);
        new Coal(this);
        new Chest(this);
        new Bookshelf(this);
        new Arrow(this);
        new Apple(this);
        new Shulker(this);

        getServer().getPluginManager().registerEvents(new OnPlace(this), this);
        getServer().getPluginManager().registerEvents(new OnBreak(this), this);
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        getServer().getPluginManager().registerEvents(new TntSystem(), this);

        getServer().getPluginManager().registerEvents(new OnInventoryClick(this), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickForUltraBlockGui(this), this);
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
