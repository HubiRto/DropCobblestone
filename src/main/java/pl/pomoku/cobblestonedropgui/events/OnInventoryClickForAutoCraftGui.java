package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenAutoCraftGui;
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
        if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Auto Craftowanie")) return;
        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        e.setCancelled(true);
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            p.closeInventory();
        } else {
            switch (e.getCurrentItem().getType()) {
                case IRON_BLOCK -> zmiana(p, uuid, ".auto_craft_iron_block");
                case GOLD_BLOCK -> zmiana(p, uuid, ".auto_craft_gold_block");
                case DIAMOND_BLOCK -> zmiana(p, uuid, ".auto_craft_diamond_block");
                case EMERALD_BLOCK -> zmiana(p, uuid, ".auto_craft_emerald_block");
                case REDSTONE_BLOCK -> zmiana(p, uuid, ".auto_craft_redstone_block");
                case COAL_BLOCK -> zmiana(p, uuid, ".auto_craft_coal_block");
                case RED_GLAZED_TERRACOTTA -> zmiana(p, uuid, ".auto_craft_auto_fosa");
                case PURPLE_GLAZED_TERRACOTTA -> zmiana(p, uuid, ".auto_craft_boy_farmer");
                case LIME_GLAZED_TERRACOTTA -> zmiana(p, uuid, ".auto_craft_sand_farmer");
                default -> p.closeInventory();
            }
        }
    }

    private void zmiana(Player p, UUID uuid, String zmienna) {
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + zmienna), "true")) {
            PlayerDropConfig.get().set(uuid + zmienna, "false");
            PlayerDropConfig.save();
        } else {
            PlayerDropConfig.get().set(uuid + zmienna, "true");
            PlayerDropConfig.save();
        }
        OpenAutoCraftGui.OpenAutoCraftGui(p);
    }
}
