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

        if(b.getType().toString().contains("_ORE")) {
            e.setDropItems(false); //Zablokowanie wypadania itemow z rud
            //e.getBlock().setType(Material.AIR);
            //Inna opcja usuwania
            e.setExpToDrop(0); //Zablokowanie wypadania exp'a
        }

        if(b.getType() == Material.STONE) { //Zawsze

            if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(blockLocation, cobblestone);
                }
            }else {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
                }
            }


            if(percentChance(0.13)) { //13%
                if (plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        diamond.setAmount(diamond.getAmount() * itemAmoundRandom(1,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, diamond);
                    }
                } else {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND, itemAmoundRandom(1,3)));
                    }
                }
            }else if(percentChance(0.11)) { //11%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        emerald.setAmount(emerald.getAmount() * itemAmoundRandom(1,2));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, emerald);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.EMERALD, itemAmoundRandom(1,2)));
                    }
                }
            }else if (percentChance(0.18)) { //18%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".iron") == "true") {
                        iron.setAmount(iron.getAmount() * itemAmoundRandom(2,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, iron);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".iron") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, itemAmoundRandom(2,4)));
                    }
                }
            }else if (percentChance(0.10)) { //10%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        gold.setAmount(gold.getAmount() * itemAmoundRandom(2,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, gold);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, itemAmoundRandom(2,3)));
                    }
                }
            }else if (percentChance(0.09)) { //9%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        obsidian.setAmount(obsidian.getAmount() * itemAmoundRandom(1,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, obsidian);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, itemAmoundRandom(1,4)));
                    }
                }
            }else if (percentChance(0.11)) { //11%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".redstone") == "true") {
                        redstone.setAmount(redstone.getAmount() * itemAmoundRandom(1,5));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, redstone);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".redstone") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.REDSTONE, itemAmoundRandom(1,5)));
                    }
                }
            }else if (percentChance(0.001)) { //0.1%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".netherite") == "true") {
                        netherite.setAmount(netherite.getAmount() * itemAmoundRandom(1,2));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, netherite);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".netherite") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.NETHERITE_INGOT, itemAmoundRandom(1,2)));
                    }
                }
            }
        }
    }

}
