package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.items.Items;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.*;

import static org.bukkit.Material.*;
import static pl.pomoku.cobblestonedropgui.system.Random.itemAmoundRandom;
import static pl.pomoku.cobblestonedropgui.system.Random.percentChance;

public class OnBreak implements Listener {
    Main plugin;
    private final HashMap<UUID, Long> cooldowns;

    public OnBreak(Main m) {
        plugin = m;
        this.cooldowns = new HashMap<>();
    }

    @EventHandler
    public void OnBreak(BlockBreakEvent e) {

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
        ItemStack andesite = new ItemStack(Material.ANDESITE);
        ItemStack polished_andesite = new ItemStack(POLISHED_ANDESITE);
        ItemStack diorite = new ItemStack(DIORITE);
        ItemStack polished_diorite = new ItemStack(POLISHED_DIORITE);
        ItemStack granite = new ItemStack(Material.GRANITE);
        ItemStack polished_granite = new ItemStack(Material.POLISHED_GRANITE);
        ItemStack deepslate = new ItemStack(Material.DEEPSLATE);
        ItemStack polished_deepslate = new ItemStack(Material.POLISHED_DEEPSLATE);
        ItemStack tuff = new ItemStack(Material.TUFF);

        ItemStack ultra_block = Items.ultra_block();
        ItemStack throwtnt = Items.throwtnt();

        p.giveExp(1); //dodawanie exp'a

        //BLOKOWANIE RUD
        if (b.getType().toString().contains("_ORE")) {
            e.setDropItems(false);
            e.setExpToDrop(0);
        }
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType().name().toUpperCase().endsWith("_PICKAXE")) {
                if (b.getType() == Material.STONE) {
                    stones_mode(e, p, uuid, blockLocation, cobblestone, COBBLESTONE);
                } else if (b.getType() == Material.ANDESITE) {
                    stones_mode(e, p, uuid, blockLocation, andesite, ANDESITE);
                } else if (b.getType() == POLISHED_ANDESITE) {
                    stones_mode(e, p, uuid, blockLocation, polished_andesite, POLISHED_ANDESITE);
                } else if (b.getType() == DIORITE) {
                    stones_mode(e, p, uuid, blockLocation, diorite, DIORITE);
                } else if (b.getType() == POLISHED_DIORITE) {
                    stones_mode(e, p, uuid, blockLocation, polished_diorite, POLISHED_DIORITE);
                } else if (b.getType() == GRANITE) {
                    stones_mode(e, p, uuid, blockLocation, granite, GRANITE);
                } else if (b.getType() == POLISHED_GRANITE) {
                    stones_mode(e, p, uuid, blockLocation, polished_granite, POLISHED_GRANITE);
                } else if (b.getType() == DEEPSLATE) {
                    stones_mode(e, p, uuid, blockLocation, deepslate, DEEPSLATE);
                } else if (b.getType() == POLISHED_DEEPSLATE) {
                    stones_mode(e, p, uuid, blockLocation, polished_deepslate, POLISHED_DEEPSLATE);
                } else if (b.getType() == TUFF) {
                    stones_mode(e, p, uuid, blockLocation, tuff, TUFF);
                }
                if (b.getType() == Material.STONE || b.getType() == Material.ANDESITE || b.getType() == POLISHED_ANDESITE
                        || b.getType() == DIORITE || b.getType() == POLISHED_DIORITE || b.getType() == Material.GRANITE
                        || b.getType() == Material.POLISHED_GRANITE || b.getType() == Material.DEEPSLATE
                        || b.getType() == Material.POLISHED_DEEPSLATE || b.getType() == Material.TUFF) {
                    if (percentChance(0.13)) { //13%
                        items_drop_mode(p, uuid, ".diamond", 3, 1, 64, blockLocation, diamond, DIAMOND);
                    } else if (percentChance(0.11)) { //11%
                        items_drop_mode(p, uuid, ".emerald", 2, 1, 64, blockLocation, emerald, EMERALD);
                    } else if (percentChance(0.18)) { //18%
                        items_drop_mode(p, uuid, ".iron", 4, 2, 64, blockLocation, iron, IRON_INGOT);
                    } else if (percentChance(0.1)) { //10%
                        items_drop_mode(p, uuid, ".gold", 3, 2, 64, blockLocation, gold, GOLD_INGOT);
                    } else if (percentChance(0.09)) { //9%
                        items_drop_mode(p, uuid, ".obsidian", 4, 1, 64, blockLocation, obsidian, OBSIDIAN);
                    } else if (percentChance(0.11)) { //11%
                        items_drop_mode(p, uuid, ".redstone", 5, 1, 64, blockLocation, redstone, REDSTONE);
                    } else if (percentChance(0.001)) { //0.1%
                        items_drop_mode(p, uuid, ".netherite", 2, 1, 64, blockLocation, netherite, NETHERITE_INGOT);
                    } else if (percentChance(0.1)) { //10%
                        items_drop_mode(p, uuid, ".slimeball", 4, 2, 64, blockLocation, slimeball, SLIME_BALL);
                    } else if (percentChance(0.04)) { //4%
                        items_drop_mode(p, uuid, ".bookshelf", 4, 1, 64, blockLocation, bookshelf, BOOKSHELF);
                    } else if (percentChance(0.002)) { //0.2%
                        items_drop_mode(p, uuid, ".enderpearl", 2, 1, 16, blockLocation, enderpearl, ENDER_PEARL);
                    } else if (percentChance(0.003)) { //0.3%
                        items_drop_mode(p, uuid, ".tnt", 3, 1, 64, blockLocation, tnt, TNT);
                    } else if (percentChance(0.08)) { //8%
                        items_drop_mode(p, uuid, ".apple", 3, 2, 64, blockLocation, apple, APPLE);
                    } else if (percentChance(0.14)) { //14%
                        items_drop_mode(p, uuid, ".coal", 5, 3, 64, blockLocation, coal, COAL);
                    } else if (percentChance(0.04)) { //4%
                        items_drop_mode(p, uuid, ".oaklog", 8, 4, 64, blockLocation, oaklog, OAK_LOG);
                    } else if (percentChance(0.007)) { //0.7%
                        items_drop_mode(p, uuid, ".arrow", 4, 1, 64, blockLocation, arrow, ARROW);
                    } else if (percentChance(0.002)) { //0.2%
                        items_drop_mode_by_meta(p, uuid, ".throwtnt", blockLocation, throwtnt, "Rzucane TNT");
                    } else if (percentChance(0.0001)) { //0.01%
                        items_drop_mode_by_meta(p, uuid, ".ultra_block", blockLocation, ultra_block, "Ultra Block");
                    }
                }
            }
        }else {
            if (!this.cooldowns.containsKey(p.getUniqueId())) {
                this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                p.sendMessage(" ");
                p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                p.sendMessage(" ");
                p.sendMessage("§7Drop dziala §bwylacznie§7 na trybie §eSURVIVAL§7.");
                p.sendMessage(" ");
                p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                p.sendMessage(" ");
            } else {
                long timeElapsed = System.currentTimeMillis() - cooldowns.get(p.getUniqueId());
                if (timeElapsed >= 10000) {
                    this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                    p.sendMessage(" ");
                    p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                    p.sendMessage(" ");
                    p.sendMessage("§7Drop dziala §bwylacznie§7 na trybie §eSURVIVAL§7.");
                    p.sendMessage(" ");
                    p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                    p.sendMessage(" ");
                }
            }
        }
    }

    private void items_drop_mode_by_meta(Player p, UUID uuid, String i, Location blockLocation, ItemStack is, String s) {
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + i), "true")) {
                p.getLocation().getWorld().dropItemNaturally(blockLocation, is);
            }
        } else {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + i), "true")) {
                if (!isInventoryFullByMeta(p, s)) {
                    p.getInventory().addItem(is);
                } else {
                    not_enough_space_mode(p);
                }
            }
        }
    }

    private void items_drop_mode(Player p, UUID uuid, String i, int max, int min, int MaxV, Location blockLocation, ItemStack is, Material mat) {
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + i), "true")) {
                is.setAmount(is.getAmount() * itemAmoundRandom(min, max));
                p.getLocation().getWorld().dropItemNaturally(blockLocation, is);
            }
        } else {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + i), "true")) {
                if (!isInventoryFull(p, mat, MaxV)) {
                    p.getInventory().addItem(new ItemStack(mat, itemAmoundRandom(min, max)));
                } else {
                    not_enough_space_mode(p);
                }
            }
        }
    }

    private void stones_mode(BlockBreakEvent e, Player p, UUID uuid, Location bl, ItemStack is, Material mat) {
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
                e.setDropItems(false);
                p.getLocation().getWorld().dropItemNaturally(bl, is);
            } else {
                e.setDropItems(false);
            }
        } else {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
                if (!isInventoryFull(p, mat, 64)) {
                    e.setDropItems(false);
                    p.getInventory().addItem(new ItemStack(mat));
                } else {
                    e.setDropItems(false);
                    not_enough_space_mode(p);
                }
            } else {
                e.setDropItems(false);
            }
        }
    }

    public void not_enough_space_mode(Player p){
        UUID uuid = p.getUniqueId();
        p.sendMessage(" ");
        p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
        p.sendMessage(" ");
        p.sendMessage("§bNie masz miejsca w EQ! §7Drop do EQ zostal");
        p.sendMessage("§cwylaczony§7, jezeli chcesz go wlaczyc");
        p.sendMessage("§7oporznij ekwipunek.");
        p.sendMessage(" ");
        p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
        p.sendMessage(" ");
        PlayerDropConfig.get().set(uuid + ".eq", "true");
        PlayerDropConfig.save();
    }

    private boolean isInventoryFull(Player p, Material mat, int MaxV) {
        boolean inventoryFull = true;
        p.getInventory().getContents();
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
        }
        return inventoryFull;
    }

    private boolean isInventoryFullByMeta(Player p, String meta) {
        boolean inventoryFullByMeta = true;
        p.getInventory().getContents();
        for (ItemStack is : p.getInventory().getStorageContents()) {
            if (is != null) {
                if (is.getItemMeta().getDisplayName().contains(meta)) {
                    if (is.getAmount() < 64) {
                        inventoryFullByMeta = false;
                    }
                }
            } else {
                inventoryFullByMeta = false;
            }
        }
        return inventoryFullByMeta;
    }

}
