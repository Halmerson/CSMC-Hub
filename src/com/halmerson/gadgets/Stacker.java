package com.halmerson.gadgets;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dad on 06/11/2015.
 */
public class Stacker implements Listener {

    ArrayList<String> stacker = new ArrayList<String>();

    @EventHandler
    public void onInventoryCLIck(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Gadgets")) {
            if (e.getCurrentItem().getType() == Material.WATCH) {
                player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                if (!stacker.contains(player.getName())) {

                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Stacker> " + ChatColor.RED + ChatColor.BOLD + "Stacker Enabled!");
                    stacker.add(player.getName());
                } else {
                    if (stacker.contains(player.getName())) {
                        stacker.remove(player.getName());
                        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Stacker> " + ChatColor.RED + ChatColor.BOLD + "Stacker Disabled!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event1) {
        Player player = event1.getPlayer();
        Entity entity = event1.getRightClicked();
        if (stacker.contains(player.getName())) {
            player.setPassenger(entity);
        }
    }
}
