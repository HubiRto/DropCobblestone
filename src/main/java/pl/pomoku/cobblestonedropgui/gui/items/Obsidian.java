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

public class Obsidian {

    static Main plugin;
    public Obsidian(Main m) {
        plugin = m;
    }

    public static ItemStack obsidian(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ItemMeta obsidian_meta = obsidian.getItemMeta();

        obsidian_meta.setDisplayName(ChatColor.DARK_GRAY + "Obsydian");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "9.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".obsidian") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            obsidian_meta.addEnchant(Enchantment.LUCK, 1, false);
            obsidian_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        obsidian_meta.setLore(lore);
        obsidian.setItemMeta(obsidian_meta);

        return obsidian;
    }
}
