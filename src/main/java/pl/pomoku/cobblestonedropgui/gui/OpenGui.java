package pl.pomoku.cobblestonedropgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenGui {
    public static void OpenGui(Player p) {
        Inventory i = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Drop z kamienia");

        ItemStack iron = Iron.iron(p);
        ItemStack gold = Gold.gold(p);
        ItemStack obsidian = Obsidian.obsidian(p);
        ItemStack emerald = Emerald.emerald(p);
        ItemStack hopper = Hopper.hopper(p);
        ItemStack coal = Coal.coal(p);
        ItemStack apple = Apple.apple(p);
        ItemStack tnt = Tnt.tnt(p);
        ItemStack slimeball = Slimeball.slimeball(p);
        ItemStack redstone = Redstone.redstone(p);
        ItemStack oaklog = Oaklog.oaklog(p);
        ItemStack netherite = Netherite.netherite(p);
        ItemStack glowtnt = GlowTnt.glowtnt(p);
        ItemStack enderpearl = Enderpearl.enderpearl(p);
        ItemStack enderchest = Enderchest.enderchest(p);
        ItemStack chest = Chest.chest(p);
        ItemStack bookshelf = Bookshelf.bookshelf(p);
        ItemStack arrow = Arrow.arrow(p);
        ItemStack diamond = Diamond.diamond(p);
        ItemStack cobblestone = Cobblestone.cobblestone(p);
        ItemStack limestainedglasspane = Limestainedglasspane.limestainedglasspane(p);
        ItemStack blackstainedglasspane = Blackstainedglasspane.blackstainedglasspane(p);
        ItemStack redstainedglasspane = Redstainedglasspane.redstainedglasspane(p);

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
        i.setItem(1, cobblestone);

        i.setItem(3, limestainedglasspane);

        i.setItem(5, redstainedglasspane);
        i.setItem(8, glowtnt);

        i.setItem(2, blackstainedglasspane);
        i.setItem(6, blackstainedglasspane);
        i.setItem(9, blackstainedglasspane);

        i.setItem(10, blackstainedglasspane);
        i.setItem(11, blackstainedglasspane);
        i.setItem(12, blackstainedglasspane);
        i.setItem(13, blackstainedglasspane);
        i.setItem(14, blackstainedglasspane);
        i.setItem(15, blackstainedglasspane);
        i.setItem(16, blackstainedglasspane);
        i.setItem(17, blackstainedglasspane);
        i.setItem(18, blackstainedglasspane);
        i.setItem(19, blackstainedglasspane);
        i.setItem(25, blackstainedglasspane);
        i.setItem(26, blackstainedglasspane);
        i.setItem(28, blackstainedglasspane);
        i.setItem(34, blackstainedglasspane);
        i.setItem(36, blackstainedglasspane);
        i.setItem(37, blackstainedglasspane);
        i.setItem(43, blackstainedglasspane);
        i.setItem(44, blackstainedglasspane);
        i.setItem(45, blackstainedglasspane);
        i.setItem(46, blackstainedglasspane);
        i.setItem(47, blackstainedglasspane);
        i.setItem(48, blackstainedglasspane);
        i.setItem(49, blackstainedglasspane);
        i.setItem(50, blackstainedglasspane);
        i.setItem(51, blackstainedglasspane);
        i.setItem(52, blackstainedglasspane);
        i.setItem(53, blackstainedglasspane);

        p.openInventory(i);
    }
}
