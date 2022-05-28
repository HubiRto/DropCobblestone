package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Material.*;

public class OnPlaceCustomBlock_A_B_S implements Listener {

    Main plugin;
    private final HashMap<UUID, Long> cooldowns;

    public OnPlaceCustomBlock_A_B_S(Main m) {
        plugin = m;
        this.cooldowns = new HashMap<>();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Block ba = b.getRelative(BlockFace.DOWN, 1);

        FileConfiguration config = plugin.getConfig();
        List<String> mes_nie_mozna_postawic_tego_bloku_na_bedroocku = config.getStringList("Eventy.Postawienie_Blokow_A_B_S.Nie_mozna_postawic_tego_bloku_na_bedroocku");


        if(b.getType() == RED_GLAZED_TERRACOTTA) {
            funkcja_dzialania(e, p, b, ba, mes_nie_mozna_postawic_tego_bloku_na_bedroocku, "Auto Fosa", AIR);
        }
        else if(b.getType() == LIME_GLAZED_TERRACOTTA) {
            funkcja_dzialania(e, p, b, ba, mes_nie_mozna_postawic_tego_bloku_na_bedroocku, "Sand Farmer", SAND);
        }
        else if(b.getType() == PURPLE_GLAZED_TERRACOTTA) {
            funkcja_dzialania(e, p, b, ba, mes_nie_mozna_postawic_tego_bloku_na_bedroocku, "Boy Farmer", OBSIDIAN);
        }
    }

    private void funkcja_dzialania(BlockPlaceEvent e, Player p, Block b, Block ba, List<String> mes_nie_mozna_postawic_tego_bloku_na_bedroocku, String s, Material m) {
        FileConfiguration config = plugin.getConfig();
        if(ba.getType() != BEDROCK) {
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(s)) {
                for (int i = b.getY(); i > -64; i--) {
                    Location loc = new Location(p.getLocation().getWorld(), b.getX(), i, b.getZ());
                    if (loc.getBlock().getType().equals(Material.BEDROCK)) {
                        i = -64;
                    } else {
                        loc.getBlock().setType(m);
                    }
                }
            }
        }else {
            e.setCancelled(true);
            if (!this.cooldowns.containsKey(p.getUniqueId())) {
                alert_cooldown(p, mes_nie_mozna_postawic_tego_bloku_na_bedroocku, config);
            } else {
                long timeElapsed = System.currentTimeMillis() - cooldowns.get(p.getUniqueId());
                if (timeElapsed >= 10000) {
                    alert_cooldown(p, mes_nie_mozna_postawic_tego_bloku_na_bedroocku, config);
                }
            }
        }
    }

    private void alert_cooldown(Player p, List<String> mes_nie_mozna_postawic_tego_bloku_na_bedroocku, FileConfiguration config) {
        this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
        if(!config.getStringList("Komendy.Dodaj.Nie_mozna_wykonac_komendy_z_konsoli").isEmpty()) {
            for (String value : mes_nie_mozna_postawic_tego_bloku_na_bedroocku) {
                p.sendMessage(value.replace("&", "§"));
            }
        }else if(!config.getStringList("Komendy.Dodaj.Nie_mozna_wykonac_komendy_z_konsoli").contains(null)){
            for (String value : mes_nie_mozna_postawic_tego_bloku_na_bedroocku) {
                p.sendMessage(value.replace("&", "§"));
            }
        }else {
            p.sendMessage(" ");
            p.sendMessage("&8[&c+&8]&m------------&r&8[ &cALERT &8]&m------------&r&8[&c+&8]".replace("&", "§"));
            p.sendMessage(" ");
            p.sendMessage("&cNie mozesz tego postawic na bedrock'u!".replace("&", "§"));
            p.sendMessage(" ");
            p.sendMessage("&8[&c+&8]&m------------&r&8[ &cALERT &8]&m------------&r&8[&c+&8]".replace("&", "§"));
            p.sendMessage(" ");
        }
    }
}
