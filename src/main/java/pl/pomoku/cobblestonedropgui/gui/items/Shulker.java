package pl.pomoku.cobblestonedropgui.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.UUID;

public class Shulker {
    static Main plugin;
    public Shulker(Main m) {
        plugin = m;
    }

    public static ItemStack shulker(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack ultra_block = new ItemStack(Material.YELLOW_SHULKER_BOX);
        ItemMeta ultra_block_meta = ultra_block.getItemMeta();

        ultra_block_meta.setDisplayName("§aUltra Blok");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add("§7Szansa na drop: §b0.01%");
        lore.add("§7Rangi Premium: §d+0.005%");
        lore.add(" ");
        if(plugin.getConfig().getString(uuid + ".ultra_block") == "true") {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.GREEN + ChatColor.BOLD + "WLACZONE");
        }else {
            lore.add(ChatColor.GRAY + "Wypadanie: " + ChatColor.RED + ChatColor.BOLD + "WYLACZONE");
        }
        lore.add(ChatColor.YELLOW + "Kliknij, aby przelaczyc!");

        ultra_block_meta.setLore(lore);
        ultra_block.setItemMeta(ultra_block_meta);

        return ultra_block;
    }
}
