package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;

public class Chest {

    static Main plugin;
    public Chest(Main m) {
        plugin = m;
    }

    public static ItemStack chest() {

        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chest_meta = chest.getItemMeta();

        chest_meta.setDisplayName(ChatColor.GREEN + "Drop z Ultra Block");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Lista przedmiotow, ktore dropia");
        lore.add(ChatColor.GRAY + "z legendarnej skrzyni Ultra Block.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby zobaczyc!");

        chest_meta.setLore(lore);
        chest.setItemMeta(chest_meta);

        return chest;
    }
}
