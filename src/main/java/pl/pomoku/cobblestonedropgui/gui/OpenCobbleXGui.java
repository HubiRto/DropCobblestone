package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Material.*;
import static org.bukkit.Material.DIAMOND_HELMET;

public class OpenCobbleXGui {
    public static void OpenCobbleXGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.GRAY + "Drop z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");

        ItemStack[] items = new ItemStack[20];

        items[0] = new ItemStack(DIAMOND, 24);
        items[1] = new ItemStack(EMERALD, 24);
        items[2] = new ItemStack(OBSIDIAN, 24);
        items[3] = new ItemStack(GOLDEN_APPLE, 4);
        items[4] = new ItemStack(NETHERITE_INGOT, 4);
        items[5] = new ItemStack(ENCHANTING_TABLE, 1);
        items[6] = new ItemStack(ENCHANTED_GOLDEN_APPLE, 1);
        items[7] = new ItemStack(ENDER_PEARL, 4);
        items[8] = new ItemStack(APPLE, 4);
        items[9] = new ItemStack(TNT, 16);
        items[10] = new ItemStack(DIAMOND_SWORD, 1);
        items[11] = new ItemStack(DIAMOND_PICKAXE, 1);
        items[12] = new ItemStack(DIAMOND_AXE, 1);
        items[13] = new ItemStack(DIAMOND_SHOVEL, 1);
        items[14] = new ItemStack(DIAMOND_BOOTS, 1);
        items[15] = new ItemStack(DIAMOND_LEGGINGS, 1);
        items[16] = new ItemStack(DIAMOND_CHESTPLATE, 1);
        items[17] = new ItemStack(DIAMOND_HELMET, 1);
        items[18] = new ItemStack(BLACK_STAINED_GLASS_PANE, 1);
        items[19] = new ItemStack(TRAPPED_CHEST, 1);

        ItemMeta meta18 = items[18].getItemMeta();
        meta18.setDisplayName(" ");
        items[18].setItemMeta(meta18);

        ItemMeta meta19 = items[19].getItemMeta();
        meta19.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Jest to rzadki przedmiot z");
        lore.add(ChatColor.GRAY + "ktorego wypadaja cenne itemki!");
        lore.add(ChatColor.GRAY + "Wymagane: " + ChatColor.LIGHT_PURPLE + "9x 64 szt. bruku");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby stworzyc!");
        meta19.setLore(lore);
        items[19].setItemMeta(meta19);

        ItemMeta meta10 = items[10].getItemMeta();
        meta10.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        meta10.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        meta10.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        meta10.addEnchant(Enchantment.DURABILITY, 3, false);
        items[10].setItemMeta(meta10);

        for(int a = 10; a < 14; a++) {
            ItemMeta meta_a = items[a].getItemMeta();
            meta_a.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
            meta_a.addEnchant(Enchantment.DIG_SPEED, 5, false);
            meta_a.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
            meta_a.addEnchant(Enchantment.DURABILITY, 3, false);
            items[a].setItemMeta(meta_a);
        }
        for(int b = 14; b < 18; b++) {
            ItemMeta meta_b = items[b].getItemMeta();
            meta_b.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
            meta_b.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
            meta_b.addEnchant(Enchantment.DURABILITY, 3, false);
            items[b].setItemMeta(meta_b);
        }

        for(int i = 0; i < 18; i++) {
            inv.setItem(i, items[i]);
        }
        for(int c = 18; c < 31; c++) {
            inv.setItem(c, items[18]);
        }
        for(int d = 32; d < 45; d++) {
            inv.setItem(d, items[18]);
        }

        inv.setItem(31, items[19]);


        p.openInventory(inv);
    }
}
