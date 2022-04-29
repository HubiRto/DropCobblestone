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

public class Apple {

    static Main plugin;
    public Apple(Main m) {
        plugin = m;
    }

    public static ItemStack apple(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack apple = new ItemStack(Material.APPLE);
        ItemMeta apple_meta = apple.getItemMeta();

        apple_meta.setDisplayName(ChatColor.DARK_GRAY + "Jablko");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "8.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-3" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".apple") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        apple_meta.setLore(lore);
        apple_meta.addEnchant(Enchantment.LUCK, 1, false);
        apple_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        apple.setItemMeta(apple_meta);

        return apple;
    }
}
