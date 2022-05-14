package pl.pomoku.cobblestonedropgui.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.main.Main;

public class Reload implements CommandExecutor {

    Main plugin;

    public Reload(Main m) {
        plugin = m;
        m.getCommand("reloadd").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PlayerDropConfig.reload();
        sender.sendMessage(ChatColor.GREEN + "Poprawnie odswierzono plugin!");
        return true;
    }
}
