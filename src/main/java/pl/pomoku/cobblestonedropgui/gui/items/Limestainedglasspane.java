package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;

public class Limestainedglasspane {

    static Main plugin;
    public Limestainedglasspane(Main m) {
        plugin = m;
    }

    public static ItemStack limestainedglasspane() {

        ItemStack limestainedglasspane = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta limestainedglasspane_meta = limestainedglasspane.getItemMeta();

        limestainedglasspane_meta.setDisplayName(ChatColor.GREEN + "Wlacz wszystkie dropy");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Po kliknieciu kazdy przedmiot z");
        lore.add(ChatColor.GRAY + "dropu bedzie wypadac po wykopaniu.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby wlaczyc!");

        limestainedglasspane_meta.setLore(lore);
        limestainedglasspane.setItemMeta(limestainedglasspane_meta);

        return limestainedglasspane;
    }
}
