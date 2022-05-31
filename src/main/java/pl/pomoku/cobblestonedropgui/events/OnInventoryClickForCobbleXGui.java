package pl.pomoku.cobblestonedropgui.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.gui.OpenDropGui;
import pl.pomoku.cobblestonedropgui.items.Items;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OnInventoryClickForCobbleXGui implements Listener {
    Main plugin;
    private final HashMap<UUID, Long> cooldowns;

    public OnInventoryClickForCobbleXGui(Main m) {
        plugin = m;
        this.cooldowns = new HashMap<>();
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        FileConfiguration config = plugin.getConfig();

        List<String> mes_za_malo_itemow = config.getStringList("Tworzenie_cobble_x_w_gui.Za_malo_itemow_do_stworzenia");
        List<String> mes_stworzyles_cobble_x = config.getStringList("Tworzenie_cobble_x_w_gui.Stowrzyles_cobble_x");

        if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Drop z Cobble X")) return;
        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            p.closeInventory();
            return;
        }

        switch(e.getCurrentItem().getType()) {
            case CRAFTING_TABLE -> {
                if(isPlayerHaveNineStacks(p)){
                    if (!config.getStringList("Tworzenie_cobble_x_w_gui.Stowrzyles_cobble_x").isEmpty()) {
                        for (String mesStworzylesCobbleX : mes_stworzyles_cobble_x) {
                            p.sendMessage(mesStworzylesCobbleX.replace("&", "§"));
                        }
                    }else{
                        p.sendMessage("&aStworzyles cobble x!".replace("&", "§"));
                    }

                    ItemStack cob = new ItemStack(Material.COBBLESTONE);
                    cob.setAmount(576);
                    p.getInventory().removeItem(cob);
                    p.getInventory().addItem(Items.cobblex());
                }else {
                    if(!this.cooldowns.containsKey(p.getUniqueId())) {
                        this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                        if (!config.getStringList("Tworzenie_cobble_x_w_gui.Za_malo_itemow_do_stworzenia").isEmpty()) {
                            for (String s : mes_za_malo_itemow) {
                                p.sendMessage(s.replace("&", "§"));
                            }
                        }else{
                            p.sendMessage("&cMasz za malo itemow do stworzenia cobble x!".replace("&", "§"));
                        }
                    }else {
                        long timeElapsed = System.currentTimeMillis() - cooldowns.get(p.getUniqueId());
                        if(timeElapsed >= 10000) {
                            this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                            if (!config.getStringList("Tworzenie_cobble_x_w_gui.Za_malo_itemow_do_stworzenia").isEmpty()) {
                                for (String s : mes_za_malo_itemow) {
                                    p.sendMessage(s.replace("&", "§"));
                                }
                            }else{
                                p.sendMessage("&cMasz za malo itemow do stworzenia cobble x!".replace("&", "§"));
                            }
                        }
                    }
                }
            }
            case BARRIER -> OpenDropGui.OpenGui(p);
            default -> p.updateInventory();
        }

    }
    private boolean isPlayerHaveNineStacks(Player p) {
        boolean isplayerhaveninestacks;
        int i = 0;
        p.getInventory().getContents();
        for (ItemStack is : p.getInventory().getContents()) {
            if (is != null) {
                if (is.getType() == Material.COBBLESTONE) {
                    i = i + is.getAmount();
                }
            }
        }
        isplayerhaveninestacks = i >= 576;
        return isplayerhaveninestacks;
    }
}
