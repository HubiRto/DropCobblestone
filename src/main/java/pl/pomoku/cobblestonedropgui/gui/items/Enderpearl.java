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

public class Enderpearl {

    static Main plugin;
    public Enderpearl(Main m) {
        plugin = m;
    }

    public static ItemStack enderpearl(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enderpearl_meta = enderpearl.getItemMeta();

        enderpearl_meta.setDisplayName(ChatColor.DARK_GRAY + "Perla");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.2%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".enderpearl") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            enderpearl_meta.addEnchant(Enchantment.LUCK, 1, false);
            enderpearl_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        enderpearl_meta.setLore(lore);
        enderpearl.setItemMeta(enderpearl_meta);

        return enderpearl;
    }
}
