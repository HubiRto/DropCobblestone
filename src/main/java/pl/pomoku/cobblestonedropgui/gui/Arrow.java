package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Arrow {

    static Main plugin;
    public Arrow(Main m) {
        plugin = m;
    }

    public static ItemStack arrow(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta arrow_meta = arrow.getItemMeta();

        arrow_meta.setDisplayName(ChatColor.DARK_GRAY + "Strzala");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.7%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".arrow") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        arrow_meta.setLore(lore);
        arrow.setItemMeta(arrow_meta);

        return arrow;
    }
}
