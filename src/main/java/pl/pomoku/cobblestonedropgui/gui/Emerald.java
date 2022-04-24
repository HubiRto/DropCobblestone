package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Emerald {

    static Main plugin;
    public Emerald(Main m) {
        plugin = m;
    }

    public static ItemStack emerald(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emerald_meta = emerald.getItemMeta();

        emerald_meta.setDisplayName(ChatColor.DARK_GRAY + "Emerald");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".emerald") == "true") {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.GREEN + "Tak");
        }else {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.RED + "Nie");
        }
        lore.add(" ");
        
        emerald_meta.setLore(lore);
        emerald.setItemMeta(emerald_meta);

        return emerald;
    }
}
