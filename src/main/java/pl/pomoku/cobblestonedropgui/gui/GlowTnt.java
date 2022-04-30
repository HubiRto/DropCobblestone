package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class GlowTnt {

    static Main plugin;
    public GlowTnt(Main m) {
        plugin = m;
    }

    public static ItemStack glowtnt(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack glowtnt = new ItemStack(Material.TNT);
        ItemMeta glowtnt_meta = glowtnt.getItemMeta();

        glowtnt_meta.setDisplayName(ChatColor.DARK_GRAY + "Rzucane TNT");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.2%");
        lore.add(ChatColor.GRAY + "Rangi Premium: " + ChatColor.LIGHT_PURPLE + "+0.005%");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".throwtnt") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        glowtnt_meta.setLore(lore);
        glowtnt.setItemMeta(glowtnt_meta);

        return glowtnt;
    }
}
