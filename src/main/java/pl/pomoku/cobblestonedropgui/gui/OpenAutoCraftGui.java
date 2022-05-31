package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OpenAutoCraftGui {
    static Main plugin;

    public OpenAutoCraftGui(Main m) {
        plugin = m;
    }

    public static void OpenAutoCraftGui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Auto Craftowanie");
        UUID uuid = p.getUniqueId();

        File file = new File("plugins/CobbleStoneDropGUI", "config.yml");
        FileConfiguration config = plugin.getConfig();

        String name_diamond_block = config.getString("GUI.AutoCraft.Open.Items.Diamond_block");
        String name_iron_block = config.getString("GUI.AutoCraft.Open.Items.Iron_block");
        String name_gold_block = config.getString("GUI.AutoCraft.Open.Items.Gold_block");
        String name_emerald_block = config.getString("GUI.AutoCraft.Open.Items.Emerald_block");
        String name_redstone_block = config.getString("GUI.AutoCraft.Open.Items.Redstone_block");
        String name_coal_block = config.getString("GUI.AutoCraft.Open.Items.Coal_block");
        String name_auto_fosa_block = config.getString("GUI.AutoCraft.Open.Items.Auto_fosa_block");
        String name_boy_farmer_block = config.getString("GUI.AutoCraft.Open.Items.Boy_farmer_block");
        String name_sand_farmer_block = config.getString("GUI.AutoCraft.Open.Items.Sand_farmer_block");

        List<String> lore_diamond_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Diamond_block_lore_on");
        List<String> lore_diamond_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Diamond_block_lore_off");

        List<String> lore_iron_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Iron_block_lore_on");
        List<String> lore_iron_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Iron_block_lore_off");

        List<String> lore_gold_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Gold_block_lore_on");
        List<String> lore_gold_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Gold_block_lore_off");

        List<String> lore_emerald_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Emerald_block_lore_on");
        List<String> lore_emerald_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Emerald_block_lore_off");

        List<String> lore_redstone_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Redstone_block_lore_on");
        List<String> lore_redstone_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Redstone_block_lore_off");

        List<String> lore_coal_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Coal_block_lore_on");
        List<String> lore_coal_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Coal_block_lore_off");

        List<String> lore_auto_fosa_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Auto_fosa_block_lore_on");
        List<String> lore_auto_fosa_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Auto_fosa_block_lore_off");

        List<String> lore_boy_farmer_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Boy_farmer_block_lore_on");
        List<String> lore_boy_farmer_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Boy_farmer_block_lore_off");

        List<String> lore_sand_farmer_block_on = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Sand_farmer_block_lore_on");
        List<String> lore_sand_farmer_block_off = config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Sand_farmer_block_lore_off");

        ItemStack[] items = new ItemStack[9];
        items[0] = new ItemStack(Material.DIAMOND_BLOCK);
        items[1] = new ItemStack(Material.IRON_BLOCK);
        items[2] = new ItemStack(Material.GOLD_BLOCK);
        items[3] = new ItemStack(Material.EMERALD_BLOCK);
        items[4] = new ItemStack(Material.REDSTONE_BLOCK);
        items[5] = new ItemStack(Material.COAL_BLOCK);
        items[6] = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        items[7] = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        items[8] = new ItemStack(Material.LIME_GLAZED_TERRACOTTA);

        ItemMeta item0_meta = items[0].getItemMeta();
        item0_meta.setDisplayName(Objects.requireNonNullElse(name_diamond_block, "&a&lBlok Diamentu").replace("&", "§"));
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_diamond_block"), "true")) {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Diamond_block_lore_on").isEmpty()) {
                    List<String> item0_lore = new ArrayList<>();
                    for (String s : lore_diamond_block_on) {
                        item0_lore.add(s.replace("&", "§"));
                    }
                    item0_meta.setLore(item0_lore);
                } else {
                    item0_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 diamentow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki diamentu!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item0_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 diamentow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki diamentu!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item0_meta.addEnchant(Enchantment.LUCK, 1, false);
            item0_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Diamond_block_lore_off").isEmpty()) {
                    List<String> item0_lore = new ArrayList<>();
                    for (String s : lore_diamond_block_off) {
                        item0_lore.add(s.replace("&", "§"));
                    }
                    item0_meta.setLore(item0_lore);
                } else {
                    item0_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 diamentow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki diamentu!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item0_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 diamentow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki diamentu!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[0].setItemMeta(item0_meta);

        ItemMeta item1_meta = items[1].getItemMeta();
        item1_meta.setDisplayName(Objects.requireNonNullElse(name_iron_block, "&a&lBlok Zelaza").replace("&", "§"));
        if (Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_iron_block"), "true")) {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Iron_block_lore_on").isEmpty()) {
                    List<String> item1_lore = new ArrayList<>();
                    for (String s : lore_iron_block_on) {
                        item1_lore.add(s.replace("&", "§"));
                    }
                    item1_meta.setLore(item1_lore);
                }else {
                    item1_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zelaza".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zelaza!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item1_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zelaza".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zelaza!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item1_meta.addEnchant(Enchantment.LUCK, 1, false);
            item1_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Iron_block_lore_off").isEmpty()) {
                    List<String> item1_lore = new ArrayList<>();
                    for (String s : lore_iron_block_off) {
                        item1_lore.add(s.replace("&", "§"));
                    }
                    item1_meta.setLore(item1_lore);
                }else {
                    item1_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zelaza".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zelaza!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item1_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zelaza".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zelaza!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[1].setItemMeta(item1_meta);

        ItemMeta item2_meta = items[2].getItemMeta();
        item2_meta.setDisplayName(Objects.requireNonNullElse(name_gold_block, "&a&lBlok Zlota").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_gold_block"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Gold_block_lore_on").isEmpty()) {
                    List<String> item2_lore = new ArrayList<>();
                    for (String s : lore_gold_block_on) {
                        item2_lore.add(s.replace("&", "§"));
                    }
                    item2_meta.setLore(item2_lore);
                } else {
                    //item0_meta.setLore(List.of("".replace("&", "§"),"".replace("&", "§"),"".replace("&", "§"),"".replace("&", "§"),"".replace("&", "§"),"".replace("&", "§")));
                    item2_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zlota".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zlota!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item2_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zlota".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zlota!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item2_meta.addEnchant(Enchantment.LUCK, 1, false);
            item2_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Gold_block_lore_off").isEmpty()) {
                    List<String> item2_lore = new ArrayList<>();
                    for (String s : lore_gold_block_off) {
                        item2_lore.add(s.replace("&", "§"));
                    }
                    item2_meta.setLore(item2_lore);
                } else {
                    item2_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zlota".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zlota!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item2_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 sztabek zlota".replace("&", "§"), "&7to przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki zlota!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[2].setItemMeta(item2_meta);

        ItemMeta item3_meta = items[3].getItemMeta();
        item3_meta.setDisplayName(Objects.requireNonNullElse(name_emerald_block, "&a&lBlok Szmaragdow").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_emerald_block"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Emerald_block_lore_on").isEmpty()) {
                    List<String> item3_lore = new ArrayList<>();
                    for (String s : lore_emerald_block_on) {
                        item3_lore.add(s.replace("&", "§"));
                    }
                    item3_meta.setLore(item3_lore);
                } else {
                    item3_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 szmaragdow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki szmaragdow!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item3_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 szmaragdow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki szmaragdow!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item3_meta.addEnchant(Enchantment.LUCK, 1, false);
            item3_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Emerald_block_lore_off").isEmpty()) {
                    List<String> item3_lore = new ArrayList<>();
                    for (String s : lore_emerald_block_off) {
                        item3_lore.add(s.replace("&", "§"));
                    }
                    item3_meta.setLore(item3_lore);
                } else {
                    item3_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 szmaragdow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki szmaragdow!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item3_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 szmaragdow to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki szmaragdow!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[3].setItemMeta(item3_meta);

        ItemMeta item4_meta = items[4].getItemMeta();
        item4_meta.setDisplayName(Objects.requireNonNullElse(name_redstone_block, "&a&lBlok Redstona").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_redstone_block"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Redstone_block_lore_on").isEmpty()) {
                    List<String> item4_lore = new ArrayList<>();
                    for (String s : lore_redstone_block_on) {
                        item4_lore.add(s.replace("&", "§"));
                    }
                    item4_meta.setLore(item4_lore);
                } else {
                    item4_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 redstone'a to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki redstone'a!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item4_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 redstone'a to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki redstone'a!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item4_meta.addEnchant(Enchantment.LUCK, 1, false);
            item4_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Redstone_block_lore_off").isEmpty()) {
                    List<String> item4_lore = new ArrayList<>();
                    for (String s : lore_redstone_block_off) {
                        item4_lore.add(s.replace("&", "§"));
                    }
                    item4_meta.setLore(item4_lore);
                } else {
                    item4_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 redstone'a to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki redstone'a!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item4_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 redstone'a to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki redstone'a!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[4].setItemMeta(item4_meta);

        ItemMeta item5_meta = items[5].getItemMeta();
        item5_meta.setDisplayName(Objects.requireNonNullElse(name_coal_block, "&a&lBlok Wegla").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_coal_block"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Coal_block_lore_on").isEmpty()) {
                    List<String> item5_lore = new ArrayList<>();
                    for (String s : lore_coal_block_on) {
                        item5_lore.add(s.replace("&", "§"));
                    }
                    item5_meta.setLore(item5_lore);
                } else {
                    item5_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 wegla to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki wegla!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item5_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 wegla to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki wegla!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item5_meta.addEnchant(Enchantment.LUCK, 1, false);
            item5_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Coal_block_lore_off").isEmpty()) {
                    List<String> item5_lore = new ArrayList<>();
                    for (String s : lore_coal_block_off) {
                        item5_lore.add(s.replace("&", "§"));
                    }
                    item5_meta.setLore(item5_lore);
                } else {
                    item5_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 wegla to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki wegla!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item5_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 9 wegla to".replace("&", "§"), "&7przy kopaniu bedzie je".replace("&", "§"), "&7zamieniac na bloki wegla!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[5].setItemMeta(item5_meta);

        ItemMeta item6_meta = items[6].getItemMeta();
        item6_meta.setDisplayName(Objects.requireNonNullElse(name_auto_fosa_block, "&a&lAuto Fosa").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_auto_fosa"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Auto_fosa_block_lore_on").isEmpty()) {
                    List<String> item6_lore = new ArrayList<>();
                    for (String s : lore_auto_fosa_block_on) {
                        item6_lore.add(s.replace("&", "§"));
                    }
                    item6_meta.setLore(item6_lore);
                } else {
                    item6_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow szmaragdow".replace("&", "§"), "&7+ 1 blok diamentow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na auto fose!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item6_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow szmaragdow".replace("&", "§"), "&7+ 1 blok diamentow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na auto fose!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item6_meta.addEnchant(Enchantment.LUCK, 1, false);
            item6_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Auto_fosa_block_lore_off").isEmpty()) {
                    List<String> item6_lore = new ArrayList<>();
                    for (String s : lore_auto_fosa_block_off) {
                        item6_lore.add(s.replace("&", "§"));
                    }
                    item6_meta.setLore(item6_lore);
                } else {
                    item6_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow szmaragdow".replace("&", "§"), "&7+ 1 blok diamentow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na auto fose!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item6_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow szmaragdow".replace("&", "§"), "&7+ 1 blok diamentow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na auto fose!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[6].setItemMeta(item6_meta);

        ItemMeta item7_meta = items[7].getItemMeta();
        item7_meta.setDisplayName(Objects.requireNonNullElse(name_boy_farmer_block, "&a&lBoy Farmer").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_boy_farmer"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Boy_farmer_block_lore_on").isEmpty()) {
                    List<String> item7_lore = new ArrayList<>();
                    for (String s : lore_boy_farmer_block_on) {
                        item7_lore.add(s.replace("&", "§"));
                    }
                    item7_meta.setLore(item7_lore);
                } else {
                    item7_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow obsydianu".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na boy farmera!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item7_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow obsydianu".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na boy farmera!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item7_meta.addEnchant(Enchantment.LUCK, 1, false);
            item7_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Boy_farmer_block_lore_off").isEmpty()) {
                    List<String> item7_lore = new ArrayList<>();
                    for (String s : lore_boy_farmer_block_off) {
                        item7_lore.add(s.replace("&", "§"));
                    }
                    item7_meta.setLore(item7_lore);
                } else {
                    item7_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow obsydianu".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na boy farmera!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item7_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow obsydianu".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na boy farmera!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[7].setItemMeta(item7_meta);

        ItemMeta item8_meta = items[8].getItemMeta();
        item8_meta.setDisplayName(Objects.requireNonNullElse(name_sand_farmer_block, "&a&lSand Farmer").replace("&", "§"));
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".auto_craft_sand_farmer"), "true")){
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wlacz.Sand_farmer_block_lore_on").isEmpty()) {
                    List<String> item8_lore = new ArrayList<>();
                    for (String s : lore_sand_farmer_block_on) {
                        item8_lore.add(s.replace("&", "§"));
                    }
                    item8_meta.setLore(item8_lore);
                } else {
                    item8_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow piasku".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na sand farmera!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item8_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow piasku".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na sand farmera!".replace("&", "§"), " ", "&7Craftowanie: &a&lWLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
            item8_meta.addEnchant(Enchantment.LUCK, 1, false);
            item8_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            if(file.exists()) {
                if (!config.getStringList("GUI.AutoCraft.Open.Items.Opis.Wylacz.Sand_farmer_block_lore_off").isEmpty()) {
                    List<String> item8_lore = new ArrayList<>();
                    for (String s : lore_sand_farmer_block_off) {
                        item8_lore.add(s.replace("&", "§"));
                    }
                    item8_meta.setLore(item8_lore);
                } else {
                    item8_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow piasku".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na sand farmera!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
                }
            }else {
                item8_meta.setLore(List.of("&7Jesli masz w ekwipunku co".replace("&", "§"), "&7najmniej 8 blokow piasku".replace("&", "§"), "&7+ 1 blok szmaragdow to przy kopaniu".replace("&", "§"), "&7bedzie je zamieniac na sand farmera!".replace("&", "§"), " ", "&7Craftowanie: &c&lWYLACZONE".replace("&", "§"), "&eKliknij, aby przelaczyc!".replace("&", "§")));
            }
        }
        items[8].setItemMeta(item8_meta);

        for(int i = 0; i < 9; i++) {
            inv.setItem(i, items[i]);
        }

        p.openInventory(inv);
    }
}
