package pl.pomoku.cobblestonedropgui.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.pomoku.cobblestonedropgui.items.Items;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.List;

public class AddItem implements CommandExecutor {
    Main plugin;

    public AddItem(Main m) {
        plugin = m;
        m.getCommand("dodaj").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ItemStack ultra_block = Items.ultra_block();
        ItemStack boy_farmer = Items.boy_farmer();
        ItemStack sand_farmer = Items.sand_farmer();
        ItemStack auto_fosa = Items.auto_fosa();
        ItemStack cobblex = Items.cobblex();
        ItemStack throwtnt = Items.throwtnt();
        ItemStack stoniarka = Items.stoniarka();

        FileConfiguration config = plugin.getConfig();
        List<String> mes_nie_mozna_wykonac_komendy_z_konsoli = config.getStringList("Komendy.Dodaj.Nie_mozna_wykonac_komendy_z_konsoli");

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!(args.length == 0)) {
                switch (args[0]) {
                    case "UltraBlock":
                        p.getInventory().addItem(ultra_block);
                        p.sendMessage(ChatColor.GREEN + "Dostales ultra block!");
                        break;
                    case "SandFarmer":
                        p.getInventory().addItem(sand_farmer);
                        p.sendMessage(ChatColor.GREEN + "Dostales Sand Farmera!");
                        break;
                    case "BoyFarmer":
                        p.getInventory().addItem(boy_farmer);
                        p.sendMessage(ChatColor.GREEN + "Dostales Boy Farmera!");
                        break;
                    case "AutoFosa":
                        p.getInventory().addItem(auto_fosa);
                        p.sendMessage(ChatColor.GREEN + "Dostales Auto Fose!");
                        break;
                    case "CobbleX":
                        p.getInventory().addItem(cobblex);
                        p.sendMessage(ChatColor.GREEN + "Dostales Cobble X!");
                        break;
                    case "RzucaneTNT":
                        p.getInventory().addItem(throwtnt);
                        p.sendMessage(ChatColor.GREEN + "Dostales Rzucane TnT!");
                        break;
                    case "Stoniarka":
                        p.getInventory().addItem(stoniarka);
                        p.sendMessage(ChatColor.GREEN + "Dostales Stoniarke");
                    default:
                        break;
                }
            }
        } else {
            for (int a = 0; a < mes_nie_mozna_wykonac_komendy_z_konsoli.size(); a++) {
                sender.sendMessage(mes_nie_mozna_wykonac_komendy_z_konsoli.get(a).replace("&", "§"));
            }
        }
        return true;
    }
}
