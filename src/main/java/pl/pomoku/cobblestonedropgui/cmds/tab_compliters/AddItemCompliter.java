package pl.pomoku.cobblestonedropgui.cmds.tab_compliters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;

public class AddItemCompliter implements TabCompleter {

    Main plugin;

    public AddItemCompliter(Main m) {
        plugin = m;
        m.getCommand("dodaj").setTabCompleter(this);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("dodaj")) {
            if(args.length == 1) {
                List<String> arguments = new ArrayList<>();
                arguments.add("UltraBlock");
                arguments.add("AutoFosa");
                arguments.add("BoyFarmer");
                arguments.add("SandFarmer");
                arguments.add("CobbleX");
                arguments.add("RzucaneTNT");
                arguments.add("Stoniarka");
                return arguments;
            }
        }
        return null;
    }
}
