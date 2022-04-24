package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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

        gold_meta.setDisplayName(ChatColor.DARK_GRAY + "Sztabka zlota");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".gold") == "true") {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.GREEN + "Tak");
        }else {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.RED + "Nie");
        }
        lore.add(" ");

        gold_meta.setLore(lore);
        gold.setItemMeta(gold_meta);

        return gold;
    }
}
