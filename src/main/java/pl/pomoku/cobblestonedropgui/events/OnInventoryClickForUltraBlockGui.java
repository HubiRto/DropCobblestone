package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.main.Main;

public class OnInventoryClickForUltraBlockGui implements Listener {
    Main plugin;

    public OnInventoryClickForUltraBlockGui(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Drop z Ultra Block")) return;
        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            p.closeInventory();
            return;
        }
        switch(e.getCurrentItem().getType()) {
            case BARRIER:
                OpenDropGui.OpenGui(p);
                break;
            default:
                p.updateInventory();
                break;
        }
    }
}
