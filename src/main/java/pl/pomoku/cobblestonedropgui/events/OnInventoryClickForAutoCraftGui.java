package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.main.Main;

public class OnInventoryClickForAutoCraftGui implements Listener {
    Main plugin;

    public OnInventoryClickForAutoCraftGui(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Szybkie Craftowanie")) return;
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            p.closeInventory();
            return;
        }else {
            switch(e.getCurrentItem().getType()) {
                case IRON_BLOCK:
                    p.updateInventory();
                    break;
                case GOLD_BLOCK:
                    p.updateInventory();
                    break;
                case DIAMOND_BLOCK:
                    p.updateInventory();
                    break;
                case EMERALD_BLOCK:
                    p.updateInventory();
                    break;
                case REDSTONE_BLOCK:
                    p.updateInventory();
                    break;
                case COAL_BLOCK:
                    p.updateInventory();
                    break;
                case RED_GLAZED_TERRACOTTA:
                    p.updateInventory();
                    break;
                case PURPLE_GLAZED_TERRACOTTA:
                    p.updateInventory();
                    break;
                case LIME_GLAZED_TERRACOTTA:
                    p.updateInventory();
                    break;
                default:
                    p.updateInventory();
                    break;
            }
        }

    }
}
