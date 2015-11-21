package com.halmerson.gadgets;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

/**
 * Created by Dad on 05/11/2015.
 */
public class Launcher implements Listener {

    private static boolean isOnGround(Player player) {
        boolean grd = false;
        if (player.isOnGround()) {
            grd = true;
        }
        if (player.getLocation().getBlock().getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
            grd = true;
        }
        if (player.getLocation().getBlock().getLocation().subtract(0, 2, 0).getBlock().getType() != Material.AIR) {
            grd = true;
            return grd;
        }
        return grd;
    }

    @EventHandler
    public void onInventoryCLICK(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType() == Material.PISTON_BASE) {
            player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
            if (player.getAllowFlight() == false) {
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Launcher> " + ChatColor.RED + ChatColor.BOLD + "Launcher Enabled!");
                player.setAllowFlight(true);
            } else {
                if (player.getAllowFlight() == true) {
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Launcher> " + ChatColor.RED + ChatColor.BOLD + "Launcher Disabled!");
                    player.setAllowFlight(false);
                }
            }
        }
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player player = e.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            double pitch = ((player.getLocation().getPitch() + 90) * Math.PI) / 180;
            double yaw = ((player.getLocation().getYaw() + 90) * Math.PI) / 180;
            double x = Math.sin(pitch) * Math.cos(yaw);
            double y = Math.sin(pitch) * Math.sin(yaw);
            double z = Math.cos(pitch);

            Vector vector = new Vector(x, z, y);
            player.setVelocity(vector);
            player.getWorld().playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 20, 20);
            e.setCancelled(true);
        }
    }
}