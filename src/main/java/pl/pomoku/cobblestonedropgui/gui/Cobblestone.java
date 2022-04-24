package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Cobblestone {

    static Main plugin;
    public Cobblestone(Main m) {
        plugin = m;
    }

    public static ItemStack cobblestone(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
        ItemMeta cobblestone_meta = cobblestone.getItemMeta();

        cobblestone_meta.setDisplayName(ChatColor.GREEN + "Wypadanie bruku");
        ArrayList<String> lore = new ArrayList<String>();

        if(plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
            lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.GREEN + "Tak");
        }else {
            lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.RED + "Nie");
        }
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        cobblestone_meta.setLore(lore);
        cobblestone.setItemMeta(cobblestone_meta);

        return cobblestone;
    }
}
