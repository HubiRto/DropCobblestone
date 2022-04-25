package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Iron {

    static Main plugin;
    public Iron(Main m) {
        plugin = m;
    }

    public static ItemStack iron(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta iron_meta = iron.getItemMeta();

        iron_meta.setDisplayName(ChatColor.DARK_GRAY + "Zelazo");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "18.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-4" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".iron") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        iron_meta.setLore(lore);
        iron.setItemMeta(iron_meta);

        return iron;
    }
}
