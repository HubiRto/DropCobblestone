package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;

public class Enderchest {

    static Main plugin;
    public Enderchest(Main m) {
        plugin = m;
    }

    public static ItemStack enderchest() {

        ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
        ItemMeta enderchest_meta = enderchest.getItemMeta();

        enderchest_meta.setDisplayName(ChatColor.GREEN + "Drop z Cobble X");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Lista przedmiotow, ktore dropia");
        lore.add(ChatColor.GRAY + "z rzadkiego przedmiotu Cobble X.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby zobaczyc!");

        enderchest_meta.setLore(lore);
        enderchest.setItemMeta(enderchest_meta);

        return enderchest;
    }
}
