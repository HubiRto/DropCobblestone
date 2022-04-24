package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".obsidian") == "true") {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.GREEN + "Tak");
        }else {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.RED + "Nie");
        }
        lore.add(" ");

        obsidian_meta.setLore(lore);
        obsidian.setItemMeta(obsidian_meta);

        return obsidian;
    }
}
