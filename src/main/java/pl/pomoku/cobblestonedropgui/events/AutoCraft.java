package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.bukkit.Material.*;

public class AutoCraft implements Listener {
    Main plugin;

    public AutoCraft(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnPlayerHaveItem_3(BlockBreakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        change(p, uuid);
    }
    public void change(Player p, UUID uuid){

        ItemStack diamond = new ItemStack(DIAMOND);
        ItemStack iron = new ItemStack(IRON_INGOT);
        ItemStack gold = new ItemStack(GOLD_INGOT);
        ItemStack emerald = new ItemStack(EMERALD);
        ItemStack redstone = new ItemStack(REDSTONE);
        ItemStack coal = new ItemStack(COAL);

        ItemStack auto_fosa = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        ItemMeta auto_fosa_meta = auto_fosa.getItemMeta();
        auto_fosa_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Auto Fosa");
        List<String> auto_fosa_lore = new ArrayList<>();
        auto_fosa_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory kopie");
        auto_fosa_lore.add(ChatColor.GRAY + "dziure do bedrocka po postawieniu.");
        auto_fosa_lore.add(" ");
        auto_fosa_lore.add(ChatColor.YELLOW + "Posatw, aby wykopac!");
        auto_fosa_meta.addEnchant(Enchantment.LUCK, 1, true);
        auto_fosa_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        auto_fosa_meta.setLore(auto_fosa_lore);
        auto_fosa.setItemMeta(auto_fosa_meta);

        ItemStack sand_farmer = new ItemStack(Material.LIME_GLAZED_TERRACOTTA);
        ItemMeta sand_farmer_meta = sand_farmer.getItemMeta();
        sand_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sand Farmer");
        List<String> sand_farmer_lore = new ArrayList<>();
        sand_farmer_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory tworzy");
        sand_farmer_lore.add(ChatColor.GRAY + "sciane piasku po postawieniu.");
        sand_farmer_lore.add(" ");
        sand_farmer_lore.add(ChatColor.YELLOW + "Posatw, aby stworzyc!");
        sand_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        sand_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sand_farmer_meta.setLore(sand_farmer_lore);
        sand_farmer.setItemMeta(sand_farmer_meta);

        ItemStack boy_farmer = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta boy_farmer_meta = boy_farmer.getItemMeta();
        boy_farmer_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boy Farmer");
        List<String> boy_farmer_lore = new ArrayList<>();
        boy_farmer_lore.add(ChatColor.GRAY + "Jest to przedmiot, ktory tworzy");
        boy_farmer_lore.add(ChatColor.GRAY + "sciane piasku po postawieniu.");
        boy_farmer_lore.add(" ");
        boy_farmer_lore.add(ChatColor.YELLOW + "Posatw, aby stworzyc!");
        boy_farmer_meta.addEnchant(Enchantment.LUCK, 1, true);
        boy_farmer_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boy_farmer_meta.setLore(boy_farmer_lore);
        boy_farmer.setItemMeta(boy_farmer_meta);

        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_diamond_block"), "true")){
            auto_craft_system(p, DIAMOND, DIAMOND_BLOCK, diamond);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_iron_block"), "true")){
            auto_craft_system(p, IRON_INGOT, IRON_BLOCK, iron);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_gold_block"), "true")){
            auto_craft_system(p, GOLD_INGOT, GOLD_BLOCK, gold);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_emerald_block"), "true")){
            auto_craft_system(p, EMERALD, EMERALD_BLOCK, emerald);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_redstone_block"), "true")){
            auto_craft_system(p, REDSTONE, REDSTONE_BLOCK, redstone);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_coal_block"), "true")){
            auto_craft_system(p, COAL, COAL_BLOCK, coal);
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_auto_fosa"), "true")){
            if(isPlayerHaveEnoughItems(p, 8, Material.EMERALD_BLOCK) && isPlayerHaveEnoughItems(p, 1, DIAMOND_BLOCK)){
                ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
                ItemStack diamondBlock = new ItemStack(Material.DIAMOND_BLOCK);
                emeraldBlock.setAmount(8);
                while(isPlayerHaveEnoughItems(p, 8, EMERALD_BLOCK) && isPlayerHaveEnoughItems(p, 1, DIAMOND_BLOCK)){
                    p.getInventory().removeItem(emeraldBlock);
                    p.getInventory().removeItem(diamondBlock);
                    if (!isInventoryFullByMeta(p, "Auto Fosa", 64)) {
                        p.getInventory().addItem(new ItemStack(auto_fosa));
                    }else {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(auto_fosa));
                    }
                }
            }
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_boy_farmer"), "true")){
            if(isPlayerHaveEnoughItems(p, 8, Material.OBSIDIAN) && isPlayerHaveEnoughItems(p, 1, EMERALD_BLOCK)){
                ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
                ItemStack obsidianBlock = new ItemStack(Material.OBSIDIAN);
                obsidianBlock.setAmount(8);
                while(isPlayerHaveEnoughItems(p, 8, OBSIDIAN) && isPlayerHaveEnoughItems(p, 1, EMERALD_BLOCK)){
                    p.getInventory().removeItem(emeraldBlock);
                    p.getInventory().removeItem(obsidianBlock);
                    if (!isInventoryFullByMeta(p, "Boy Farmer", 64)) {
                        p.getInventory().addItem(new ItemStack(boy_farmer));
                    }else {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(boy_farmer));
                    }
                }
            }
        }
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_sand_farmer"), "true")){
            if(isPlayerHaveEnoughItems(p, 8, Material.SAND) && isPlayerHaveEnoughItems(p, 1, EMERALD_BLOCK)){
                ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
                ItemStack sandBlock = new ItemStack(Material.SAND);
                sandBlock.setAmount(8);
                while(isPlayerHaveEnoughItems(p, 8, SAND) && isPlayerHaveEnoughItems(p, 1, EMERALD_BLOCK)){
                    p.getInventory().removeItem(emeraldBlock);
                    p.getInventory().removeItem(sandBlock);
                    if (!isInventoryFullByMeta(p, "Sand Farmer", 64)) {
                        p.getInventory().addItem(new ItemStack(sand_farmer));
                    }else {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(sand_farmer));
                    }
                }
            }
        }

    }

    private void auto_craft_system(Player p, Material item, Material block, ItemStack is) {
        if(isPlayerHaveEnoughItems(p, 9, item)){
            is.setAmount(9);
            while(isPlayerHaveEnoughItems(p, 9, item)){
                p.getInventory().removeItem(is);
                if (!isInventoryFull(p, block, 64)) {
                    p.getInventory().addItem(new ItemStack(block));
                }else {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), new ItemStack(block));
                }
            }
        }
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

    private static boolean isPlayerHaveEnoughItems(Player p, int Value, Material mat) {
        boolean isplayerhaveenoughitems;
        int i = 0;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getContents()) {
                if (is != null) {
                    if (is.getType() == mat) {
                        i = i + is.getAmount();
                    }
                }
            }
        }
        if(i >= Value) {
            isplayerhaveenoughitems = true;
        }else {
            isplayerhaveenoughitems = false;
        }
        return isplayerhaveenoughitems;
    }
}
