package pl.pomoku.cobblestonedropgui.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import pl.pomoku.cobblestonedropgui.items.Items;

public class CustomRecipes {

    public ItemStack item_auto_fosa = Items.auto_fosa();

    public ItemStack item_sand_farmer = Items.sand_farmer();

    public ItemStack item_boy_farmer = Items.boy_farmer();

    private ItemStack item_cobble_x = Items.cobblex();

    private ItemStack item_throw_tnt = Items.throwtnt();

    private ItemStack item_stoniarka = Items.stoniarka();

    public void autoFosa() {
        ShapedRecipe AutoFosa = new ShapedRecipe(NamespacedKey.minecraft("item_auto_fosa"), item_auto_fosa);
        AutoFosa.shape("XXX", "XSX", "XXX");
        AutoFosa.setIngredient('X', Material.EMERALD_BLOCK);
        AutoFosa.setIngredient('S', Material.DIAMOND_BLOCK);

        Bukkit.addRecipe(AutoFosa);
    }

    public void boyFarmer() {
        ShapedRecipe BoyFarmer = new ShapedRecipe(NamespacedKey.minecraft("item_boy_farmer"), item_boy_farmer);
        BoyFarmer.shape("XXX", "XSX", "XXX");
        BoyFarmer.setIngredient('X', Material.OBSIDIAN);
        BoyFarmer.setIngredient('S', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(BoyFarmer);
    }

    public void sandFarmer() {
        ShapedRecipe SandFarmer = new ShapedRecipe(NamespacedKey.minecraft("item_sand_farmer"), item_sand_farmer);
        SandFarmer.shape("XXX", "XSX", "XXX");
        SandFarmer.setIngredient('X', Material.SAND);
        SandFarmer.setIngredient('S', Material.EMERALD_BLOCK);

        Bukkit.addRecipe(SandFarmer);
    }
    public void cobbleX() {
        ShapedRecipe CobbleX = new ShapedRecipe(NamespacedKey.minecraft("item_cobble_x"), item_cobble_x);
        CobbleX.shape("XXX", "XSX", "XXX");
        CobbleX.setIngredient('X', Material.NETHERITE_INGOT);
        CobbleX.setIngredient('S', Material.COBBLESTONE);

        Bukkit.addRecipe(CobbleX);
    }

    public void throwTnt() {
        ShapedRecipe ThrowTnt = new ShapedRecipe(NamespacedKey.minecraft("item_throw_tnt"), item_throw_tnt);

        ThrowTnt.shape("XXX", "XSX", "XXX");
        ThrowTnt.setIngredient('X', Material.NETHERITE_INGOT);
        ThrowTnt.setIngredient('S', Material.TNT);

        Bukkit.addRecipe(ThrowTnt);
    }

    public void stoniarka() {
        ShapedRecipe Stoniarka = new ShapedRecipe(NamespacedKey.minecraft("item_stoniarka"), item_stoniarka);
        Stoniarka.shape("XXX", "XSX", "XXX");
        Stoniarka.setIngredient('X', Material.COBBLESTONE);
        Stoniarka.setIngredient('S', Material.DIAMOND);

        Bukkit.addRecipe(Stoniarka);
    }
}
