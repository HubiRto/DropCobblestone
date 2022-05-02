package pl.pomoku.cobblestonedropgui.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.pomoku.cobblestonedropgui.gui.OpenGui;
import pl.pomoku.cobblestonedropgui.main.Main;

public class DropCmds implements CommandExecutor {

    Main plugin;

    public DropCmds(Main m) {
        plugin = m;
        m.getCommand("drop").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command arg1, @NotNull String arg2, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            OpenGui.OpenGui(p);
        }else {
            sender.sendMessage("§cNie można wykonać tej komendy z konsoli!");
        }
        return false;
    }
}
