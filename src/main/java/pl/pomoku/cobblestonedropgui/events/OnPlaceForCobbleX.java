package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.Material.*;

public class OnPlaceForCobbleX implements Listener {
    Main plugin;
    private final HashMap<UUID, Long> cooldowns;
    public OnPlaceForCobbleX(Main m) {
        plugin = m;
        this.cooldowns = new HashMap<>();
    }

    public boolean isOpen = false;

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if(isOpen) {
            if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Cobble X")) return;
            p.sendMessage(" ");
            p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
            p.sendMessage(" ");
            p.sendMessage("§7Zamknales skrzynke z losowaniem.");
            p.sendMessage("§ePoczekaj az przedmiot sie wylosuje!");
            p.sendMessage(" ");
            p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
            p.sendMessage(" ");
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() == Material.TRAPPED_CHEST) {
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Cobble X")) {
                if (!isOpen) {
                    b.setType(Material.AIR);
                    spin(p);
                    isOpen = true;
                } else {
                    e.setCancelled(true);
                    if(!this.cooldowns.containsKey(p.getUniqueId())) {
                        this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                        p.sendMessage(" ");
                        p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                        p.sendMessage(" ");
                        p.sendMessage("§cPoczekaj az zostanie zakonczone");
                        p.sendMessage("§costatnie loswoanie!");
                        p.sendMessage(" ");
                        p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                        p.sendMessage(" ");
                    }else {
                        long timeElapsed = System.currentTimeMillis() - cooldowns.get(p.getUniqueId());
                        if(timeElapsed >= 10000) {
                            this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                            p.sendMessage(" ");
                            p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                            p.sendMessage(" ");
                            p.sendMessage("§cPoczekaj az zostanie zakonczone");
                            p.sendMessage("§costatnie loswoanie!");
                            p.sendMessage(" ");
                            p.sendMessage("§8[§c+§8]§m------------§r§8[ §cALERT §8]§m------------§r§8[§c+§8]");
                            p.sendMessage(" ");
                        }
                    }
                }
            }
        }
    }
    List<Inventory> invs = new ArrayList<>();
    public static ItemStack[] contents;
    private int itemIndex = 0;

    public void shuffle(Inventory inv) {
        if(contents == null) {
            ItemStack[] items = new ItemStack[18];

            items[0] = new ItemStack(DIAMOND, 24);
            items[1] = new ItemStack(EMERALD, 24);
            items[2] = new ItemStack(OBSIDIAN, 24);
            items[3] = new ItemStack(GOLDEN_APPLE, 4);
            items[4] = new ItemStack(NETHERITE_INGOT, 4);
            items[5] = new ItemStack(ENCHANTING_TABLE, 1);
            items[6] = new ItemStack(ENCHANTED_GOLDEN_APPLE, 1);
            items[7] = new ItemStack(ENDER_PEARL, 4);
            items[8] = new ItemStack(APPLE, 4);
            items[9] = new ItemStack(TNT, 16);
            items[10] = new ItemStack(DIAMOND_SWORD, 1);
            items[11] = new ItemStack(DIAMOND_PICKAXE, 1);
            items[12] = new ItemStack(DIAMOND_AXE, 1);
            items[13] = new ItemStack(DIAMOND_SHOVEL, 1);
            items[14] = new ItemStack(DIAMOND_BOOTS, 1);
            items[15] = new ItemStack(DIAMOND_LEGGINGS, 1);
            items[16] = new ItemStack(DIAMOND_CHESTPLATE, 1);
            items[17] = new ItemStack(DIAMOND_HELMET, 1);

            ItemMeta meta10 = items[10].getItemMeta();
            meta10.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
            meta10.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
            meta10.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
            meta10.addEnchant(Enchantment.DURABILITY, 3, false);
            items[10].setItemMeta(meta10);

            for(int a = 10; a < 14; a++) {
                ItemMeta meta_a = items[a].getItemMeta();
                meta_a.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
                meta_a.addEnchant(Enchantment.DIG_SPEED, 5, false);
                meta_a.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
                meta_a.addEnchant(Enchantment.DURABILITY, 3, false);
                items[a].setItemMeta(meta_a);
            }
            for(int b = 14; b < 18; b++) {
                ItemMeta meta_b = items[b].getItemMeta();
                meta_b.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
                meta_b.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
                meta_b.addEnchant(Enchantment.DURABILITY, 3, false);
                items[b].setItemMeta(meta_b);
            }

            contents = items;
        }
        int startingIndex = ThreadLocalRandom.current().nextInt(contents.length);

        for(int index = 0; index < startingIndex; index++) {
            for(int itemstacks = 9; itemstacks < 18; itemstacks++) {
                inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
            }
            itemIndex++;
        }
        //Tlo
        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta hopper_meta = hopper.getItemMeta();
        hopper_meta.setDisplayName(" ");
        hopper_meta.addEnchant(Enchantment.LUCK, 1, false);
        hopper_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        hopper.setItemMeta(hopper_meta);
        inv.setItem(4, hopper);

        ItemStack blackstainedglasspane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackstainedglasspane_meta = blackstainedglasspane.getItemMeta();
        blackstainedglasspane_meta.setDisplayName(" ");
        blackstainedglasspane.setItemMeta(blackstainedglasspane_meta);

        for(int i = 0; i < 4; i++) {
            inv.setItem(i, blackstainedglasspane);
        }
        for(int i = 5; i < 9; i++) {
            inv.setItem(i, blackstainedglasspane);
        }
        for(int i = 18; i < 27; i++) {
            inv.setItem(i, blackstainedglasspane);
        }
    }


    public void spin(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 27,ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Cobble X");
        shuffle(inv);
        invs.add(inv);
        player.openInventory(inv);

        java.util.Random r = new Random();
        double seconds = 7.0 + (12.0 - 7.0) * r.nextDouble();

        new BukkitRunnable() {
            double delay = 0;
            int ticks = 0;
            boolean done = false;

            public void run() {
                if(done) {
                    return;
                }
                ticks++;
                delay += 1 / (20*seconds);
                if(ticks > delay*10) {
                    ticks = 0;
                    for(int itemstacks = 9; itemstacks < 18; itemstacks++) {
                        inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
                    }
                    itemIndex++;
                    if(delay >= .5) {
                        done = true;
                        new BukkitRunnable() {
                            public void run() {
                                ItemStack item = inv.getItem(13);
                                if (item != null) {
                                    player.sendMessage(" ");
                                    player.sendMessage("§8[§c+§8]§m-----------§r§8[ §6NAGRODA §8]§m-----------§r§8[§c+§8]");
                                    player.sendMessage(" ");
                                    player.sendMessage("§eGratulacje! §bWylosowales§8: " + "§7" + item.getType().name().replace("_", " ").toLowerCase() + " §8x§b " + item.getAmount());
                                    player.sendMessage(" ");
                                    player.sendMessage("§8[§c+§8]§m-----------§r§8[ §6NAGRODA §8]§m-----------§r§8[§c+§8]");
                                    player.sendMessage(" ");
                                    switch (item.getType()) {
                                        case DIAMOND -> {
                                            if (!isInventoryFull(player, DIAMOND, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case EMERALD -> {
                                            if (!isInventoryFull(player, EMERALD, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case OBSIDIAN -> {
                                            if (!isInventoryFull(player, OBSIDIAN, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case GOLDEN_APPLE -> {
                                            if (!isInventoryFull(player, GOLDEN_APPLE, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case NETHERITE_INGOT -> {
                                            if (!isInventoryFull(player, NETHERITE_INGOT, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case ENCHANTING_TABLE -> {
                                            if (!isInventoryFull(player, ENCHANTING_TABLE, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case ENCHANTED_GOLDEN_APPLE -> {
                                            if (!isInventoryFull(player, ENCHANTED_GOLDEN_APPLE, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case ENDER_PEARL -> {
                                            if (!isInventoryFull(player, ENDER_PEARL, 16)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case APPLE -> {
                                            if (!isInventoryFull(player, APPLE, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case TNT -> {
                                            if (!isInventoryFull(player, TNT, 64)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_SWORD -> {
                                            if (!isInventoryFull(player, DIAMOND_SWORD, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_PICKAXE -> {
                                            if (!isInventoryFull(player, DIAMOND_PICKAXE, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_AXE -> {
                                            if (!isInventoryFull(player, DIAMOND_AXE, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_SHOVEL -> {
                                            if (!isInventoryFull(player, DIAMOND_SHOVEL, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_BOOTS -> {
                                            if (!isInventoryFull(player, DIAMOND_BOOTS, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_LEGGINGS -> {
                                            if (!isInventoryFull(player, DIAMOND_LEGGINGS, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_CHESTPLATE -> {
                                            if (!isInventoryFull(player, DIAMOND_CHESTPLATE, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        case DIAMOND_HELMET -> {
                                            if (!isInventoryFull(player, DIAMOND_HELMET, 1)) {
                                                player.getInventory().addItem(item);
                                            } else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                        }
                                        default -> {
                                            player.sendMessage(ChatColor.RED + "Nie wylosowales rzadnego przedmiotu?" + ChatColor.YELLOW + " Zglos to do administracji!");
                                            isOpen = false;
                                        }
                                    }
                                }
                                player.updateInventory();
                                player.closeInventory();
                                cancel();
                            }

                        }.runTaskLater(Main.getPlugin(Main.class), 50);
                        cancel();
                    }
                }
            }

        }.runTaskTimer(this.plugin, 0, 1);

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
            }
        }
        return inventoryFull;
    }

    @EventHandler
    public void OnClick(InventoryClickEvent event) {
        if(!invs.contains(event.getInventory())) {
            return;
        }
        event.setCancelled(true);
        return;
    }

}
