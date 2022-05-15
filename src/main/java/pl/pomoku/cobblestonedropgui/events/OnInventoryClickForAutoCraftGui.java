package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenAutoCraftGui;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.Objects;
import java.util.UUID;

public class OnInventoryClickForAutoCraftGui implements Listener {
    Main plugin;

    public OnInventoryClickForAutoCraftGui(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Szybkie Craftowanie")) return;
        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        e.setCancelled(true);
        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            p.closeInventory();
            return;
        }else {
            switch(e.getCurrentItem().getType()) {
                case IRON_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_iron_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_iron_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_iron_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case GOLD_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_gold_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_gold_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_gold_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case DIAMOND_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_diamond_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_diamond_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_diamond_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case EMERALD_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_emerald_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_emerald_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_emerald_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case REDSTONE_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_redstone_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_redstone_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_redstone_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case COAL_BLOCK:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_coal_block"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_coal_block", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_coal_block", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case RED_GLAZED_TERRACOTTA:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_auto_fosa"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_auto_fosa", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_auto_fosa", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case PURPLE_GLAZED_TERRACOTTA:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_boy_farmer"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_boy_farmer", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_boy_farmer", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                case LIME_GLAZED_TERRACOTTA:
                    if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_sand_farmer"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_sand_farmer", "false");
                        PlayerDropConfig.save();
                    }else {
                        PlayerDropConfig.get().set(uuid + ".auto_craft_sand_farmer", "true");
                        PlayerDropConfig.save();
                    }
                    OpenAutoCraftGui.OpenAutoCraftGui(p);
                    break;
                default:
                    p.closeInventory();
                    break;
            }
        }

    }
}
