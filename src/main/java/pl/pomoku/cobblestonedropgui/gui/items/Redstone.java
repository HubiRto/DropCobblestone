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

public class Redstone {

    static Main plugin;
    public Redstone(Main m) {
        plugin = m;
    }

    public static ItemStack redstone(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemMeta redstone_meta = redstone.getItemMeta();

        redstone_meta.setDisplayName(ChatColor.DARK_GRAY + "Redstone");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "11.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-5" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".redstone") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            redstone_meta.addEnchant(Enchantment.LUCK, 1, false);
            redstone_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        redstone_meta.setLore(lore);
        redstone.setItemMeta(redstone_meta);

        return redstone;
    }
}
