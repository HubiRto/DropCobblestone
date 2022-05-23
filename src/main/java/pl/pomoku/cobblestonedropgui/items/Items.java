package pl.pomoku.cobblestonedropgui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;

public class Items {
    static Main plugin;
    public Items(Main m) {
        plugin = m;
    }
    public static ItemStack ultra_block() {
        ItemStack ultra_block = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta ultra_block_meta = ultra_block.getItemMeta();
        ultra_block_meta.setDisplayName("§a§lUltra Block");
        List<String> ultra_block_lore = new ArrayList<>();
        ultra_block_lore.add("§7Jest to bardzo rzadki przedmiot z");
        ultra_block_lore.add("§7ktorego wypadaja bardzo cenne itemki.");
        ultra_block_lore.add(" ");
        ultra_block_lore.add("§ePostaw, aby otworzyc!");
        ultra_block_meta.setLore(ultra_block_lore);
        ultra_block.setItemMeta(ultra_block_meta);
        return ultra_block;
    }

    public static ItemStack boy_farmer() {
        ItemStack boy_farmer = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta boy_farmer_meta = boy_farmer.getItemMeta();
        boy_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        List<String> boy_farmer_lore = new ArrayList<>();
        boy_farmer_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory tworzy");
        boy_farmer_lore.add(ChatColor.GRAY + "sciane piasku po postawieniu.");
        boy_farmer_lore.add(" ");
        boy_farmer_lore.add(ChatColor.YELLOW + "Posatw, aby stworzyc!");
        boy_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        boy_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boy_farmer_meta.setLore(boy_farmer_lore);
        boy_farmer.setItemMeta(boy_farmer_meta);
        return boy_farmer;
    }

    public static ItemStack sand_farmer(){
        ItemStack sand_farmer = new ItemStack(Material.LIME_GLAZED_TERRACOTTA);
        ItemMeta sand_farmer_meta = sand_farmer.getItemMeta();
        sand_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        List<String> sand_farmer_lore = new ArrayList<>();
        sand_farmer_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory tworzy");
        sand_farmer_lore.add(ChatColor.GRAY + "sciane piasku po postawieniu.");
        sand_farmer_lore.add(" ");
        sand_farmer_lore.add(ChatColor.YELLOW + "Posatw, aby stworzyc!");
        sand_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        sand_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sand_farmer_meta.setLore(sand_farmer_lore);
        sand_farmer.setItemMeta(sand_farmer_meta);
        return sand_farmer;
    }

    public static ItemStack auto_fosa(){
        ItemStack auto_fosa = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        ItemMeta auto_fosa_meta = auto_fosa.getItemMeta();
        auto_fosa_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
        List<String> auto_fosa_lore = new ArrayList<>();
        auto_fosa_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory kopie");
        auto_fosa_lore.add(ChatColor.GRAY + "dziure do bedrocka po postawieniu.");
        auto_fosa_lore.add(" ");
        auto_fosa_lore.add(ChatColor.YELLOW + "Posatw, aby wykopac!");
        auto_fosa_meta.addEnchant(Enchantment.LUCK, 1, true);
        auto_fosa_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        auto_fosa_meta.setLore(auto_fosa_lore);
        auto_fosa.setItemMeta(auto_fosa_meta);
        return auto_fosa;
    }

    public static ItemStack cobblex(){
        ItemStack cobblex = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta cobblex_meta = cobblex.getItemMeta();
        List<String> cobblex_lore = new ArrayList<>();
        cobblex_lore.add(ChatColor.GRAY + "Jest to rzadki przedmiot z");
        cobblex_lore.add(ChatColor.GRAY + "ktorego wypadaja cenne itemki!");
        cobblex_lore.add(" ");
        cobblex_lore.add(ChatColor.YELLOW + "Posatw, aby otworzyc!");
        cobblex_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        cobblex_meta.setLore(cobblex_lore);
        cobblex.setItemMeta(cobblex_meta);
        return cobblex;
    }
    public static ItemStack throwtnt(){
        ItemStack throwtnt = new ItemStack(Material.TNT);
        ItemMeta throwtnt_meta = throwtnt.getItemMeta();
        throwtnt_meta.setDisplayName(ChatColor.RED + "Rzucane TNT");
        List<String> throwtnt_lore = new ArrayList<>();
        throwtnt_lore.add(ChatColor.YELLOW + "Przytrzymaj PPM, aby rzucic");
        throwtnt_lore.add(ChatColor.YELLOW + "lub pozostaw na ziemi.");
        throwtnt_meta.setLore(throwtnt_lore);
        throwtnt_meta.addEnchant(Enchantment.LUCK, 1, false);
        throwtnt_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        throwtnt.setItemMeta(throwtnt_meta);
        return throwtnt;
    }
    public static ItemStack stoniarka(){
        ItemStack stoniarka = new ItemStack(Material.END_STONE);
        ItemMeta stoniarka_meta = stoniarka.getItemMeta();
        stoniarka_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Stoniarka");
        List<String> stoniarka_lore = new ArrayList<>();
        stoniarka_lore.add(ChatColor.GRAY + "Jest to" + ChatColor.AQUA + " nieskonczone" + ChatColor.GRAY + " zrodlo itemow!");
        stoniarka_lore.add(ChatColor.GRAY + "Stoniarke zniszczysz " + ChatColor.GOLD + "zlotym" + ChatColor.GRAY + " kilofem.");
        stoniarka_meta.setLore(stoniarka_lore);
        stoniarka_meta.addEnchant(Enchantment.LUCK, 1, false);
        stoniarka_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stoniarka.setItemMeta(stoniarka_meta);
        return stoniarka;
    }

}
