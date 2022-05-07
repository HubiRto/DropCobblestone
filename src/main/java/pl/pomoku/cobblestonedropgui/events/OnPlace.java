package pl.pomoku.cobblestonedropgui.events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.Material.*;

public class OnPlace implements Listener {
    Main plugin;
    public OnPlace(Main m) {
        plugin = m;
    }

    public boolean isOpen = false;

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(b.getType() == Material.TRAPPED_CHEST) {
            if(isOpen == false){
                b.setType(Material.AIR);
                spin(p);
                isOpen = true;
            }else {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "Poczekaj az sie otworzy ostania skrzynka");
            }
        }else {
            //p.sendMessage("elo2");
        }
    }

    List<Inventory> invs = new ArrayList<Inventory>();
    public static ItemStack[] contents;
    private int itemIndex = 0;

    public void shuffle(Inventory inv) {
        if(contents == null) {
            ItemStack[] items = new ItemStack[10];

            items[0] = new ItemStack(NETHERITE_SWORD, 1);
            items[1] = new ItemStack(NETHERITE_AXE, 1);
            items[2] = new ItemStack(NETHERITE_PICKAXE, 1);
            items[3] = new ItemStack(NETHERITE_SHOVEL, 1);
            items[4] = new ItemStack(Material.DIRT, 2);
            items[5] = new ItemStack(Material.BEDROCK, 2);
            items[6] = new ItemStack(Material.BEACON, 2);
            items[7] = new ItemStack(Material.DIAMOND_AXE, 1);
            items[8] = new ItemStack(Material.IRON_AXE, 1);
            items[9] = new ItemStack(Material.WOODEN_AXE, 1);

            ItemMeta meta0 = items[0].getItemMeta();
            meta0.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta0.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
            meta0.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
            meta0.addEnchant(Enchantment.DURABILITY, 4, true);
            items[0].setItemMeta(meta0);

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
        Inventory inv = Bukkit.createInventory(null, 27,ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Ultra Block");
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
                                switch(item.getType()){
                                    case NETHERITE_SWORD:
                                        if(isInventoryFull(player, NETHERITE_SWORD, 1) == false) {
                                            player.getInventory().addItem(item);
                                            player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowy miecz!");
                                            isOpen = false;
                                        }else {
                                            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            isOpen = false;
                                        }
                                        break;
                                    case NETHERITE_AXE:
                                        if(isInventoryFull(player, NETHERITE_AXE, 1) == false) {
                                            player.getInventory().addItem(item);
                                            player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowa sikiere!");
                                            isOpen = false;
                                        }else {
                                            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            isOpen = false;
                                        }
                                        break;
                                    case NETHERITE_PICKAXE:
                                        if(isInventoryFull(player, NETHERITE_PICKAXE, 1) == false) {
                                            player.getInventory().addItem(item);
                                            player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowy kilof!");
                                            isOpen = false;
                                        }else {
                                            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            isOpen = false;
                                        }
                                        break;
                                    case NETHERITE_SHOVEL:
                                        if(isInventoryFull(player, NETHERITE_SHOVEL, 1) == false) {
                                            player.getInventory().addItem(item);
                                            player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowa sikiere!");
                                            isOpen = false;
                                        }else {
                                            player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            isOpen = false;
                                        }
                                        break;
                                    default:
                                        isOpen = false;
                                        break;
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
                //System.out.println(is.getType().toString() + " " + is.getAmount() + " "  + inventoryFull);
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
