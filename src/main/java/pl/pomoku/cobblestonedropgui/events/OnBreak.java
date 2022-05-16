package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
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

/*    public void stones_mode(Event e, Player p){
        UUID uuid = p.getUniqueId();
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
                e.setDropItems(false);
                p.getLocation().getWorld().dropItemNaturally(blockLocation, cobblestone);
            } else {
                e.setDropItems(false);
            }
        } else {
            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
                if (!isInventoryFull(p, Material.COBBLESTONE, 64)) {
                    e.setDropItems(false);
                    p.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
                } else {
                    e.setDropItems(false);
                    not_enough_space_mode(p);
                }
            } else {
                e.setDropItems(false);
            }
        }
    }*/

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
        
        ItemStack ultra_block = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta ultra_block_meta = ultra_block.getItemMeta();
        ultra_block_meta.setDisplayName("§a§lUltra Block");
        List<String> ultra_block_lore = new ArrayList<>();
        ultra_block_lore.add("§7Jest to bardzo rzadka przedmiot z");
        ultra_block_lore.add("§7ktorego wypadaja bardzo cenne itemki.");
        ultra_block_lore.add(" ");
        ultra_block_lore.add("§ePostaw, aby otworzyc!");
        ultra_block_meta.setLore(ultra_block_lore);
        ultra_block.setItemMeta(ultra_block_meta);

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

        //BLOKOWANIE RUD
        if (b.getType().toString().contains("_ORE")) {
            e.setDropItems(false); //Zablokowanie wypadania itemow z rud
            //e.getBlock().setType(Material.AIR);
            //Inna opcja usuwania
            e.setExpToDrop(0); //Zablokowanie wypadania exp'a
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
            }
        }

        //  -------------
        //  DROP SUROWCÓW
        //  -------------

        if (b.getType() == Material.STONE || b.getType() == Material.ANDESITE || b.getType() == POLISHED_ANDESITE || b.getType() == DIORITE || b.getType() == POLISHED_DIORITE || b.getType() == Material.GRANITE || b.getType() == Material.POLISHED_GRANITE || b.getType() == Material.DEEPSLATE || b.getType() == Material.POLISHED_DEEPSLATE || b.getType() == Material.TUFF) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                if (e.getPlayer().getInventory().getItemInMainHand().getType().name().toUpperCase().endsWith("_PICKAXE")) {
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
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".slimeball"), "true")) {
                                slimeball.setAmount(slimeball.getAmount() * itemAmoundRandom(2, 4));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, slimeball);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".slimeball"), "true")) {
                                if (!isInventoryFull(p, Material.SLIME_BALL, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.SLIME_BALL, itemAmoundRandom(2, 4)));
                                } else {
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
                            }
                        }
                        //BOOKSHELF
                    } else if (percentChance(0.04)) { //4%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".bookshelf"), "true")) {
                                bookshelf.setAmount(bookshelf.getAmount() * itemAmoundRandom(1, 4));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, bookshelf);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".bookshelf"), "true")) {
                                if (!isInventoryFull(p, Material.BOOKSHELF, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.BOOKSHELF, itemAmoundRandom(1, 4)));
                                } else {
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
                            }
                        }
                        //ENDER PEARL
                    } else if (percentChance(0.002)) { //0.2%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".enderpearl"), "true")) {
                                enderpearl.setAmount(enderpearl.getAmount() * itemAmoundRandom(1, 2));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, enderpearl);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".enderpearl"), "true")) {
                                if (!isInventoryFull(p, Material.ENDER_PEARL, 16)) {
                                    p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, itemAmoundRandom(1, 2)));
                                } else {
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
                            }
                        }
                        //TNT
                    } else if (percentChance(0.003)) { //0.3%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".tnt"), "true")) {
                                tnt.setAmount(tnt.getAmount() * itemAmoundRandom(1, 3));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, tnt);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".tnt"), "true")) {
                                if (!isInventoryFull(p, Material.TNT, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.TNT, itemAmoundRandom(1, 3)));
                                } else {
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
                            }
                        }
                        //APPLE
                    } else if (percentChance(0.08)) { //8%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".apple"), "true")) {
                                apple.setAmount(apple.getAmount() * itemAmoundRandom(2, 3));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, apple);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".apple"), "true")) {
                                if (!isInventoryFull(p, Material.APPLE, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.APPLE, itemAmoundRandom(2, 3)));
                                } else {
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
                            }
                        }
                        //COAL
                    } else if (percentChance(0.14)) { //14%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".coal"), "true")) {
                                coal.setAmount(coal.getAmount() * itemAmoundRandom(3, 5));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, coal);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".coal"), "true")) {
                                if (!isInventoryFull(p, Material.COAL, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.COAL, itemAmoundRandom(3, 5)));
                                } else {
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
                            }
                        }
                        //OAK LOG
                    } else if (percentChance(0.04)) { //4%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".oaklog"), "true")) {
                                oaklog.setAmount(oaklog.getAmount() * itemAmoundRandom(4, 8));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, oaklog);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".oaklog"), "true")) {
                                if (!isInventoryFull(p, Material.OAK_LOG, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.OAK_LOG, itemAmoundRandom(4, 8)));
                                } else {
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
                            }
                        }
                        //ARROW
                    } else if (percentChance(0.007)) { //0.7%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".arrow"), "true")) {
                                arrow.setAmount(arrow.getAmount() * itemAmoundRandom(1, 4));
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, arrow);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".arrow"), "true")) {
                                if (!isInventoryFull(p, Material.ARROW, 64)) {
                                    p.getInventory().addItem(new ItemStack(Material.ARROW, itemAmoundRandom(1, 4)));
                                } else {
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
                            }
                        }
                    } else if (percentChance(0.002)) { //0.2%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".throwtnt"), "true")) {
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, throwtnt);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".throwtnt"), "true")) {
                                if (!isInventoryFullByMeta(p, "Rzucane TNT", 64)) {
                                    p.getInventory().addItem(throwtnt);
                                } else {
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
                            }
                        }
                        //TRAPPED_CHEST
                    } else if (percentChance(0.1)) { //0.01%
                        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".ultra_block"), "true")) {
                                p.getLocation().getWorld().dropItemNaturally(blockLocation, ultra_block);
                            }
                        } else {
                            if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".ultra_block"), "true")) {
                                if (!isInventoryFull(p, Material.TRAPPED_CHEST, 64)) {
                                    p.getInventory().addItem(ultra_block);
                                } else {
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
                            }
                        }
                        //IRON
                    }
                }
            } else {
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

    private boolean isInventoryFullByMeta(Player p, String meta, int MaxV) {
        boolean inventoryFullByMeta = true;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getStorageContents()) {
                if (is != null) {
                    if (is.getItemMeta().getDisplayName().contains(meta)) {
                        if (is.getAmount() < MaxV) {
                            inventoryFullByMeta = false;
                        }
                    }
                } else {
                    inventoryFullByMeta = false;
                }
            }
        }
        return inventoryFullByMeta;
    }

}
