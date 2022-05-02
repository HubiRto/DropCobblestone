package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Oaklog {

    static Main plugin;
    public Oaklog(Main m) {
        plugin = m;
    }

    public static ItemStack oaklog(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack oaklog = new ItemStack(Material.OAK_LOG);
        ItemMeta oaklog_meta = oaklog.getItemMeta();

        oaklog_meta.setDisplayName(ChatColor.GREEN + "Drewno");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "4.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "4-8" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".oaklog") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        oaklog_meta.setLore(lore);
        oaklog_meta.addEnchant(Enchantment.LUCK, 1, false);
        oaklog_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        oaklog.setItemMeta(oaklog_meta);

        return oaklog;
    }
}
