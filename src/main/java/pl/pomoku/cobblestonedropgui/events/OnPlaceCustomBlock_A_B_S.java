package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.pomoku.cobblestonedropgui.main.Main;

import static org.bukkit.Material.*;

public class OnPlaceCustomBlock_A_B_S implements Listener {
    Main plugin;
    public OnPlaceCustomBlock_A_B_S(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(b.getType() == RED_GLAZED_TERRACOTTA) {
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Auto Fosa")){
                for(int i = b.getY(); i > -64; i--) {
                    Location loc = new Location(p.getLocation().getWorld(), b.getX(), i, b.getZ());
                    if(loc.getBlock().getType().equals(Material.BEDROCK)) {
                        i = -64;
                    }else {
                        loc.getBlock().setType(Material.AIR);
                    }
                }
            }
        }
        else if(b.getType() == LIME_GLAZED_TERRACOTTA) {
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Sand Farmer")){
                for(int i = b.getY(); i > -64; i--) {
                    Location loc = new Location(p.getLocation().getWorld(), b.getX(), i, b.getZ());
                    if(loc.getBlock().getType().equals(Material.BEDROCK)) {
                        i = -64;
                    }else {
                        loc.getBlock().setType(Material.SAND);
                    }
                }
            }
        }
        else if(b.getType() == PURPLE_GLAZED_TERRACOTTA) {
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Boy Farmer")){
                for(int i = b.getY(); i > -64; i--) {
                    Location loc = new Location(p.getLocation().getWorld(), b.getX(), i, b.getZ());
                    if(loc.getBlock().getType().equals(Material.BEDROCK)) {
                        i = -64;
                    }else {
                        loc.getBlock().setType(Material.OBSIDIAN);
                    }
                }
            }
        }
    }
}
