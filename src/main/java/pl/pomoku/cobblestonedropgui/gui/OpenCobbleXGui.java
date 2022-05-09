package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenCobbleXGui {
    public static void OpenCobbleXGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Drop z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        p.openInventory(inv);
    }
}
