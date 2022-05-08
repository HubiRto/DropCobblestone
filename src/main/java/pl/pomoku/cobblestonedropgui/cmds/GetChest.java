package pl.pomoku.cobblestonedropgui.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.pomoku.cobblestonedropgui.main.Main;

import java.util.ArrayList;
import java.util.List;

public class GetChest implements CommandExecutor {
    Main plugin;

    public GetChest(Main m) {
        plugin = m;
        m.getCommand("getchest").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ItemStack ultra_block = new ItemStack(Material.TRAPPED_CHEST);
        ItemMeta ultra_block_meta = ultra_block.getItemMeta();
        ultra_block_meta.setDisplayName("§a§lUltra Block");
        List<String> ultra_block_lore = new ArrayList<>();
        ultra_block_lore.add("§7Jest to skrzynia z ktorej");
        ultra_block_lore.add("§7wypadaja bardzo cenne itemki.");
        ultra_block_lore.add(" ");
        ultra_block_lore.add("§ePostaw, aby otworzyc!");
        ultra_block_meta.setLore(ultra_block_lore);
        ultra_block.setItemMeta(ultra_block_meta);
        ultra_block.setAmount(40);

        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.getInventory().addItem(ultra_block);
            p.sendMessage(ChatColor.GREEN + "Dostales ultra block!");
        }else {
            sender.sendMessage("§cNie można wykonać tej komendy z konsoli!");
        }
        return false;
    }
}
