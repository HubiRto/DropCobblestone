package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.gui.OpenCobbleXGui;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.gui.OpenUltraBlockGui;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.Objects;
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
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".cobblestone", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".cobblestone", "true");
                    PlayerDropConfig.save();
                }
                //p.updateInventory(); ---> Nie dziala
                //Wyrzucialem zamykanie sie inventory i kusor sie nie przemieszcza
                //p.closeInventory();
                //Moga wystapic bledy z optymalizacja
                OpenDropGui.OpenGui(p);
                break;
            case DIAMOND:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".diamond"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".diamond", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".diamond", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case YELLOW_SHULKER_BOX:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".ultra_block"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".ultra_block", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".ultra_block", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case REDSTONE:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".redstone"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".redstone", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".redstone", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case NETHERITE_INGOT:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".netherite"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".netherite", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".netherite", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case SLIME_BALL:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".slimeball"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".slimeball", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".slimeball", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case BOOKSHELF:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".bookshelf"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".bookshelf", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".bookshelf", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case ENDER_PEARL:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".enderpearl"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".enderpearl", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".enderpearl", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case TNT:
                if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Rzucane TNT")) {
                    if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".throwtnt"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".throwtnt", "false");
                        PlayerDropConfig.save();
                    } else {
                        PlayerDropConfig.get().set(uuid + ".throwtnt", "true");
                        PlayerDropConfig.save();
                    }
                    OpenDropGui.OpenGui(p);
                }else {
                    if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".tnt"), "true")) {
                        PlayerDropConfig.get().set(uuid + ".tnt", "false");
                        PlayerDropConfig.save();
                    } else {
                        PlayerDropConfig.get().set(uuid + ".tnt", "true");
                        PlayerDropConfig.save();
                    }
                    OpenDropGui.OpenGui(p);
                }
                break;
            case APPLE:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".apple"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".apple", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".apple", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case COAL:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".coal"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".coal", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".coal", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case OAK_LOG:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".oaklog"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".oaklog", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".oaklog", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case ARROW:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".arrow"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".arrow", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".arrow", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case LIME_STAINED_GLASS_PANE:
                PlayerDropConfig.get().set(uuid + ".cobblestone", "true");
                PlayerDropConfig.get().set(uuid + ".iron", "true");
                PlayerDropConfig.get().set(uuid + ".gold", "true");
                PlayerDropConfig.get().set(uuid + ".obsidian", "true");
                PlayerDropConfig.get().set(uuid + ".emerald", "true");
                PlayerDropConfig.get().set(uuid + ".diamond", "true");
                PlayerDropConfig.get().set(uuid + ".redstone", "true");
                PlayerDropConfig.get().set(uuid + ".netherite", "true");
                PlayerDropConfig.get().set(uuid + ".slimeball", "true");
                PlayerDropConfig.get().set(uuid + ".bookshelf", "true");
                PlayerDropConfig.get().set(uuid + ".enderpearl", "true");
                PlayerDropConfig.get().set(uuid + ".tnt", "true");
                PlayerDropConfig.get().set(uuid + ".apple", "true");
                PlayerDropConfig.get().set(uuid + ".coal", "true");
                PlayerDropConfig.get().set(uuid + ".oaklog", "true");
                PlayerDropConfig.get().set(uuid + ".arrow", "true");

                PlayerDropConfig.save();
                OpenDropGui.OpenGui(p);
                break;
            case RED_STAINED_GLASS_PANE:
                PlayerDropConfig.get().set(uuid + ".cobblestone", "false");
                PlayerDropConfig.get().set(uuid + ".iron", "false");
                PlayerDropConfig.get().set(uuid + ".gold", "false");
                PlayerDropConfig.get().set(uuid + ".obsidian", "false");
                PlayerDropConfig.get().set(uuid + ".emerald", "false");
                PlayerDropConfig.get().set(uuid + ".diamond", "false");
                PlayerDropConfig.get().set(uuid + ".redstone", "false");
                PlayerDropConfig.get().set(uuid + ".netherite", "false");
                PlayerDropConfig.get().set(uuid + ".slimeball", "false");
                PlayerDropConfig.get().set(uuid + ".bookshelf", "false");
                PlayerDropConfig.get().set(uuid + ".enderpearl", "false");
                PlayerDropConfig.get().set(uuid + ".tnt", "false");
                PlayerDropConfig.get().set(uuid + ".apple", "false");
                PlayerDropConfig.get().set(uuid + ".coal", "false");
                PlayerDropConfig.get().set(uuid + ".oaklog", "false");
                PlayerDropConfig.get().set(uuid + ".arrow", "false");
                PlayerDropConfig.save();
                OpenDropGui.OpenGui(p);
                break;
            case IRON_INGOT:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".iron"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".iron", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".iron", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case GOLD_INGOT:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".gold"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".gold", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".gold", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case OBSIDIAN:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".obsidian"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".obsidian", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".obsidian", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case EMERALD:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".emerald"), "true")) {
                    PlayerDropConfig.get().set(uuid + ".emerald", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".emerald", "true");
                    PlayerDropConfig.save();
                }
                OpenDropGui.OpenGui(p);
                break;
            case HOPPER:
                if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")){
                    PlayerDropConfig.get().set(uuid + ".eq", "false");
                    PlayerDropConfig.save();
                }else {
                    PlayerDropConfig.get().set(uuid + ".eq", "true");
                    PlayerDropConfig.save();
                }
//                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
//                    plugin.getConfig().set(uuid + ".eq", "false");
//                    plugin.saveConfig();
//                }else {
//                    plugin.getConfig().set(uuid + ".eq", "true");
//                    plugin.saveConfig();
//                }
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
