package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
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
        item0_meta.addEnchant(Enchantment.LUCK, 1, false);
        item0_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[0].setItemMeta(item0_meta);

        ItemMeta item1_meta = items[1].getItemMeta();
        item1_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Zelaza");
        item1_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + "zelaza to mozesz je zamienic na bloki zelaza!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item1_meta.addEnchant(Enchantment.LUCK, 1, false);
        item1_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[1].setItemMeta(item1_meta);

        ItemMeta item2_meta = items[2].getItemMeta();
        item2_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Zlota");
        item2_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + "zlota to mozesz je zamienic na bloki zlota!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item2_meta.addEnchant(Enchantment.LUCK, 1, false);
        item2_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[2].setItemMeta(item2_meta);

        ItemMeta item3_meta = items[3].getItemMeta();
        item3_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Szmaragdow");
        item3_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 szmaragdow", ChatColor.GRAY + "to mozesz je zamienic na bloki szmaragdow!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item3_meta.addEnchant(Enchantment.LUCK, 1, false);
        item3_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[3].setItemMeta(item3_meta);

        ItemMeta item4_meta = items[4].getItemMeta();
        item4_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Redstona");
        item4_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 redstona", ChatColor.GRAY + "to mozesz je zamienic na bloki redstona!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item4_meta.addEnchant(Enchantment.LUCK, 1, false);
        item4_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[4].setItemMeta(item4_meta);

        ItemMeta item5_meta = items[5].getItemMeta();
        item5_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Wegla");
        item5_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 wegla", ChatColor.GRAY + "to mozesz je zamienic na bloki wegla!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item5_meta.addEnchant(Enchantment.LUCK, 1, false);
        item5_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[5].setItemMeta(item5_meta);

        ItemMeta item6_meta = items[6].getItemMeta();
        item6_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "AutoFosa");
        item6_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow szmaragdow", ChatColor.GRAY + "+ 1 blok diamentow to mozesz je zamienic na auto fose!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item6_meta.addEnchant(Enchantment.LUCK, 1, false);
        item6_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[6].setItemMeta(item6_meta);

        ItemMeta item7_meta = items[7].getItemMeta();
        item7_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        item7_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow obsydianu", ChatColor.GRAY + "+ 1 blok szmaragdow to mozesz je zamienic na boy farmera!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item7_meta.addEnchant(Enchantment.LUCK, 1, false);
        item7_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[7].setItemMeta(item7_meta);

        ItemMeta item8_meta = items[8].getItemMeta();
        item8_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        item8_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow piasku", ChatColor.GRAY + "+ 1 blok szmaragdow to mozesz je zamienic na boy farmera!", " ", ChatColor.YELLOW + "Kliknij, aby zamienic!"));
        item8_meta.addEnchant(Enchantment.LUCK, 1, false);
        item8_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[8].setItemMeta(item8_meta);

        for(int i = 0; i < 9; i++) {
            inv.setItem(i, items[i]);
        }

        p.openInventory(inv);
    }
}
