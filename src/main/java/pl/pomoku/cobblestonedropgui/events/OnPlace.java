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
import static org.bukkit.enchantments.Enchantment.ARROW_KNOCKBACK;

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
            ItemStack[] items = new ItemStack[27];

            items[0] = new ItemStack(NETHERITE_SWORD, 1);
            items[1] = new ItemStack(NETHERITE_AXE, 1);
            items[2] = new ItemStack(NETHERITE_PICKAXE, 1);
            items[3] = new ItemStack(NETHERITE_SHOVEL, 1);
            items[4] = new ItemStack(NETHERITE_BOOTS, 1);
            items[5] = new ItemStack(NETHERITE_LEGGINGS, 1);
            items[6] = new ItemStack(NETHERITE_CHESTPLATE, 1);
            items[7] = new ItemStack(NETHERITE_HELMET, 1);
            items[8] = new ItemStack(RED_GLAZED_TERRACOTTA, 64);
            items[9] = new ItemStack(PURPLE_GLAZED_TERRACOTTA, 64);
            items[10] = new ItemStack(LIME_GLAZED_TERRACOTTA, 64);
            items[11] = new ItemStack(TNT, 6);
            items[12] = new ItemStack(TRAPPED_CHEST, 6);
            items[13] = new ItemStack(CROSSBOW, 1);
            items[14] = new ItemStack(ENCHANTED_GOLDEN_APPLE, 4);
            items[15] = new ItemStack(GOLDEN_APPLE, 16);
            items[16] = new ItemStack(ENDER_PEARL, 8);
            items[17] = new ItemStack(BOW, 1);
            items[18] = new ItemStack(CHORUS_FLOWER, 3);
            items[19] = new ItemStack(BOW, 1);
            items[20] = new ItemStack(SHULKER_BOX, 5);
            items[21] = new ItemStack(DIAMOND_BLOCK, 16);
            items[22] = new ItemStack(BEACON, 1);
            items[23] = new ItemStack(ELYTRA, 1);
            items[24] = new ItemStack(TRIDENT, 1);
            items[25] = new ItemStack(TOTEM_OF_UNDYING, 1);
            items[26] = new ItemStack(HEART_OF_THE_SEA, 1);

            ItemMeta meta0 = items[0].getItemMeta();
            meta0.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta0.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
            meta0.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
            meta0.addEnchant(Enchantment.DURABILITY, 4, true);
            items[0].setItemMeta(meta0);

            ItemMeta meta1 = items[1].getItemMeta();
            meta1.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta1.addEnchant(Enchantment.DIG_SPEED, 5, false);
            meta1.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
            meta1.addEnchant(Enchantment.DURABILITY, 4, true);
            items[1].setItemMeta(meta1);

            ItemMeta meta2 = items[2].getItemMeta();
            meta2.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta2.addEnchant(Enchantment.DIG_SPEED, 6, true);
            meta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
            meta2.addEnchant(Enchantment.DURABILITY, 4, true);
            items[2].setItemMeta(meta2);

            ItemMeta meta3 = items[3].getItemMeta();
            meta3.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta3.addEnchant(Enchantment.DIG_SPEED, 5, false);
            meta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
            meta3.addEnchant(Enchantment.DURABILITY, 4, true);
            items[3].setItemMeta(meta3);

            for(int m = 4; m < 8; m++) {
                ItemMeta meta_m = items[m].getItemMeta();
                meta_m.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
                meta_m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
                meta_m.addEnchant(Enchantment.DURABILITY, 4, true);
                items[m].setItemMeta(meta_m);
            }

            ItemMeta meta8 = items[8].getItemMeta();
            meta8.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
            meta8.addEnchant(Enchantment.LUCK, 1, true);
            meta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            items[8].setItemMeta(meta8);

            ItemMeta meta9 = items[9].getItemMeta();
            meta9.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
            meta9.addEnchant(Enchantment.LUCK, 1, true);
            meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            items[9].setItemMeta(meta9);

            ItemMeta meta10 = items[10].getItemMeta();
            meta10.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
            meta10.addEnchant(Enchantment.LUCK, 1, true);
            meta10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            items[10].setItemMeta(meta10);

            ItemMeta meta11 = items[11].getItemMeta();
            meta11.setDisplayName(ChatColor.RED + "Rzucane TNT");
            List<String> meta11_lore = new ArrayList<>();
            meta11_lore.add(ChatColor.YELLOW + "Przytrzymaj PPM, aby rzucic");
            meta11_lore.add(ChatColor.YELLOW + "lub pozostaw na ziemi.");
            meta11.setLore(meta11_lore);
            meta11.addEnchant(Enchantment.LUCK, 1, true);
            meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            items[11].setItemMeta(meta11);

            ItemMeta meta12 = items[12].getItemMeta();
            meta12.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
            List<String> meta12_lore = new ArrayList<>();
            meta12_lore.add("§7Jest to skrzynia z ktorej");
            meta12_lore.add("§7wypadaja bardzo cenne itemki.");
            meta12_lore.add(" ");
            meta12_lore.add("§ePostaw, aby otworzyc!");
            meta12.setLore(meta12_lore);
            items[12].setItemMeta(meta12);

            ItemMeta meta13 = items[13].getItemMeta();
            meta13.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta13.addEnchant(Enchantment.MULTISHOT, 1, false);
            meta13.addEnchant(Enchantment.QUICK_CHARGE, 3, false);
            meta13.addEnchant(Enchantment.DURABILITY, 4, true);
            items[13].setItemMeta(meta13);

            ItemMeta meta17 = items[17].getItemMeta();
            meta17.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta17.addEnchant(ARROW_KNOCKBACK ,2, false);
            meta17.addEnchant(Enchantment.DURABILITY, 4, true);
            items[17].setItemMeta(meta17);

            ItemMeta meta19 = items[19].getItemMeta();
            meta19.setDisplayName(ChatColor.GRAY + "Przedmiot z " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ultra Block");
            meta19.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
            meta19.addEnchant(Enchantment.ARROW_DAMAGE ,2, false);
            meta19.addEnchant(Enchantment.DURABILITY, 4, true);
            items[19].setItemMeta(meta19);

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
                                //System.out.println(item.getType().name());
                                if (item != null) {
                                    switch(item.getType()){
                                        case NETHERITE_SWORD:
                                            if(!isInventoryFull(player, NETHERITE_SWORD, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowy miecz!" + item.getType().name().replace("_", " "));
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_AXE:
                                            if(!isInventoryFull(player, NETHERITE_AXE, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowa sikiere!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_PICKAXE:
                                            if(!isInventoryFull(player, NETHERITE_PICKAXE, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowy kilof!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_SHOVEL:
                                            if(!isInventoryFull(player, NETHERITE_SHOVEL, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowa sikiere!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_BOOTS:
                                            if(!isInventoryFull(player, NETHERITE_BOOTS, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowe buty!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_LEGGINGS:
                                            if(!isInventoryFull(player, NETHERITE_LEGGINGS, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowe spodnie!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_CHESTPLATE:
                                            if(!isInventoryFull(player, NETHERITE_CHESTPLATE, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowa klate!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case NETHERITE_HELMET:
                                            if(!isInventoryFull(player, NETHERITE_HELMET, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales netariatowy kask!");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case RED_GLAZED_TERRACOTTA:
                                            if(!isInventoryFullByMeta(player, "Auto Fosa", 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Auto Fose x64");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case PURPLE_GLAZED_TERRACOTTA:
                                            if(!isInventoryFullByMeta(player, "Boy Farmer", 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Boy Farmera x64");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case LIME_GLAZED_TERRACOTTA:
                                            if(!isInventoryFullByMeta(player, "Sand Farmer", 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Sand Farmera x64");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case TNT:
                                            if(!isInventoryFullByMeta(player, "Rzucane TNT", 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Rzucane TNT x6");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case TRAPPED_CHEST:
                                            if(!isInventoryFullByMeta(player, "Cobble X", 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Cobble X x6");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case ENCHANTED_GOLDEN_APPLE:
                                            if(!isInventoryFull(player, ENCHANTED_GOLDEN_APPLE, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Zlote Jablko Nocha x4");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case GOLDEN_APPLE:
                                            if(!isInventoryFull(player, GOLDEN_APPLE, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Zlote Jablko x16");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case ENDER_PEARL:
                                            if(!isInventoryFull(player, ENDER_PEARL, 16)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Perly x8");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case BOW:
                                            Map<Enchantment, Integer> enchantments = item.getEnchantments();
                                            if(enchantments.containsKey(ARROW_KNOCKBACK)) {
                                                if(!isInventoryFull(player, BOW, 1)) {
                                                    player.getInventory().addItem(item);
                                                    player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Odrzucajacy Luk");
                                                }else {
                                                    player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                                }
                                            }else {
                                                if(!isInventoryFull(player, BOW, 1)) {
                                                    player.getInventory().addItem(item);
                                                    player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Silny Luk");
                                                }else {
                                                    player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                                }
                                            }
                                            isOpen = false;
                                            break;
                                        case CHORUS_FLOWER:
                                            if(!isInventoryFull(player, CHORUS_FLOWER, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Owoce Chorus x3");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case SHULKER_BOX:
                                            if(!isInventoryFull(player, SHULKER_BOX, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Shulkerowa Skrzynie x5");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case DIAMOND_BLOCK:
                                            if(!isInventoryFull(player, DIAMOND_BLOCK, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Bloki Diamentow x16");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case BEACON:
                                            if(!isInventoryFull(player, BEACON, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Beacon");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case ELYTRA:
                                            if(!isInventoryFull(player, ELYTRA, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Elytre");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case TRIDENT:
                                            if(!isInventoryFull(player, TRIDENT, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Trident");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case TOTEM_OF_UNDYING:
                                            if(!isInventoryFull(player, TOTEM_OF_UNDYING, 1)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Totem Niesmiertelnosci");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        case HEART_OF_THE_SEA:
                                            if(!isInventoryFull(player, HEART_OF_THE_SEA, 64)) {
                                                player.getInventory().addItem(item);
                                                player.sendMessage(ChatColor.GOLD + "Gratulacje! " + ChatColor.GREEN + "Wylosowales Serce Oceanu");
                                            }else {
                                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                                            }
                                            isOpen = false;
                                            break;
                                        default:
                                            player.sendMessage(ChatColor.RED + "Nie wylosowales rzadnego przedmiotu?" + ChatColor.YELLOW + " Zglos to do administracji!");
                                            isOpen = false;
                                            break;
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

    @EventHandler
    public void OnClick(InventoryClickEvent event) {
        if(!invs.contains(event.getInventory())) {
            return;
        }
        event.setCancelled(true);
        return;
    }
}
