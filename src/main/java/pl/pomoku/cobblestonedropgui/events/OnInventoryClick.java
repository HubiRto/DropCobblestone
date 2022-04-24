package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.gui.OpenGui;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.UUID;

public class OnInventoryClick implements Listener {

    Main plugin;

    public OnInventoryClick(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if(!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Drop z kamienia")) return;
        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();

        e.setCancelled(true);

        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
            p.closeInventory();
            return;
        }

        switch(e.getCurrentItem().getType()) {
            case COBBLESTONE:
                if(plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    plugin.getConfig().set(uuid + ".cobblestone", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".cobblestone", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case LIME_STAINED_GLASS_PANE:
                plugin.getConfig().set(uuid + ".cobblestone", "true");
                plugin.getConfig().set(uuid + ".iron", "true");
                plugin.getConfig().set(uuid + ".gold", "true");
                plugin.getConfig().set(uuid + ".obsidian", "true");
                plugin.getConfig().set(uuid + ".emerald", "true");
                plugin.saveConfig();
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case IRON_INGOT:
                if(plugin.getConfig().getString(uuid + ".iron") == "true") {
                    plugin.getConfig().set(uuid + ".iron", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".iron", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case GOLD_INGOT:
                if(plugin.getConfig().getString(uuid + ".gold") == "true") {
                    plugin.getConfig().set(uuid + ".gold", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".gold", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case OBSIDIAN:
                if(plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                    plugin.getConfig().set(uuid + ".obsidian", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".obsidian", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case EMERALD:
                if(plugin.getConfig().getString(uuid + ".emerald") == "true") {
                    plugin.getConfig().set(uuid + ".emerald", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".emerald", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            case HOPPER:
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    plugin.getConfig().set(uuid + ".eq", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".eq", "true");
                    plugin.saveConfig();
                }
                p.closeInventory();
                OpenGui.OpenGui(p);
                break;
            default:
                p.closeInventory();
                break;

        }
     }
}
