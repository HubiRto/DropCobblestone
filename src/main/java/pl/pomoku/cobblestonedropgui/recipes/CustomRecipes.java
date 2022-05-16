package pl.pomoku.cobblestonedropgui.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomRecipes {

    public static ItemStack af;
    public static ItemStack sf;
    public static ItemStack bf;
    public static ItemStack cx;
    public static ItemStack tt;

    public ItemStack item_auto_fosa = new ItemStack(Material.RED_GLAZED_TERRACOTTA, 1);
    public ItemMeta auto_fosa_meta = item_auto_fosa.getItemMeta();

    public ItemStack item_sand_farmer = new ItemStack(Material.LIME_GLAZED_TERRACOTTA, 1);
    public ItemMeta sand_farmer_meta = item_sand_farmer.getItemMeta();

    public ItemStack item_boy_farmer = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA, 1);
    public ItemMeta boy_farmer_meta = item_boy_farmer.getItemMeta();

    private ItemStack item_cobble_x = new ItemStack(Material.TRAPPED_CHEST);
    private ItemMeta cobblex_meta = item_cobble_x.getItemMeta();
    private List<String> cobblex_lore = new ArrayList<>();

    private ItemStack throwtnt = new ItemStack(Material.TNT);
    private ItemMeta throwtnt_meta = throwtnt.getItemMeta();
    private List<String> throwtnt_lore = new ArrayList<>();

    public void autoFosa() {
        auto_fosa_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
        auto_fosa_meta.addEnchant(Enchantment.LUCK, 1, true);
        auto_fosa_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_auto_fosa.setItemMeta(auto_fosa_meta);
        af = item_auto_fosa;

        ShapedRecipe AutoFosa = new ShapedRecipe(NamespacedKey.minecraft("af"), item_auto_fosa);
        AutoFosa.shape("XXX", "XSX", "XXX");
        AutoFosa.setIngredient('X', Material.EMERALD_BLOCK);
        AutoFosa.setIngredient('S', Material.DIAMOND_BLOCK);

        Bukkit.addRecipe(AutoFosa);
    }

    public void boyFarmer() {
        boy_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        boy_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        boy_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_boy_farmer.setItemMeta(boy_farmer_meta);
        bf = item_boy_farmer;

        ShapedRecipe BoyFarmer = new ShapedRecipe(NamespacedKey.minecraft("bf"), item_boy_farmer);
        BoyFarmer.shape("XXX", "XSX", "XXX");
        BoyFarmer.setIngredient('X', Material.OBSIDIAN);
        BoyFarmer.setIngredient('S', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(BoyFarmer);
    }

    public void sandFarmer() {
        sand_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        sand_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        sand_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item_sand_farmer.setItemMeta(sand_farmer_meta);
        sf = item_sand_farmer;

        ShapedRecipe SandFarmer = new ShapedRecipe(NamespacedKey.minecraft("sf"), item_sand_farmer);
        SandFarmer.shape("XXX", "XSX", "XXX");
        SandFarmer.setIngredient('X', Material.SAND);
        SandFarmer.setIngredient('S', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(SandFarmer);
    }
    public void cobbleX() {
        cobblex_lore.add(ChatColor.GRAY + "Jest to rzadki przedmiot z");
        cobblex_lore.add(ChatColor.GRAY + "ktorego wypadaja cenne itemki!");
        cobblex_lore.add(" ");
        cobblex_lore.add(ChatColor.YELLOW + "Posatw, aby otworzyc!");
        cobblex_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
        cobblex_meta.setLore(cobblex_lore);
        item_cobble_x.setItemMeta(cobblex_meta);
        cx = item_cobble_x;

        //ShapelessRecipe CobbleX_v2 = new ShapelessRecipe(item_cobble_x);
        //CobbleX_v2.addIngredient(576, Material.COBBLESTONE);

        ShapedRecipe CobbleX = new ShapedRecipe(NamespacedKey.minecraft("cx"), item_cobble_x);
        CobbleX.shape("XXX", "XSX", "XXX");
        CobbleX.setIngredient('X', Material.NETHERITE_INGOT);
        CobbleX.setIngredient('S', Material.COBBLESTONE);

        Bukkit.addRecipe(CobbleX);
        //Bukkit.addRecipe(CobbleX_v2);
    }

    public void throwTnt() {
        throwtnt_lore.add(ChatColor.YELLOW + "Przytrzymaj PPM, aby rzucic");
        throwtnt_lore.add(ChatColor.YELLOW + "lub pozostaw na ziemi.");
        throwtnt_meta.setLore(throwtnt_lore);
        throwtnt_meta.setDisplayName(ChatColor.RED + "Rzucane TNT");
        throwtnt_meta.addEnchant(Enchantment.LUCK, 1, false);
        throwtnt_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        throwtnt.setItemMeta(throwtnt_meta);
        tt = throwtnt;

        ShapedRecipe ThrowTnt = new ShapedRecipe(NamespacedKey.minecraft("rzucane"), throwtnt);
        ThrowTnt.shape("XXX", "XSX", "XXX");
        ThrowTnt.setIngredient('X', Material.NETHERITE_INGOT);
        ThrowTnt.setIngredient('S', Material.TNT);

        Bukkit.addRecipe(ThrowTnt);
    }
}
