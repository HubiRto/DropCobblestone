package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.gui.OpenCobbleXGui;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.gui.OpenUltraBlockGui;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.UUID;

public class OnInventoryClickForDropGui implements Listener {

    Main plugin;

    public OnInventoryClickForDropGui(Main m) {
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
                //p.updateInventory(); ---> Nie dziala
                //Wyrzucialem zamykanie sie inventory i kusor sie nie przemieszcza
                //p.closeInventory();
                //Moga wystapic bledy z optymalizacja
                OpenDropGui.OpenGui(p);
                break;
            case DIAMOND:
                if(plugin.getConfig().getString(uuid + ".diamond") == "true") {
                    plugin.getConfig().set(uuid + ".diamond", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".diamond", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case YELLOW_SHULKER_BOX:
                if(plugin.getConfig().getString(uuid + ".ultra_block") == "true") {
                    plugin.getConfig().set(uuid + ".ultra_block", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".ultra_block", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case REDSTONE:
                if(plugin.getConfig().getString(uuid + ".redstone") == "true") {
                    plugin.getConfig().set(uuid + ".redstone", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".redstone", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case NETHERITE_INGOT:
                if(plugin.getConfig().getString(uuid + ".netherite") == "true") {
                    plugin.getConfig().set(uuid + ".netherite", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".netherite", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case SLIME_BALL:
                if(plugin.getConfig().getString(uuid + ".slimeball") == "true") {
                    plugin.getConfig().set(uuid + ".slimeball", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".slimeball", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case BOOKSHELF:
                if(plugin.getConfig().getString(uuid + ".bookshelf") == "true") {
                    plugin.getConfig().set(uuid + ".bookshelf", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".bookshelf", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case ENDER_PEARL:
                if(plugin.getConfig().getString(uuid + ".enderpearl") == "true") {
                    plugin.getConfig().set(uuid + ".enderpearl", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".enderpearl", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case TNT:
                if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Rzucane TNT")) {
                    if (plugin.getConfig().getString(uuid + ".throwtnt") == "true") {
                        plugin.getConfig().set(uuid + ".throwtnt", "false");
                        plugin.saveConfig();
                    } else {
                        plugin.getConfig().set(uuid + ".throwtnt", "true");
                        plugin.saveConfig();
                    }
                    OpenDropGui.OpenGui(p);
                }else {
                    if (plugin.getConfig().getString(uuid + ".tnt") == "true") {
                        plugin.getConfig().set(uuid + ".tnt", "false");
                        plugin.saveConfig();
                    } else {
                        plugin.getConfig().set(uuid + ".tnt", "true");
                        plugin.saveConfig();
                    }
                    OpenDropGui.OpenGui(p);
                }
                break;
            case APPLE:
                if(plugin.getConfig().getString(uuid + ".apple") == "true") {
                    plugin.getConfig().set(uuid + ".apple", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".apple", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case COAL:
                if(plugin.getConfig().getString(uuid + ".coal") == "true") {
                    plugin.getConfig().set(uuid + ".coal", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".coal", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case OAK_LOG:
                if(plugin.getConfig().getString(uuid + ".oaklog") == "true") {
                    plugin.getConfig().set(uuid + ".oaklog", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".oaklog", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case ARROW:
                if(plugin.getConfig().getString(uuid + ".arrow") == "true") {
                    plugin.getConfig().set(uuid + ".arrow", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".arrow", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case LIME_STAINED_GLASS_PANE:
                plugin.getConfig().set(uuid + ".cobblestone", "true");
                plugin.getConfig().set(uuid + ".iron", "true");
                plugin.getConfig().set(uuid + ".gold", "true");
                plugin.getConfig().set(uuid + ".obsidian", "true");
                plugin.getConfig().set(uuid + ".emerald", "true");
                plugin.getConfig().set(uuid + ".diamond", "true");
                plugin.getConfig().set(uuid + ".redstone", "true");
                plugin.getConfig().set(uuid + ".netherite", "true");
                plugin.getConfig().set(uuid + ".slimeball", "true");
                plugin.getConfig().set(uuid + ".bookshelf", "true");
                plugin.getConfig().set(uuid + ".enderpearl", "true");
                plugin.getConfig().set(uuid + ".tnt", "true");
                plugin.getConfig().set(uuid + ".apple", "true");
                plugin.getConfig().set(uuid + ".coal", "true");
                plugin.getConfig().set(uuid + ".oaklog", "true");
                plugin.getConfig().set(uuid + ".arrow", "true");

                plugin.saveConfig();
                OpenDropGui.OpenGui(p);
                break;
            case RED_STAINED_GLASS_PANE:
                plugin.getConfig().set(uuid + ".cobblestone", "false");
                plugin.getConfig().set(uuid + ".iron", "false");
                plugin.getConfig().set(uuid + ".gold", "false");
                plugin.getConfig().set(uuid + ".obsidian", "false");
                plugin.getConfig().set(uuid + ".emerald", "false");
                plugin.getConfig().set(uuid + ".diamond", "false");
                plugin.getConfig().set(uuid + ".redstone", "false");
                plugin.getConfig().set(uuid + ".netherite", "false");
                plugin.getConfig().set(uuid + ".slimeball", "false");
                plugin.getConfig().set(uuid + ".bookshelf", "false");
                plugin.getConfig().set(uuid + ".enderpearl", "false");
                plugin.getConfig().set(uuid + ".tnt", "false");
                plugin.getConfig().set(uuid + ".apple", "false");
                plugin.getConfig().set(uuid + ".coal", "false");
                plugin.getConfig().set(uuid + ".oaklog", "false");
                plugin.getConfig().set(uuid + ".arrow", "false");
                plugin.saveConfig();
                OpenDropGui.OpenGui(p);
                break;
            case IRON_INGOT:
                if(plugin.getConfig().getString(uuid + ".iron") == "true") {
                    plugin.getConfig().set(uuid + ".iron", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".iron", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case GOLD_INGOT:
                if(plugin.getConfig().getString(uuid + ".gold") == "true") {
                    plugin.getConfig().set(uuid + ".gold", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".gold", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case OBSIDIAN:
                if(plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                    plugin.getConfig().set(uuid + ".obsidian", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".obsidian", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case EMERALD:
                if(plugin.getConfig().getString(uuid + ".emerald") == "true") {
                    plugin.getConfig().set(uuid + ".emerald", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".emerald", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case HOPPER:
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    plugin.getConfig().set(uuid + ".eq", "false");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set(uuid + ".eq", "true");
                    plugin.saveConfig();
                }
                OpenDropGui.OpenGui(p);
                break;
            case ENDER_CHEST:
                p.closeInventory();
                OpenCobbleXGui.OpenCobbleXGui(p);
                break;
            case CHEST:
                p.closeInventory();
                OpenUltraBlockGui.OpenUltraBlockGui(p);
                break;
            case BLACK_STAINED_GLASS_PANE:
                break;
            case BARRIER:
                p.closeInventory();
            default:
                p.closeInventory();
                break;

        }
    }
}
