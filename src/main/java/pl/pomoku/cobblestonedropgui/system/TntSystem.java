package pl.pomoku.cobblestonedropgui.system;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class TntSystem implements Listener {
    List<FallingBlock> throwedtnt = new ArrayList<>();
    @EventHandler
    public void OnInteract(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null && e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Rzucane TNT")) {
                FallingBlock tnt = e.getPlayer().getWorld().spawnFallingBlock(e.getPlayer().getEyeLocation(), Material.TNT, (byte) 0);
                tnt.setDropItem(false);
                throwedtnt.add(tnt);
                tnt.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1));
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onFall(EntityChangeBlockEvent e) {
        if(e.getEntity() instanceof FallingBlock) {
            if(throwedtnt.contains(e.getEntity())) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 5, false, true);
                e.setCancelled(true);
                e.getEntity().remove();
                throwedtnt.remove(e.getEntity());
            }
        }
    }
}
