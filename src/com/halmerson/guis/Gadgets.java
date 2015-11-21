package com.halmerson.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by Dad on 26/10/2015.
 */
public class Gadgets implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType() == Material.BLAZE_ROD || e.getCurrentItem().getType() == Material.MONSTER_EGG || e.getCurrentItem().getType() == Material.LEASH) {
            if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Cosmetics")) {
                player.sendMessage(ChatColor.GREEN + "Opening...");
            } else {
                e.setCancelled(true);
            }
        }
    }
        @EventHandler
        public void inventoryClick (InventoryClickEvent e){
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
                player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                Inventory gadgets = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Gadgets");

                int rand = (int) (Math.random() * (16 - 0)) + 0;
                ItemStack one = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) rand);
                ItemMeta onemeta = one.getItemMeta();
                onemeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Welcome to " + ChatColor.GRAY + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC");
                one.setItemMeta(onemeta);
                gadgets.setItem(0, one);
                player.openInventory(gadgets);

                for (int i = 0; i < 27; i++) {
                    gadgets.setItem(i, one);
                }

                // PISTON OBJECT \\

                ItemStack piston = new ItemStack(Material.PISTON_BASE);
                ItemMeta pistonmeta = piston.getItemMeta();
                pistonmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Launcher");
                piston.setItemMeta(pistonmeta);
                gadgets.setItem(14, piston);

                // PISTON OBJECT \\

                // BOW OBJECT \\

                ItemStack bow = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Cat Launcher");
                bow.setItemMeta(bowmeta);
                gadgets.setItem(12, bow);

                // BOW OBJECT \\

                // WHATCH OBJECT \\

                ItemStack watch = new ItemStack(Material.WATCH);
                ItemMeta watchmeta = watch.getItemMeta();
                watchmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Stacker");
                watch.setItemMeta(watchmeta);
                gadgets.setItem(10, watch);

                // WATCH OBJECT \\

                // SLIMEBALL OBJECT \\

                ItemStack coin = new ItemStack(Material.SLIME_BALL);
                ItemMeta coinmeta = coin.getItemMeta();
                coinmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Double Jump");
                coin.setItemMeta(coinmeta);
                gadgets.setItem(16, coin);

                // SLIMEBALL OBJECT \\
            }
           if (e.getCurrentItem().getType() != Material.WATCH || e.getCurrentItem().getType() != Material.BOW || e.getCurrentItem().getType() != Material.PISTON_BASE || e.getCurrentItem().getType() != Material.DOUBLE_PLANT) {
                e.setCancelled(true);
            }
        }
    }
