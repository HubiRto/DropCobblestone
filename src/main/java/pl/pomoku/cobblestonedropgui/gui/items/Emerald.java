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

public class Emerald {

    static Main plugin;
    public Emerald(Main m) {
        plugin = m;
    }

    public static ItemStack emerald(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emerald_meta = emerald.getItemMeta();

        emerald_meta.setDisplayName(ChatColor.DARK_GRAY + "Szmaragd");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "11.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".emerald") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        emerald_meta.setLore(lore);
        emerald_meta.addEnchant(Enchantment.LUCK, 1, false);
        emerald_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        emerald.setItemMeta(emerald_meta);

        return emerald;
    }
}
