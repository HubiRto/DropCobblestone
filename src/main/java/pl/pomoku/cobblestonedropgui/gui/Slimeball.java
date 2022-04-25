package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Slimeball {

    static Main plugin;
    public Slimeball(Main m) {
        plugin = m;
    }

    public static ItemStack slimeball(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack slimeball = new ItemStack(Material.SLIME_BALL);
        ItemMeta slimeball_meta = slimeball.getItemMeta();

        slimeball_meta.setDisplayName(ChatColor.DARK_GRAY + "Slime");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "10.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-4" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".slimeball") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        slimeball_meta.setLore(lore);
        slimeball.setItemMeta(slimeball_meta);

        return slimeball;
    }
}
