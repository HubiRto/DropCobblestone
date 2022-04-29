package pl.pomoku.cobblestonedropgui.gui;

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

public class Netherite {

    static Main plugin;
    public Netherite(Main m) {
        plugin = m;
    }

    public static ItemStack netherite(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta netherite_meta = netherite.getItemMeta();

        netherite_meta.setDisplayName(ChatColor.DARK_GRAY + "netherite");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.1%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".netherite") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        netherite_meta.setLore(lore);
        netherite_meta.addEnchant(Enchantment.LUCK, 1, false);
        netherite_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        netherite.setItemMeta(netherite_meta);

        return netherite;
    }
}
