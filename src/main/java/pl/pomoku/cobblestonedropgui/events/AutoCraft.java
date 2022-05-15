package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.Objects;
import java.util.UUID;

public class AutoCraft implements Listener {
    Main plugin;

    public AutoCraft(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnPlayerHaveItem(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        change(p, uuid);
    }
    @EventHandler
    public void OnPlayerHaveItem_2(PlayerMoveEvent e){
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        change(p, uuid);
    }
    @EventHandler
    public void OnPlayerHaveItem_3(BlockBreakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        change(p, uuid);
    }
    public void change(Player p, UUID uuid){
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_diamond_block"), "true")){
            if(isPlayerHaveEnoughItems(p, 9, Material.DIAMOND)){
                ItemStack diamond = new ItemStack(Material.DIAMOND);
                diamond.setAmount(9);
                while(isPlayerHaveEnoughItems(p, 9, Material.DIAMOND)){
                    p.getInventory().removeItem(diamond);
                    if (!isInventoryFull(p, Material.DIAMOND_BLOCK, 64)) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
                    }else {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIAMOND_BLOCK));
                    }
                }
                p.sendMessage("Bloki zostaly zamienione!");
            }
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_iron_block"), "true")){
            if(isPlayerHaveEnoughItems(p, 9, Material.IRON_INGOT)){
                ItemStack iron = new ItemStack(Material.IRON_INGOT);
                iron.setAmount(9);
                while(isPlayerHaveEnoughItems(p, 9, Material.IRON_INGOT)){
                    p.getInventory().removeItem(iron);
                    if (!isInventoryFull(p, Material.IRON_BLOCK, 64)) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
                    }else {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.IRON_BLOCK));
                    }
                }
                p.sendMessage("Bloki zostaly zamienione!");
            }
        }
    }

    private boolean isInventoryFull(Player p, Material mat, int MaxV) {
        boolean inventoryFull = true;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getStorageContents()) {
                if (is != null) {
                    if (is.getType() == mat) {
                        if (is.getAmount() < MaxV) {
                            inventoryFull = false;
                        }
                    }
                } else {
                    inventoryFull = false;
                }
                //System.out.println(is.getType().toString() + " " + is.getAmount() + " "  + inventoryFull);
            }
        }
        return inventoryFull;
    }

    private static boolean isPlayerHaveEnoughItems(Player p, int Value, Material mat) {
        boolean isplayerhaveenoughitems;
        int i = 0;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getContents()) {
                if (is != null) {
                    if (is.getType() == mat) {
                        i = i + is.getAmount();
                    }
                }
            }
        }
        if(i >= Value) {
            isplayerhaveenoughitems = true;
        }else {
            isplayerhaveenoughitems = false;
        }
        return isplayerhaveenoughitems;
    }
}
