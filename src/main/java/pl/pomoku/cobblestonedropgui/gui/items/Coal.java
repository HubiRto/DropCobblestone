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

public class Coal {

    static Main plugin;
    public Coal(Main m) {
        plugin = m;
    }

    public static ItemStack coal(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack coal = new ItemStack(Material.COAL);
        ItemMeta coal_meta = coal.getItemMeta();

        coal_meta.setDisplayName(ChatColor.DARK_GRAY + "Wegiel");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "14.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "3-5" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".coal") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        coal_meta.setLore(lore);
        coal_meta.addEnchant(Enchantment.LUCK, 1, false);
        coal_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        coal.setItemMeta(coal_meta);

        return coal;
    }
}
