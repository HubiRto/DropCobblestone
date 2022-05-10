package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

public class Blackstainedglasspane {

    static Main plugin;
    public Blackstainedglasspane(Main m) {
        plugin = m;
    }

    public static ItemStack blackstainedglasspane() {

        ItemStack blackstainedglasspane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackstainedglasspane_meta = blackstainedglasspane.getItemMeta();

        blackstainedglasspane_meta.setDisplayName(" ");

        blackstainedglasspane.setItemMeta(blackstainedglasspane_meta);

        return blackstainedglasspane;
    }
}
