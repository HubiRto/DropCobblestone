package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.UUID;

public class OnJoin implements Listener {

    Main plugin;

    public OnJoin(Main m) {
        plugin = m;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(!p.hasPlayedBefore()) {
            UUID uuid = p.getUniqueId();

            plugin.getConfig().set(uuid + ".eq", true);
            plugin.getConfig().set(uuid + ".cobblestone", true);
            plugin.getConfig().set(uuid + ".iron", true);
            plugin.getConfig().set(uuid + ".gold", true);
            plugin.getConfig().set(uuid + ".obsidian", true);
            plugin.getConfig().set(uuid + ".emerald", true);
            plugin.getConfig().set(uuid + ".diamond", true);
            plugin.getConfig().set(uuid + ".apple", true);
            plugin.getConfig().set(uuid + ".enderpearl", true);
            plugin.getConfig().set(uuid + ".arrow", true);
            plugin.getConfig().set(uuid + ".oaklog", true);
            plugin.getConfig().set(uuid + ".redstone", true);
            plugin.getConfig().set(uuid + ".slimeball", true);
            plugin.getConfig().set(uuid + ".tnt", true);
            plugin.getConfig().set(uuid + ".coal", true);
            plugin.getConfig().set(uuid + ".bookshelf", true);
            plugin.getConfig().set(uuid + ".netherite", true);
            plugin.getConfig().set(uuid + ".throwtnt", true);
            plugin.getConfig().set(uuid + ".ultra_block", true);
            plugin.saveConfig();
        }
    }
}
