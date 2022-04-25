package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import pl.pomoku.cobblestonedropgui.main.Main;
import pl.pomoku.cobblestonedropgui.system.*;

import java.util.UUID;

import static pl.pomoku.cobblestonedropgui.system.Random.itemAmoundRandom;
import static pl.pomoku.cobblestonedropgui.system.Random.percentChance;

public class OnBreak implements Listener {
    Main plugin;

    public OnBreak(Main m) {
        plugin = m;
    }


    @EventHandler
    public void OnBreak (BlockBreakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        Block b = e.getBlock();

        Location blockLocation = e.getBlock().getLocation();

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
        ItemStack slimeball = new ItemStack(Material.SLIME_BALL);
        ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemStack tnt = new ItemStack(Material.TNT);
        ItemStack apple = new ItemStack(Material.APPLE);
        ItemStack coal = new ItemStack(Material.COAL);
        ItemStack oaklog = new ItemStack(Material.OAK_LOG);
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);

        if(b.getType() == Material.STONE) {

            if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(blockLocation, cobblestone);
                    //p.sendMessage("i1");
                }
            }else {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
                    //p.sendMessage("i2");
                }
            }


            if(percentChance(0.25)) {
                if (plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        diamond.setAmount(diamond.getAmount() * itemAmoundRandom(1,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, diamond);
                        //p.sendMessage("i1");
                    }
                } else {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND, itemAmoundRandom(1,3)));
                        //p.sendMessage("i2");
                    }
                }
            }else if(percentChance(0.11)) {
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        emerald.setAmount(emerald.getAmount() * itemAmoundRandom(1,2));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, emerald);
                        //p.sendMessage("i1");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.EMERALD, itemAmoundRandom(1,2)));
                        //p.sendMessage("i2");
                    }
                }
            }else if (percentChance(0.18)) {
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".iron") == "true") {
                        iron.setAmount(iron.getAmount() * itemAmoundRandom(2,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, iron);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".iron") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, itemAmoundRandom(2,4)));
                        //p.sendMessage("g");
                    }
                }
            }else if (percentChance(0.11)) { //20%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        gold.setAmount(gold.getAmount() * itemAmoundRandom(2,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, gold);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, itemAmoundRandom(2,3)));
                        //p.sendMessage("g");
                    }
                }
            }else if (percentChance(0.09)) { //10%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        obsidian.setAmount(obsidian.getAmount() * itemAmoundRandom(1,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, obsidian);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, itemAmoundRandom(1,4)));
                        //p.sendMessage("g");
                    }
                }
            }
        }
    }

}
