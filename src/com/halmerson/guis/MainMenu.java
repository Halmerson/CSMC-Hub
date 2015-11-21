package com.halmerson.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Dad on 26/10/2015.
 */
public class MainMenu implements Listener {

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) ;
        if (player.getInventory().getItemInHand().getType() == Material.CHEST) {
            Inventory cosmetics = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Cosmetics");


            int rand = (int) (Math.random() * (16 - 0)) + 0;
            ItemStack one = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) rand);
            ItemMeta onemeta = one.getItemMeta();
            onemeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Welcome to " + ChatColor.GRAY + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC");
            one.setItemMeta(onemeta);
            cosmetics.setItem(0, one);
            player.openInventory(cosmetics);

            for (int i = 0; i < 27; i++) {
                cosmetics.setItem(i, one);
            }

            // BLAZE ROD OBJECT \\
            ItemStack blazerod = new ItemStack(Material.BLAZE_ROD);
            ItemMeta blazerodmeta = blazerod.getItemMeta();
            blazerodmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Gadgets");
            blazerod.setItemMeta(blazerodmeta);
            cosmetics.setItem(11, blazerod);
            player.openInventory(cosmetics);
            // BLAZW ROD OBJECT \\

            // LEAD OBJECT \\
            ItemStack lead = new ItemStack(Material.LEASH);
            ItemMeta leadmeta = lead.getItemMeta();
            leadmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Pets");
            lead.setItemMeta(leadmeta);
            cosmetics.setItem(15, lead);
            player.openInventory(cosmetics);
            // LEAD OBJECT

            // MONETER EGG OBJECT \\
            ItemStack creeperegg = new ItemStack(Material.MONSTER_EGG, 1, (short) 50);
            ItemMeta crepereggmeta = creeperegg.getItemMeta();
            crepereggmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Morphs");
            creeperegg.setItemMeta(crepereggmeta);
            cosmetics.setItem(13, creeperegg);
            player.openInventory(cosmetics);
            // CREEPER EGG OBJECT \\

        }

    }
}
