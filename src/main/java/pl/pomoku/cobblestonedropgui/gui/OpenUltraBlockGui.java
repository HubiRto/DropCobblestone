package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.*;
import static org.bukkit.enchantments.Enchantment.ARROW_KNOCKBACK;

public class OpenUltraBlockGui {
    public static void OpenUltraBlockGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Drop z" + ChatColor.BOLD + "" + ChatColor.AQUA + " Ultra Block");
        ItemStack[] items = new ItemStack[27];

        items[0] = new ItemStack(NETHERITE_SWORD, 1);
        items[1] = new ItemStack(NETHERITE_AXE, 1);
        items[2] = new ItemStack(NETHERITE_PICKAXE, 1);
        items[3] = new ItemStack(NETHERITE_SHOVEL, 1);
        items[4] = new ItemStack(NETHERITE_BOOTS, 1);
        items[5] = new ItemStack(NETHERITE_LEGGINGS, 1);
        items[6] = new ItemStack(NETHERITE_CHESTPLATE, 1);
        items[7] = new ItemStack(NETHERITE_HELMET, 1);
        items[8] = new ItemStack(RED_GLAZED_TERRACOTTA, 64);
        items[9] = new ItemStack(PURPLE_GLAZED_TERRACOTTA, 64);
        items[10] = new ItemStack(LIME_GLAZED_TERRACOTTA, 64);
        items[11] = new ItemStack(TNT, 6);
        items[12] = new ItemStack(TRAPPED_CHEST, 6);
        items[13] = new ItemStack(CROSSBOW, 1);
        items[14] = new ItemStack(ENCHANTED_GOLDEN_APPLE, 4);
        items[15] = new ItemStack(GOLDEN_APPLE, 16);
        items[16] = new ItemStack(ENDER_PEARL, 8);
        items[17] = new ItemStack(BOW, 1);
        items[18] = new ItemStack(CHORUS_FLOWER, 3);
        items[19] = new ItemStack(BOW, 1);
        items[20] = new ItemStack(SHULKER_BOX, 5);
        items[21] = new ItemStack(DIAMOND_BLOCK, 16);
        items[22] = new ItemStack(BEACON, 1);
        items[23] = new ItemStack(ELYTRA, 1);
        items[24] = new ItemStack(TRIDENT, 1);
        items[25] = new ItemStack(TOTEM_OF_UNDYING, 1);
        items[26] = new ItemStack(HEART_OF_THE_SEA, 1);

        ItemMeta meta0 = items[0].getItemMeta();
        meta0.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta0.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        meta0.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        meta0.addEnchant(Enchantment.DURABILITY, 4, true);
        items[0].setItemMeta(meta0);

        ItemMeta meta1 = items[1].getItemMeta();
        meta1.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta1.addEnchant(Enchantment.DIG_SPEED, 5, false);
        meta1.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
        meta1.addEnchant(Enchantment.DURABILITY, 4, true);
        items[1].setItemMeta(meta1);

        ItemMeta meta2 = items[2].getItemMeta();
        meta2.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta2.addEnchant(Enchantment.DIG_SPEED, 6, true);
        meta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
        meta2.addEnchant(Enchantment.DURABILITY, 4, true);
        items[2].setItemMeta(meta2);

        ItemMeta meta3 = items[3].getItemMeta();
        meta3.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta3.addEnchant(Enchantment.DIG_SPEED, 5, false);
        meta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
        meta3.addEnchant(Enchantment.DURABILITY, 4, true);
        items[3].setItemMeta(meta3);

        for(int m = 4; m < 8; m++) {
            ItemMeta meta_m = items[m].getItemMeta();
            meta_m.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta_m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
            meta_m.addEnchant(Enchantment.DURABILITY, 4, true);
            items[m].setItemMeta(meta_m);
        }

        ItemMeta meta8 = items[8].getItemMeta();
        meta8.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
        meta8.addEnchant(Enchantment.LUCK, 1, true);
        meta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[8].setItemMeta(meta8);

        ItemMeta meta9 = items[9].getItemMeta();
        meta9.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        meta9.addEnchant(Enchantment.LUCK, 1, true);
        meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[9].setItemMeta(meta9);

        ItemMeta meta10 = items[10].getItemMeta();
        meta10.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        meta10.addEnchant(Enchantment.LUCK, 1, true);
        meta10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[10].setItemMeta(meta10);

        ItemMeta meta11 = items[11].getItemMeta();
        meta11.setDisplayName(ChatColor.RED + "Rzucane TNT");
        List<String> meta11_lore = new ArrayList<>();
        meta11_lore.add(ChatColor.YELLOW + "Przytrzymaj PPM, aby rzucic");
        meta11_lore.add(ChatColor.YELLOW + "lub pozostaw na ziemi.");
        meta11.setLore(meta11_lore);
        meta11.addEnchant(Enchantment.LUCK, 1, true);
        meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        items[11].setItemMeta(meta11);

        ItemMeta meta12 = items[12].getItemMeta();
        meta12.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        List<String> meta12_lore = new ArrayList<>();
        meta12_lore.add("§7Jest to skrzynia z ktorej");
        meta12_lore.add("§7wypadaja bardzo cenne itemki.");
        meta12_lore.add(" ");
        meta12_lore.add("§ePostaw, aby otworzyc!");
        meta12.setLore(meta12_lore);
        items[12].setItemMeta(meta12);

        ItemMeta meta13 = items[13].getItemMeta();
        meta13.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta13.addEnchant(Enchantment.MULTISHOT, 1, false);
        meta13.addEnchant(Enchantment.QUICK_CHARGE, 3, false);
        meta13.addEnchant(Enchantment.DURABILITY, 4, true);
        items[13].setItemMeta(meta13);

        ItemMeta meta17 = items[17].getItemMeta();
        meta17.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta17.addEnchant(ARROW_KNOCKBACK ,2, false);
        meta17.addEnchant(Enchantment.DURABILITY, 4, true);
        items[17].setItemMeta(meta17);

        ItemMeta meta19 = items[19].getItemMeta();
        meta19.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
        meta19.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta19.addEnchant(Enchantment.ARROW_DAMAGE ,2, false);
        meta19.addEnchant(Enchantment.DURABILITY, 4, true);
        items[19].setItemMeta(meta19);

        for(int i = 0; i < 27; i++) {
            inv.setItem(i, items[i]);
        }
        p.openInventory(inv);
    }
}
