package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Hopper {

    static Main plugin;
    public Hopper(Main m) {
        plugin = m;
    }

    public static ItemStack hopper(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta hopper_meta = hopper.getItemMeta();

        hopper_meta.setDisplayName(ChatColor.DARK_GRAY + "Dropdoeq");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".eq") == "true") {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.RED + "Nie");
        }else {
            lore.add(ChatColor.WHITE + "Aktywny: " + ChatColor.GREEN + "Tak");
        }
        lore.add(" ");

        hopper_meta.setLore(lore);
        hopper.setItemMeta(hopper_meta);

        return hopper;
    }
}
