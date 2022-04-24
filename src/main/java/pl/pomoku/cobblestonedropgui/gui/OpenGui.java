package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenGui {
    public static void OpenGui(Player p) {
        Inventory i = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Drop z kamienia");

        ItemStack iron = Iron.iron(p);
        ItemStack gold = Gold.gold(p);
        ItemStack obsidian = Obsidian.obsidian(p);
        ItemStack emerald = Emerald.emerald(p);
        ItemStack hopper = Hopper.hopper(p);
        ItemStack cobblestone = Cobblestone.cobblestone(p);

        i.setItem(11, iron);
        i.setItem(12, gold);
        i.setItem(13, obsidian);
        i.setItem(14, emerald);
        i.setItem(0, hopper);
        i.setItem(1, cobblestone);

        p.openInventory(i);
    }
}
