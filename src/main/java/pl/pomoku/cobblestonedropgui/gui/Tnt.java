package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Tnt {

    static Main plugin;
    public Tnt(Main m) {
        plugin = m;
    }

    public static ItemStack tnt(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tnt_meta = tnt.getItemMeta();

        tnt_meta.setDisplayName(ChatColor.RED + "T" + ChatColor.WHITE + "N" + ChatColor.RED + "T");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.3%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-3" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".tnt") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        tnt_meta.setLore(lore);
        tnt.setItemMeta(tnt_meta);

        return tnt;
    }
}
