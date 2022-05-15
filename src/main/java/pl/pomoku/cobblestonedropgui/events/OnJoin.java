package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.pomoku.cobblestonedropgui.files.PlayerDropConfig;
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

            PlayerDropConfig.get().set(uuid + ".eq", "true");
            PlayerDropConfig.get().set(uuid + ".cobblestone", "true");
            PlayerDropConfig.get().set(uuid + ".iron", "true");
            PlayerDropConfig.get().set(uuid + ".gold", "true");
            PlayerDropConfig.get().set(uuid + ".obsidian", "true");
            PlayerDropConfig.get().set(uuid + ".emerald", "true");
            PlayerDropConfig.get().set(uuid + ".diamond", "true");
            PlayerDropConfig.get().set(uuid + ".apple", "true");
            PlayerDropConfig.get().set(uuid + ".enderpearl", "true");
            PlayerDropConfig.get().set(uuid + ".arrow", "true");
            PlayerDropConfig.get().set(uuid + ".oaklog", "true");
            PlayerDropConfig.get().set(uuid + ".redstone", "true");
            PlayerDropConfig.get().set(uuid + ".slimeball", "true");
            PlayerDropConfig.get().set(uuid + ".tnt", "true");
            PlayerDropConfig.get().set(uuid + ".coal", "true");
            PlayerDropConfig.get().set(uuid + ".bookshelf", "true");
            PlayerDropConfig.get().set(uuid + ".netherite", "true");
            PlayerDropConfig.get().set(uuid + ".throwtnt", "true");
            PlayerDropConfig.get().set(uuid + ".ultra_block", "true");
            PlayerDropConfig.save();
        }
    }
}
