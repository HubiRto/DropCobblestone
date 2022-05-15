package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class OpenAutoCraftGui {
    public static void OpenAutoCraftGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Szybkie Craftowanie");

        ItemStack[] items = new ItemStack[9];
        items[0] = new ItemStack(Material.DIAMOND_BLOCK);
        items[1] = new ItemStack(Material.IRON_BLOCK);
        items[2] = new ItemStack(Material.GOLD_BLOCK);
        items[3] = new ItemStack(Material.EMERALD_BLOCK);
        items[4] = new ItemStack(Material.REDSTONE_BLOCK);
        items[5] = new ItemStack(Material.COAL_BLOCK);
        items[6] = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        items[7] = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        items[8] = new ItemStack(Material.LIME_GLAZED_TERRACOTTA);

        ItemMeta item0_meta = items[0].getItemMeta();
        item0_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Diamentu");
        item0_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 diamentow", ChatColor.GRAY + "to mozesz je zamienic na bloki diamentu!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        items[0].setItemMeta(item0_meta);

        inv.setItem(0, items[0]);
        p.openInventory(inv);
    }
}
