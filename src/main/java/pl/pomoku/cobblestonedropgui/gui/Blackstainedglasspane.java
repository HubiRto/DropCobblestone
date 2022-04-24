package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Blackstainedglasspane {

    static Main plugin;
    public Blackstainedglasspane(Main m) {
        plugin = m;
    }

    public static ItemStack blackstainedglasspane(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack blackstainedglasspane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackstainedglasspane_meta = blackstainedglasspane.getItemMeta();

        blackstainedglasspane_meta.setDisplayName(ChatColor.GREEN + "Wlacz wszystkie dropy");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.GRAY + "Po kliknieciu kazdy przedmiot z");
        lore.add(ChatColor.GRAY + "dropu bedzie wypadac po wykopaniu.");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Kliknij, aby wlaczyc!");

        blackstainedglasspane_meta.setLore(lore);
        blackstainedglasspane.setItemMeta(blackstainedglasspane_meta);

        return blackstainedglasspane;
    }
}
