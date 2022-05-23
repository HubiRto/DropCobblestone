package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

public class BlockAnvilsCustomBlock implements Listener {
    Main plugin;
    public BlockAnvilsCustomBlock(Main m) {
        plugin = m;
    }
    @EventHandler
    public void BlockAnvilCraftCustomBlock(PrepareAnvilEvent e) {
        ItemStack result = e.getResult();
        ItemMeta meta_result = result.getItemMeta();
        if(meta_result.getDisplayName().contains("Stoniarka") || meta_result.getDisplayName().contains("Auto Fosa")
                || meta_result.getDisplayName().contains("Boy Farmer")
                || meta_result.getDisplayName().contains("Sand Farmer")
                || meta_result.getDisplayName().contains("Cobble X")
                || meta_result.getDisplayName().contains("Ultra Block")
                || meta_result.getDisplayName().contains("Rzucane TNT")){
            e.setResult(new ItemStack(Material.AIR));
        }
    }
}
