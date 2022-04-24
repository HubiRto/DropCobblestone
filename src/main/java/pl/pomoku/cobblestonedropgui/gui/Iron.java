package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Iron {

    static Main plugin;
    public Iron(Main m) {
        plugin = m;
    }

    public static ItemStack iron(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta iron_meta = iron.getItemMeta();

        iron_meta.setDisplayName(ChatColor.DARK_GRAY + "Sztabka zelaza");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".iron") == "true") {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.GREEN + "Tak");
        }else {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.RED + "Nie");
        }
        lore.add(" ");

        iron_meta.setLore(lore);
        iron.setItemMeta(iron_meta);

        return iron;
    }
}
