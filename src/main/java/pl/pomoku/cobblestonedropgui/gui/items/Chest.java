package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Chest {

    static Main plugin;
    public Chest(Main m) {
        plugin = m;
    }

    public static ItemStack chest(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chest_meta = chest.getItemMeta();

        chest_meta.setDisplayName(ChatColor.GREEN + "Drop z Cobble X");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Lista przedmiotow, ktore dropia");
        lore.add(ChatColor.GRAY + "z rzadkiego przedmiotu Cobble X.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby zobaczyc!");

        chest_meta.setLore(lore);
        chest.setItemMeta(chest_meta);

        return chest;
    }
}
