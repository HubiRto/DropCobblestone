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

public class Bookshelf {

    static Main plugin;
    public Bookshelf(Main m) {
        plugin = m;
    }

    public static ItemStack bookshelf(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
        ItemMeta bookshelf_meta = bookshelf.getItemMeta();

        bookshelf_meta.setDisplayName(ChatColor.DARK_GRAY + "Biblioteczka");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "4.0%");
        lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".bookshelf") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        bookshelf_meta.setLore(lore);
        bookshelf_meta.addEnchant(Enchantment.LUCK, 1, false);
        bookshelf_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bookshelf.setItemMeta(bookshelf_meta);

        return bookshelf;
    }
}
