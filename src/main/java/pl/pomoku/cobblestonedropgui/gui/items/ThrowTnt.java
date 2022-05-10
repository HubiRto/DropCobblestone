package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class ThrowTnt {

    static Main plugin;
    public ThrowTnt(Main m) {
        plugin = m;
    }

    public static ItemStack throwtnt(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack throwtnt = new ItemStack(Material.TNT);
        ItemMeta throwtnt_meta = throwtnt.getItemMeta();

        throwtnt_meta.setDisplayName(ChatColor.DARK_GRAY + "Rzucane TNT");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.2%");
        lore.add(ChatColor.GRAY + "Rangi Premium: " + ChatColor.LIGHT_PURPLE + "+0.005%");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".throwtnt") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        throwtnt_meta.setLore(lore);
        throwtnt.setItemMeta(throwtnt_meta);

        return throwtnt;
    }
}
