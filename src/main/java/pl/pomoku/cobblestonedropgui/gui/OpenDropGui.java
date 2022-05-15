package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class OpenDropGui {

    static Main plugin;
    public OpenDropGui(Main m) {
        plugin = m;
    }

    public static void OpenGui(Player p) {
        Inventory i = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Drop z kamienia");
        UUID uuid = p.getUniqueId();

        //HOPPER

        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta hopper_meta = hopper.getItemMeta();

        hopper_meta.setDisplayName(ChatColor.GREEN + "Drop, gdy EQ pelne");
        ArrayList<String> hopper_lore = new ArrayList<>();

        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".eq"), "true")) {
            hopper_lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.RED + "Nie");
        }else {
            hopper_lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.GREEN + "Tak");
        }
        hopper_lore.add(" ");
        hopper_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        hopper_meta.setLore(hopper_lore);
        hopper.setItemMeta(hopper_meta);

        //COBBLESTONE

        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
        ItemMeta cobblestone_meta = cobblestone.getItemMeta();

        cobblestone_meta.setDisplayName(ChatColor.GREEN + "Wypadanie bruku");
        ArrayList<String> cobblestone_lore = new ArrayList<>();

        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".cobblestone"), "true")) {
            cobblestone_lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.GREEN + "Tak");
            cobblestone_meta.addEnchant(Enchantment.LUCK, 1, false);
            cobblestone_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            cobblestone_lore.add(ChatColor.GRAY + "Aktualnie aktywny: " + ChatColor.RED + "Nie");
        }
        cobblestone_lore.add(" ");
        cobblestone_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        cobblestone_meta.setLore(cobblestone_lore);
        cobblestone.setItemMeta(cobblestone_meta);

        //LIME_STAINED_GLASS_PANE

        ItemStack limestainedglasspane = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta limestainedglasspane_meta = limestainedglasspane.getItemMeta();

        limestainedglasspane_meta.setDisplayName(ChatColor.GREEN + "Wlacz wszystkie dropy");
        ArrayList<String> limestainedglasspane_lore = new ArrayList<>();

        limestainedglasspane_lore.add(ChatColor.GRAY + "Po kliknieciu kazdy przedmiot z");
        limestainedglasspane_lore.add(ChatColor.GRAY + "dropu bedzie wypadac po wykopaniu.");
        limestainedglasspane_lore.add(" ");
        limestainedglasspane_lore.add(ChatColor.YELLOW + "Kliknij, aby wlaczyc!");

        limestainedglasspane_meta.setLore(limestainedglasspane_lore);
        limestainedglasspane.setItemMeta(limestainedglasspane_meta);

        //RED_STAINED_GLASS_PANE

        ItemStack redstainedglasspane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta redstainedglasspane_meta = redstainedglasspane.getItemMeta();

        redstainedglasspane_meta.setDisplayName(ChatColor.RED + "Wylacz wszystkie dropy");
        ArrayList<String> redstainedglasspane_lore = new ArrayList<>();

        redstainedglasspane_lore.add(ChatColor.GRAY + "Po kliknieciu zaden przedmiot z");
        redstainedglasspane_lore.add(ChatColor.GRAY + "dropu nie bedzie wypadac po wykopaniu.");
        redstainedglasspane_lore.add(" ");
        redstainedglasspane_lore.add(ChatColor.YELLOW + "Kliknij, aby wylaczyc!");

        redstainedglasspane_meta.setLore(redstainedglasspane_lore);
        redstainedglasspane.setItemMeta(redstainedglasspane_meta);

        //SHULKERBOX

        ItemStack shulker = new ItemStack(Material.YELLOW_SHULKER_BOX);
        ItemMeta shulker_meta = shulker.getItemMeta();

        shulker_meta.setDisplayName("§aUltra Blok");
        ArrayList<String> shulker_lore = new ArrayList<>();

        shulker_lore.add("§7Szansa na drop: §b0.01%");
        shulker_lore.add("§7Rangi Premium: §d+0.005%");
        shulker_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".ultra_block"), "true")) {
            shulker_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            shulker_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        shulker_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        shulker_meta.setLore(shulker_lore);
        shulker.setItemMeta(shulker_meta);

        //THROW_TNT

        ItemStack throwtnt = new ItemStack(Material.TNT);
        ItemMeta throwtnt_meta = throwtnt.getItemMeta();

        throwtnt_meta.setDisplayName(ChatColor.DARK_GRAY + "Rzucane TNT");
        ArrayList<String> throwtnt_lore = new ArrayList<>();

        throwtnt_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.2%");
        throwtnt_lore.add(ChatColor.GRAY + "Rangi Premium: " + ChatColor.LIGHT_PURPLE + "+0.005%");
        throwtnt_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".throwtnt"), "true")) {
            throwtnt_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            throwtnt_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        throwtnt_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        throwtnt_meta.setLore(throwtnt_lore);
        throwtnt.setItemMeta(throwtnt_meta);

        //CHEST

        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chest_meta = chest.getItemMeta();

        chest_meta.setDisplayName(ChatColor.GREEN + "Drop z Ultra Block");
        ArrayList<String> chest_lore = new ArrayList<>();

        chest_lore.add(ChatColor.GRAY + "Lista przedmiotow, ktore dropia");
        chest_lore.add(ChatColor.GRAY + "z legendarnej skrzyni Ultra Block.");
        chest_lore.add(" ");
        chest_lore.add(ChatColor.YELLOW + "Kliknij, aby zobaczyc!");

        chest_meta.setLore(chest_lore);
        chest.setItemMeta(chest_meta);

        //ENDER_CHEST

        ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
        ItemMeta enderchest_meta = enderchest.getItemMeta();

        enderchest_meta.setDisplayName(ChatColor.GREEN + "Drop z Cobble X");
        ArrayList<String> enderchest_lore = new ArrayList<>();

        enderchest_lore.add(ChatColor.GRAY + "Lista przedmiotow, ktore dropia");
        enderchest_lore.add(ChatColor.GRAY + "z rzadkiego przedmiotu Cobble X.");
        enderchest_lore.add(" ");
        enderchest_lore.add(ChatColor.YELLOW + "Kliknij, aby zobaczyc!");

        enderchest_meta.setLore(enderchest_lore);
        enderchest.setItemMeta(enderchest_meta);

        //BLACK_STAINED_GLASS_PANE

        ItemStack blackstainedglasspane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackstainedglasspane_meta = blackstainedglasspane.getItemMeta();

        blackstainedglasspane_meta.setDisplayName(" ");

        blackstainedglasspane.setItemMeta(blackstainedglasspane_meta);

        //DIAMOND

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamond_meta = diamond.getItemMeta();

        diamond_meta.setDisplayName(ChatColor.DARK_GRAY + "Diament");
        ArrayList<String> diamond_lore = new ArrayList<>();

        diamond_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "13.0%");
        diamond_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-3" + ChatColor.GRAY + " szt.");
        diamond_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".diamond"), "true")) {
            diamond_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            diamond_meta.addEnchant(Enchantment.LUCK, 1, false);
            diamond_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            diamond_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        diamond_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);

        //EMERALD

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emerald_meta = emerald.getItemMeta();

        emerald_meta.setDisplayName(ChatColor.DARK_GRAY + "Szmaragd");
        ArrayList<String> emerald_lore = new ArrayList<>();

        emerald_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "11.0%");
        emerald_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        emerald_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".emerald"), "true")) {
            emerald_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            emerald_meta.addEnchant(Enchantment.LUCK, 1, false);
            emerald_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            emerald_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        emerald_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);

        //IRON

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta iron_meta = iron.getItemMeta();

        iron_meta.setDisplayName(ChatColor.DARK_GRAY + "Zelazo");
        ArrayList<String> iron_lore = new ArrayList<>();

        iron_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "18.0%");
        iron_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-4" + ChatColor.GRAY + " szt.");
        iron_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".iron"), "true")) {
            iron_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            iron_meta.addEnchant(Enchantment.LUCK, 1, false);
            iron_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            iron_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        iron_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);

        //GOLD

        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta gold_meta = gold.getItemMeta();

        gold_meta.setDisplayName(ChatColor.DARK_GRAY + "Zelazo");
        ArrayList<String> gold_lore = new ArrayList<>();

        gold_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "10.0%");
        gold_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-3" + ChatColor.GRAY + " szt.");
        gold_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".gold"), "true")) {
            gold_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            gold_meta.addEnchant(Enchantment.LUCK, 1, false);
            gold_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            gold_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        gold_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);

        //OBSIDIAN

        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ItemMeta obsidian_meta = obsidian.getItemMeta();

        obsidian_meta.setDisplayName(ChatColor.DARK_GRAY + "Obsydian");
        ArrayList<String> obsidian_lore = new ArrayList<>();

        obsidian_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "9.0%");
        obsidian_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        obsidian_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".obsidian"), "true")) {
            obsidian_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            obsidian_meta.addEnchant(Enchantment.LUCK, 1, false);
            obsidian_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            obsidian_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        obsidian_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        obsidian_meta.setLore(obsidian_lore);
        obsidian.setItemMeta(obsidian_meta);

        //REDSTONE

        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemMeta redstone_meta = redstone.getItemMeta();

        redstone_meta.setDisplayName(ChatColor.DARK_GRAY + "Redstone");
        ArrayList<String> redstone_lore = new ArrayList<>();

        redstone_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "11.0%");
        redstone_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-5" + ChatColor.GRAY + " szt.");
        redstone_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".redstone"), "true")) {
            redstone_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            redstone_meta.addEnchant(Enchantment.LUCK, 1, false);
            redstone_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            redstone_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        redstone_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        redstone_meta.setLore(redstone_lore);
        redstone.setItemMeta(redstone_meta);

        //NETHERITE

        ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta netherite_meta = netherite.getItemMeta();

        netherite_meta.setDisplayName(ChatColor.DARK_GRAY + "netherite");
        ArrayList<String> netherite_lore = new ArrayList<>();

        netherite_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.1%");
        netherite_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        netherite_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".netherite"), "true")) {
            netherite_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            netherite_meta.addEnchant(Enchantment.LUCK, 1, false);
            netherite_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            netherite_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        netherite_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        netherite_meta.setLore(netherite_lore);
        netherite.setItemMeta(netherite_meta);

        //SLIMEBALL

        ItemStack slimeball = new ItemStack(Material.SLIME_BALL);
        ItemMeta slimeball_meta = slimeball.getItemMeta();

        slimeball_meta.setDisplayName(ChatColor.DARK_GRAY + "Slime");
        ArrayList<String> slimeball_lore = new ArrayList<>();

        slimeball_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "10.0%");
        slimeball_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-4" + ChatColor.GRAY + " szt.");
        slimeball_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".slimeball"), "true")) {
            slimeball_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            slimeball_meta.addEnchant(Enchantment.LUCK, 1, false);
            slimeball_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            slimeball_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        slimeball_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        slimeball_meta.setLore(slimeball_lore);
        slimeball.setItemMeta(slimeball_meta);

        //BOOKSHELF

        ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
        ItemMeta bookshelf_meta = bookshelf.getItemMeta();

        bookshelf_meta.setDisplayName(ChatColor.DARK_GRAY + "Biblioteczka");
        ArrayList<String> bookshelf_lore = new ArrayList<>();

        bookshelf_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "4.0%");
        bookshelf_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        bookshelf_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".bookshelf"), "true")) {
            bookshelf_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            bookshelf_meta.addEnchant(Enchantment.LUCK, 1, false);
            bookshelf_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            bookshelf_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        bookshelf_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        bookshelf_meta.setLore(bookshelf_lore);
        bookshelf.setItemMeta(bookshelf_meta);

        //ENDER_PEARL

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enderpearl_meta = enderpearl.getItemMeta();

        enderpearl_meta.setDisplayName(ChatColor.DARK_GRAY + "Perla");
        ArrayList<String> enderpearl_lore = new ArrayList<>();

        enderpearl_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.2%");
        enderpearl_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-2" + ChatColor.GRAY + " szt.");
        enderpearl_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".enderpearl"), "true")) {
            enderpearl_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            enderpearl_meta.addEnchant(Enchantment.LUCK, 1, false);
            enderpearl_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            enderpearl_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        enderpearl_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        enderpearl_meta.setLore(enderpearl_lore);
        enderpearl.setItemMeta(enderpearl_meta);

        //NORMAL_TNT

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tnt_meta = tnt.getItemMeta();

        tnt_meta.setDisplayName(ChatColor.RED + "T" + ChatColor.WHITE + "N" + ChatColor.RED + "T");
        ArrayList<String> tnt_lore = new ArrayList<>();

        tnt_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.3%");
        tnt_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-3" + ChatColor.GRAY + " szt.");
        tnt_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".tnt"), "true")) {
            tnt_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            tnt_meta.addEnchant(Enchantment.LUCK, 1, false);
            tnt_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            tnt_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        tnt_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        tnt_meta.setLore(tnt_lore);
        tnt.setItemMeta(tnt_meta);

        //APPLE

        ItemStack apple = new ItemStack(Material.APPLE);
        ItemMeta apple_meta = apple.getItemMeta();

        apple_meta.setDisplayName(ChatColor.DARK_GRAY + "Jablko");
        ArrayList<String> apple_lore = new ArrayList<>();

        apple_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "8.0%");
        apple_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "2-3" + ChatColor.GRAY + " szt.");
        apple_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".apple"), "true")) {
            apple_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            apple_meta.addEnchant(Enchantment.LUCK, 1, false);
            apple_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            apple_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        apple_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        apple_meta.setLore(apple_lore);
        apple.setItemMeta(apple_meta);

        //COAL

        ItemStack coal = new ItemStack(Material.COAL);
        ItemMeta coal_meta = coal.getItemMeta();

        coal_meta.setDisplayName(ChatColor.DARK_GRAY + "Wegiel");
        ArrayList<String> coal_lore = new ArrayList<>();

        coal_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "14.0%");
        coal_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "3-5" + ChatColor.GRAY + " szt.");
        coal_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".coal"), "true")) {
            coal_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            coal_meta.addEnchant(Enchantment.LUCK, 1, false);
            coal_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            coal_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        coal_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);

        //OAKLOG

        ItemStack oaklog = new ItemStack(Material.OAK_LOG);
        ItemMeta oaklog_meta = oaklog.getItemMeta();

        oaklog_meta.setDisplayName(ChatColor.GREEN + "Drewno");
        ArrayList<String> oaklog_lore = new ArrayList<>();

        oaklog_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "4.0%");
        oaklog_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "4-8" + ChatColor.GRAY + " szt.");
        oaklog_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".oaklog"), "true")) {
            oaklog_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            oaklog_meta.addEnchant(Enchantment.LUCK, 1, false);
            oaklog_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            oaklog_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        oaklog_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        oaklog_meta.setLore(oaklog_lore);
        oaklog.setItemMeta(oaklog_meta);

        //ARROW

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta arrow_meta = arrow.getItemMeta();

        arrow_meta.setDisplayName(ChatColor.DARK_GRAY + "Strzala");
        ArrayList<String> arrow_lore = new ArrayList<>();

        arrow_lore.add(ChatColor.GRAY + "Szansa na drop: " + ChatColor.AQUA + "0.7%");
        arrow_lore.add(ChatColor.GRAY + "Ilosc itemow: " + ChatColor.LIGHT_PURPLE + "1-4" + ChatColor.GRAY + " szt.");
        arrow_lore.add(" ");
        if(Objects.equals(PlayerDropConfig.get().getString(uuid + ".arrow"), "true")) {
            arrow_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
            arrow_meta.addEnchant(Enchantment.LUCK, 1, false);
            arrow_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else {
            arrow_lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        arrow_lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        arrow_meta.setLore(arrow_lore);
        arrow.setItemMeta(arrow_meta);

        //BARRIER

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta barrier_meta = barrier.getItemMeta();
        barrier_meta.setDisplayName(ChatColor.RED + "WYJSCIE");
        barrier.setItemMeta(barrier_meta);


        i.setItem(20, diamond);
        i.setItem(21, emerald);
        i.setItem(22, iron);
        i.setItem(23, gold);
        i.setItem(24, obsidian);

        i.setItem(27, chest);
        i.setItem(29, redstone);
        i.setItem(30, netherite);
        i.setItem(31, slimeball);
        i.setItem(32, bookshelf);
        i.setItem(33, enderpearl);
        i.setItem(35, enderchest);

        i.setItem(38, tnt);
        i.setItem(39, apple);
        i.setItem(40, coal);
        i.setItem(41, oaklog);
        i.setItem(42, arrow);

        i.setItem(0, hopper);
        i.setItem(7, shulker);
        i.setItem(1, cobblestone);

        i.setItem(3, limestainedglasspane);

        i.setItem(5, redstainedglasspane);
        i.setItem(8, throwtnt);

        i.setItem(2, blackstainedglasspane);
        i.setItem(6, blackstainedglasspane);

        for(int a = 9; a < 20; a++) {
            i.setItem(a, blackstainedglasspane);
        }

        i.setItem(25, blackstainedglasspane);
        i.setItem(26, blackstainedglasspane);

        i.setItem(28, blackstainedglasspane);
        i.setItem(34, blackstainedglasspane);

        i.setItem(36, blackstainedglasspane);
        i.setItem(37, blackstainedglasspane);

        i.setItem(43, blackstainedglasspane);
        i.setItem(44, blackstainedglasspane);

        i.setItem(45, barrier);

        for(int b = 46; b < 54; b++) {
            i.setItem(b, blackstainedglasspane);
        }

        p.openInventory(i);
    }
}
