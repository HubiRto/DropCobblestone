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

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

        File file = new File("plugins/CobbleStoneDropGUI", "config.yml");
        FileConfiguration config = plugin.getConfig();
        List<String> mes_nie_mozna_wykonac_komendy_z_konsoli = config.getStringList("Komendy.Dodaj.Nie_mozna_wykonac_komendy_z_konsoli");
        List<String> dos_ultra_block = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Ultra_block");
        List<String> dos_sand_farmer = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Sand_farmer");
        List<String> dos_boy_farmer = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Boy_farmer");
        List<String> dos_auto_fosa = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Auto_fosa");
        List<String> dos_cobblex = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.CobbleX");
        List<String> dos_rzucane_tnt = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.RzucaneTNT");
        List<String> dos_stoniarka = config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Stoniarka");


        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!(args.length == 0)) {
                switch (args[0]) {
                    case "UltraBlock":
                        p.getInventory().addItem(ultra_block);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Ultra_block").isEmpty()) {
                                for (String s : dos_ultra_block) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Ultra Block!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Ultra Block!");
                        }
                        break;
                    case "SandFarmer":
                        p.getInventory().addItem(sand_farmer);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Sand_farmer").isEmpty()) {
                                for (String s : dos_sand_farmer) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Sand Farmera!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Sand Farmera!");
                        }
                        break;
                    case "BoyFarmer":
                        p.getInventory().addItem(boy_farmer);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Boy_farmer").isEmpty()) {
                                for (String s : dos_boy_farmer) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Boy Farmera!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Boy Farmera!");
                        }
                        break;
                    case "AutoFosa":
                        p.getInventory().addItem(auto_fosa);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Auto_fosa").isEmpty()) {
                                for (String s : dos_auto_fosa) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Auto Fose!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Auto Fose!");
                        }
                        break;
                    case "CobbleX":
                        p.getInventory().addItem(cobblex);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.CobbleX").isEmpty()) {
                                for (String s : dos_cobblex) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Cobble X!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Cobble X!");
                        }
                        break;
                    case "RzucaneTNT":
                        p.getInventory().addItem(throwtnt);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.RzucaneTNT").isEmpty()) {
                                for (String s : dos_rzucane_tnt) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Rzucane TnT!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Rzucane TnT!");
                        }
                        break;
                    case "Stoniarka":
                        p.getInventory().addItem(stoniarka);
                        if(file.exists()) {
                            if (!config.getStringList("Komendy.Dodaj.Dostawanie_przedmiotu.Stoniarka").isEmpty()) {
                                for (String s : dos_stoniarka) {
                                    p.sendMessage(s.replace("&", "??"));
                                }
                            }else {
                                p.sendMessage(ChatColor.GREEN + "Dostales Stoniarke!");
                            }
                        }else {
                            p.sendMessage(ChatColor.GREEN + "Dostales Stoniarke!");
                        }
                    default:
                        break;
                }
            }
        } else {
            if(file.exists()) {
                if (!config.getStringList("Komendy.Dodaj.Nie_mozna_wykonac_komendy_z_konsoli").isEmpty()) {
                    for (String s : mes_nie_mozna_wykonac_komendy_z_konsoli) {
                        sender.sendMessage(s.replace("&", "??"));
                    }
                }else {
                    sender.sendMessage("&cNie mozna wykonac tej komendy z konsoli!".replace("&", "??"));
                }
            }else{
                sender.sendMessage("&cNie mozna wykonac tej komendy z konsoli!".replace("&", "??"));
            }
        }
        return true;
    }
}
