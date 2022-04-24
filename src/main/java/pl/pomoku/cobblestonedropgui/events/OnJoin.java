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
            plugin.saveConfig();
        }
    }
}
