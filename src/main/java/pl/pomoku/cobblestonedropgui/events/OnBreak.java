package pl.pomoku.cobblestonedropgui.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;
import pl.pomoku.cobblestonedropgui.system.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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

        ItemStack throwtnt = new ItemStack(Material.TNT);
        ItemMeta throwtnt_meta = throwtnt.getItemMeta();
        throwtnt_meta.setDisplayName(ChatColor.RED + "Rzucane TNT");
        List<String> throwtnt_lore = new ArrayList<>();
        throwtnt_lore.add(ChatColor.YELLOW + "Przytrzymaj PPM, aby rzucic");
        throwtnt_lore.add(ChatColor.YELLOW + "lub pozostaw na ziemi.");
        throwtnt_meta.setLore(throwtnt_lore);
        throwtnt_meta.addEnchant(Enchantment.LUCK, 1, false);
        throwtnt_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        throwtnt.setItemMeta(throwtnt_meta);


        if(b.getType().toString().contains("_ORE")) {
            e.setDropItems(false); //Zablokowanie wypadania itemow z rud
            //e.getBlock().setType(Material.AIR);
            //Inna opcja usuwania
            e.setExpToDrop(0); //Zablokowanie wypadania exp'a
        }

        if(b.getType() == Material.STONE) { //Zawsze

            if(plugin.getConfig().getString(uuid + ".eq") == "true") {

                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    e.setDropItems(false);
                    p.getLocation().getWorld().dropItemNaturally(blockLocation, cobblestone);
                }else {
                    e.setDropItems(false);
                }
            }else {
                if (plugin.getConfig().getString(uuid + ".cobblestone") == "true") {
                    if(isInventoryFull(p, Material.COBBLESTONE, 64) == false) {
                        e.setDropItems(false);
                        p.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
                    }else {
                        e.setDropItems(false);
                        //p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Nie masz miejsca w EQ!"));
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.YELLOW + "Nie masz miejsca w EQ! " + ChatColor.GRAY + "Drop do EQ zostal " + ChatColor.RED + "wylaczony" + ChatColor.GRAY + ", jezeli chcesz go wlaczyc oporznij ekwipunek.");
                        p.sendMessage(" ");
                        plugin.getConfig().set(uuid + ".eq", "true");
                        plugin.saveConfig();
                    }
                } else {
                    e.setDropItems(false);
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
                        //if(isInventoryFull(p, Material.DIAMOND, 64))
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
            }else if(percentChance(0.4)) { //11%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".throwtnt") == "true") {
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, throwtnt);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".throwtnt") == "true") {
                        p.getInventory().addItem(throwtnt);
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
            }else if (percentChance(0.10)) { //10%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".slimeball") == "true") {
                        slimeball.setAmount(slimeball.getAmount() * itemAmoundRandom(2,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, slimeball);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".slimeball") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.SLIME_BALL, itemAmoundRandom(2,4)));
                    }
                }
            }else if (percentChance(0.04)) { //4%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".bookshelf") == "true") {
                        bookshelf.setAmount(bookshelf.getAmount() * itemAmoundRandom(1,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, bookshelf);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".bookshelf") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.BOOKSHELF, itemAmoundRandom(1,4)));
                    }
                }
            }else if (percentChance(0.002)) { //0.2%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".enderpearl") == "true") {
                        enderpearl.setAmount(enderpearl.getAmount() * itemAmoundRandom(1,2));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, enderpearl);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".enderpearl") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, itemAmoundRandom(1,2)));
                    }
                }
            }else if (percentChance(0.003)) { //0.3%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".tnt") == "true") {
                        tnt.setAmount(tnt.getAmount() * itemAmoundRandom(1,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, tnt);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".tnt") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.TNT, itemAmoundRandom(1,3)));
                    }
                }
            }else if (percentChance(0.08)) { //8%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".apple") == "true") {
                        apple.setAmount(apple.getAmount() * itemAmoundRandom(2,3));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, apple);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".apple") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.APPLE, itemAmoundRandom(2,3)));
                    }
                }
            }else if (percentChance(0.14)) { //14%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".coal") == "true") {
                        coal.setAmount(coal.getAmount() * itemAmoundRandom(3,5));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, coal);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".coal") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.COAL, itemAmoundRandom(3,5)));
                    }
                }
            }else if (percentChance(0.04)) { //4%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".oaklog") == "true") {
                        oaklog.setAmount(oaklog.getAmount() * itemAmoundRandom(4,8));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, oaklog);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".oaklog") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.OAK_LOG, itemAmoundRandom(4,8)));
                    }
                }
            }else if (percentChance(0.007)) { //0.7%
                if(plugin.getConfig().getString(uuid + ".eq") == "true") {
                    if (plugin.getConfig().getString(uuid + ".arrow") == "true") {
                        arrow.setAmount(arrow.getAmount() * itemAmoundRandom(1,4));
                        p.getLocation().getWorld().dropItemNaturally(blockLocation, arrow);
                    }
                }else {
                    if (plugin.getConfig().getString(uuid + ".arrow") == "true") {
                        p.getInventory().addItem(new ItemStack(Material.ARROW, itemAmoundRandom(1,4)));
                    }
                }
            }
        }

    }

    private boolean isInventoryFull(Player p, Material mat, int MaxV) {
        boolean inventoryFull = true;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getStorageContents()) {
                if(is != null) {
                    if (is.getType() == mat) {
                        if (is.getAmount() < MaxV) {
                            inventoryFull = false;
                        }
                    }
                }else {
                    inventoryFull = false;
                }
                //System.out.println(is.getType().toString() + " " + is.getAmount() + " "  + inventoryFull);
            }
        }
        return inventoryFull;
    }

}
