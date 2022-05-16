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
                    ItemStack cobble_x = new ItemStack(Material.TRAPPED_CHEST);
                    ItemMeta cobble_x_meta = cobble_x.getItemMeta();
                    cobble_x_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cobble X");
                    List<String> cobble_x_lore = new ArrayList<>();
                    cobble_x_lore.add("§7Jest to skrzynia z ktorej");
                    cobble_x_lore.add("§7wypadaja bardzo cenne itemki.");
                    cobble_x_lore.add(" ");
                    cobble_x_lore.add("§ePostaw, aby otworzyc!");
                    cobble_x.setLore(cobble_x_lore);
                    cobble_x.setItemMeta(cobble_x_meta);
                    for(int a = 0; a < mes_stworzyles_cobble_x.size(); a++) {
                        p.sendMessage(mes_stworzyles_cobble_x.get(a).replace("&", "§"));
                    }
                    ItemStack cob = new ItemStack(Material.COBBLESTONE);
                    cob.setAmount(576);
                    p.getInventory().removeItem(cob);
                    p.getInventory().addItem(cobble_x);
                }else {
                    if(!this.cooldowns.containsKey(p.getUniqueId())) {
                        this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                        for(int a = 0; a < mes_za_malo_itemow.size(); a++) {
                            p.sendMessage(mes_za_malo_itemow.get(a).replace("&", "§"));
                        }
                    }else {
                        long timeElapsed = System.currentTimeMillis() - cooldowns.get(p.getUniqueId());
                        if(timeElapsed >= 10000) {
                            this.cooldowns.put(p.getUniqueId(), System.currentTimeMillis());
                            for(int a = 0; a < mes_za_malo_itemow.size(); a++) {
                                p.sendMessage(mes_za_malo_itemow.get(a).replace("&", "§"));
                            }
                        }
                    }
                }
            }
            case BARRIER -> {
                OpenDropGui.OpenGui(p);
            }
            default -> {
                p.updateInventory();
            }
        }

    }
    private boolean isPlayerHaveNineStacks(Player p) {
        boolean isplayerhaveninestacks;
        int i = 0;
        if (p.getInventory().getContents() != null) {
            for (ItemStack is : p.getInventory().getContents()) {
                if (is != null) {
                    if (is.getType() == Material.COBBLESTONE) {
                        i = i + is.getAmount();
                    }
                }
            }
        }
        if(i >= 576) {
            isplayerhaveninestacks = true;
        }else {
            isplayerhaveninestacks = false;
        }
        return isplayerhaveninestacks;
    }
}
