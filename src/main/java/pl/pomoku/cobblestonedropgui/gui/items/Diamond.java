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

public class Diamond {

    static Main plugin;
    public Diamond(Main m) {
        plugin = m;
    }

    public static ItemStack diamond(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamond_meta = diamond.getItemMeta();

        diamond_meta.setDisplayName(ChatColor.DARK_GRAY + "Diament");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "13.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-3" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".diamond") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        diamond_meta.setLore(lore);
        diamond_meta.addEnchant(Enchantment.LUCK, 1, false);
        diamond_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        diamond.setItemMeta(diamond_meta);

        return diamond;
    }
}
