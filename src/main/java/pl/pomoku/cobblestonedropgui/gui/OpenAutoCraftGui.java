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
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OpenAutoCraftGui {
    public static void OpenAutoCraftGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Szybkie Craftowanie");
        UUID uuid = p.getUniqueId();

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
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_diamond_block"), "true")){
            item0_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 diamentow", ChatColor.GRAY + "to bedzie je zamieniac na bloki diamentu!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item0_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 diamentow", ChatColor.GRAY + "to bedzie je zamieniac na bloki diamentu!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item0_meta.addEnchant(Enchantment.LUCK, 1, false);
        item0_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[0].setItemMeta(item0_meta);

        ItemMeta item1_meta = items[1].getItemMeta();
        item1_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Zelaza");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_iron_block"), "true")){
            item1_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + " zelaza to bedzie je zamieniac na bloki zelaza!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item1_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + "zelaza to bedzie je zamieniac na bloki zelaza!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item1_meta.addEnchant(Enchantment.LUCK, 1, false);
        item1_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[1].setItemMeta(item1_meta);

        ItemMeta item2_meta = items[2].getItemMeta();
        item2_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Zlota");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_gold_block"), "true")){
            item2_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + " zlota to bedzie je zamieniac na bloki zlota!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item2_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 sztabek", ChatColor.GRAY + "zlota to bedzie je zamieniac na bloki zlota!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item2_meta.addEnchant(Enchantment.LUCK, 1, false);
        item2_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[2].setItemMeta(item2_meta);

        ItemMeta item3_meta = items[3].getItemMeta();
        item3_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Szmaragdow");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_emerald_block"), "true")){
            item3_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 emeraldow", ChatColor.GRAY + "to bedzie je zamieniac na bloki emeraldow!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item3_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 emeraldow", ChatColor.GRAY + "to bedzie je zamieniac na bloki emeraldow!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item3_meta.addEnchant(Enchantment.LUCK, 1, false);
        item3_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[3].setItemMeta(item3_meta);

        ItemMeta item4_meta = items[4].getItemMeta();
        item4_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Redstona");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_redstone_block"), "true")){
            item4_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 redstona", ChatColor.GRAY + "to bedzie je zamieniac na bloki redstona!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item4_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 redstona", ChatColor.GRAY + "to bedzie je zamieniac na bloki redstona!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item4_meta.addEnchant(Enchantment.LUCK, 1, false);
        item4_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[4].setItemMeta(item4_meta);

        ItemMeta item5_meta = items[5].getItemMeta();
        item5_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blok Wegla");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_coal_block"), "true")){
            item5_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 wegla", ChatColor.GRAY + "to bedzie je zamieniac na bloki wegla!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item5_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 9 wegla", ChatColor.GRAY + "to bedzie je zamieniac na bloki wegla!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item5_meta.addEnchant(Enchantment.LUCK, 1, false);
        item5_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[5].setItemMeta(item5_meta);

        ItemMeta item6_meta = items[6].getItemMeta();
        item6_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "AutoFosa");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_auto_fosa"), "true")){
            item6_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow szmaragdow", ChatColor.GRAY + "+ 1 blok diamentow to bedzie je zamieniac na auto fose!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item6_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow szmaragdow", ChatColor.GRAY + "+ 1 blok diamentow to bedzie je zamieniac na auto fose!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item6_meta.addEnchant(Enchantment.LUCK, 1, false);
        item6_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[6].setItemMeta(item6_meta);

        ItemMeta item7_meta = items[7].getItemMeta();
        item7_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_boy_farmer"), "true")){
            item7_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow obsydianu", ChatColor.GRAY + "+ 1 blok emeraldow to bedzie je zamieniac na boy farmera!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item7_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow obsydianu", ChatColor.GRAY + "+ 1 blok emeraldow to bedzie je zamieniac na boy farmera!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item7_meta.addEnchant(Enchantment.LUCK, 1, false);
        item7_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[7].setItemMeta(item7_meta);

        ItemMeta item8_meta = items[8].getItemMeta();
        item8_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_sand_farmer"), "true")){
            item8_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow piasku", ChatColor.GRAY + "+ 1 blok emeraldow to bedzie je zamieniac na sand farmera!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.GREEN + "" + ChatColor.BOLD + "WLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }else {
            item8_meta.setLore(List.of(ChatColor.GRAY + "Jesli masz w ekwipunku co najmniej 8 blokow piasku", ChatColor.GRAY + "+ 1 blok emeraldow to bedzie je zamieniac na sand farmera!", " ", ChatColor.GRAY + "Craftowanie: " + ChatColor.RED + "" + ChatColor.BOLD + "WYLACZONE", ChatColor.YELLOW + "Kliknij, aby przelaczyc!"));
        }
        item8_meta.addEnchant(Enchantment.LUCK, 1, false);
        item8_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[8].setItemMeta(item8_meta);

        for(int i = 0; i < 9; i++) {
            inv.setItem(i, items[i]);
        }

        p.openInventory(inv);
    }
}
