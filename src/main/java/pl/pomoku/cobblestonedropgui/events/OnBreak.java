package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import pl.pomoku.cobblestonedropgui.main.Main;
import pl.pomoku.cobblestonedropgui.system.Random;
import pl.pomoku.cobblestonedropgui.system.Random_2;

import java.util.UUID;

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

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);

        if(b.getType() == Material.STONE) {
            int rand = Random.getRandom();
            int rand_2 = Random_2.getRandom();

            if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), cobblestone);
                    //p.sendMessage("i1");
                }
            }else {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
                    //p.sendMessage("i2");
                }
            }


            if(rand <= 1300) { //40%
                if (plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), iron);
                        //p.sendMessage("i1");
                    }
                } else {
                    if (plugin.getConfig().getString(uuid + ".diamond") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND, rand_2));
                        //p.sendMessage("i2");
                    }
                }
            }if(rand <= 1100) { //40%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), iron);
                        //p.sendMessage("i1");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.EMERALD));
                        //p.sendMessage("i2");
                    }
                }
            }else if (rand > 4 && rand <= 7) { //30%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), gold);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                        //p.sendMessage("g");
                    }
                }
            }else if (rand > 7 && rand <= 9) { //20%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), obsidian);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".obsidian") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.OBSIDIAN));
                        //p.sendMessage("g");
                    }
                }
            }else if (rand == 10) { //10%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), emerald);
                        //p.sendMessage("g");
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".emerald") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.EMERALD));
                        //p.sendMessage("g");
                    }
                }
            }
        }
    }

}
