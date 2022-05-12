package pl.pomoku.cobblestonedropgui.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;

public class AddItem implements CommandExecutor {
    Main plugin;

    public AddItem(Main m) {
        plugin = m;
        m.getCommand("dodaj").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ItemStack ultra_block = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta ultra_block_meta = ultra_block.getItemMeta();
        ultra_block_meta.setDisplayName("§a§lUltra Block");
        List<String> ultra_block_lore = new ArrayList<>();
        ultra_block_lore.add("§7Jest to skrzynia z ktorej");
        ultra_block_lore.add("§7wypadaja bardzo cenne itemki.");
        ultra_block_lore.add(" ");
        ultra_block_lore.add("§ePostaw, aby otworzyc!");
        ultra_block_meta.setLore(ultra_block_lore);
        ultra_block.setItemMeta(ultra_block_meta);

        ItemStack sand_farmer = new ItemStack(Material.LIME_GLAZED_TERRACOTTA);
        ItemMeta sand_farmer_meta = sand_farmer.getItemMeta();
        sand_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        sand_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        sand_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sand_farmer.setItemMeta(sand_farmer_meta);

        ItemStack boy_farmer = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta boy_farmer_meta = boy_farmer.getItemMeta();
        boy_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        boy_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        boy_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boy_farmer.setItemMeta(boy_farmer_meta);

        ItemStack auto_fosa = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        ItemMeta auto_fosa_meta = auto_fosa.getItemMeta();
        auto_fosa_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
        auto_fosa_meta.addEnchant(Enchantment.LUCK, 1, true);
        auto_fosa_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        auto_fosa.setItemMeta(auto_fosa_meta);

        ItemStack cobblex = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta cobblex_meta = cobblex.getItemMeta();
        cobblex_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        cobblex_meta.addEnchant(Enchantment.LUCK, 1, true);
        cobblex_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cobblex.setItemMeta(cobblex_meta);

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(!(args.length == 0)) {
                switch(args[0]) {
                    case "Ultra Block":
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
                    default:
                        break;
                }
            }
        }else {
            sender.sendMessage("§cNie można wykonać tej komendy z konsoli!");
        }
        return false;
    }
}
