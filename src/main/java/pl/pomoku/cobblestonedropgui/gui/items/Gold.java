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

public class Gold {

    static Main plugin;
    public Gold(Main m) {
        plugin = m;
    }

    public static ItemStack gold(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta gold_meta = gold.getItemMeta();

        gold_meta.setDisplayName(ChatColor.DARK_GRAY + "Zelazo");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "10.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-3" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".gold") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            gold_meta.addEnchant(Enchantment.LUCK, 1, false);
            gold_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        gold_meta.setLore(lore);
        gold.setItemMeta(gold_meta);

        return gold;
    }
}
