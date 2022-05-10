package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;

public class Redstainedglasspane {

    static Main plugin;
    public Redstainedglasspane(Main m) {
        plugin = m;
    }

    public static ItemStack redstainedglasspane() {

        ItemStack redstainedglasspane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta redstainedglasspane_meta = redstainedglasspane.getItemMeta();

        redstainedglasspane_meta.setDisplayName(ChatColor.RED + "Wylacz wszystkie dropy");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Po kliknieciu zaden przedmiot z");
        lore.add(ChatColor.GRAY + "dropu nie bedzie wypadac po wykopaniu.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby wylaczyc!");

        redstainedglasspane_meta.setLore(lore);
        redstainedglasspane.setItemMeta(redstainedglasspane_meta);

        return redstainedglasspane;
    }
}
