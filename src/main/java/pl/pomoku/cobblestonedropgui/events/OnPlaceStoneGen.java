package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import pl.pomoku.cobblestonedropgui.items.Items;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;

public class OnPlaceStoneGen implements Listener {
    Main plugin;
    public OnPlaceStoneGen(Main m) {
        plugin = m;
    }

    private ArrayList<Location> blocksLocations = new ArrayList<>();

    @EventHandler
    public void OnPlace(BlockPlaceEvent e) {
        Block b  = e.getBlock();
        Player p = e.getPlayer();

        if(b.getType() == Material.END_STONE){
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Stoniarka")){
                b.setType(Material.STONE);
                blocksLocations.add(b.getLocation());
                p.sendMessage(ChatColor.GREEN + "Postawiono stoniarke!");
            }
        }
    }
    @EventHandler
    public void OnBreak(BlockBreakEvent e) {

        ItemStack stoniarka = Items.stoniarka();

        Block b2 = e.getBlock();
        Location b2_loc = b2.getLocation();
        Player p2 = e.getPlayer();

        if(blocksLocations.contains(b2_loc)){
            if(b2.getType() == Material.STONE){
                if(p2.getInventory().getItemInMainHand().getType() == Material.GOLDEN_PICKAXE){
                    b2.setType(Material.AIR);
                    p2.sendMessage(ChatColor.RED + "Zniszczono stonirake!");
                    p2.getInventory().addItem(stoniarka);
                }else {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> b2.setType(Material.STONE), 20);
                }
            }
        }
    }
}
