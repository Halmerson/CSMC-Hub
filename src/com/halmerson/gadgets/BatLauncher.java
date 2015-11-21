package com.halmerson.gadgets;

import com.halmerson.Hub;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dad on 28/10/2015.
 */
public class BatLauncher implements Listener {

    public Hub plugin;

    public BatLauncher(Hub instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onInventoryCLIck(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Gadgets")) {
            if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);

                ItemStack batLauncher = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta batLauncherMeta = batLauncher.getItemMeta();
                batLauncherMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Bat Launcher");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Right click to use this!");
                batLauncherMeta.setLore(lore);
                batLauncher.setItemMeta(batLauncherMeta);
                if (!player.getInventory().contains(Material.DIAMOND_SWORD, 1)) {
                    player.getInventory().addItem(batLauncher);
                } else {
                    if (player.getInventory().contains(Material.DIAMOND_SWORD, 1))
                        player.sendMessage(ChatColor.RED + "You already have a diamond sword!");
                }
            }
        }
    }

    @EventHandler
    public void batShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                if (player.getInventory().contains(Material.DIAMOND_SWORD, 2)) {
                    player.sendMessage(ChatColor.RED + "You already have a diamond sword!");
                    return;
                } else {
                    player.getWorld().playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1.5F);
                    double pitch = ((player.getLocation().getPitch() + 90) * Math.PI) / 180;
                    double yaw = ((player.getLocation().getYaw() + 90) * Math.PI) / 180;
                    double x = Math.sin(pitch) * Math.cos(yaw);
                    double y = Math.sin(pitch) * Math.sin(yaw);
                    double z = Math.cos(pitch);

                    Vector vector = new Vector(x, z, y);

                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                    player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.BAT).setVelocity(vector.multiply(2));
                }
            }

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    for (Entity bat : player.getWorld().getEntities()) {
                        // Only bats | SGTBUD
                        if (bat instanceof Bat) {
                            // Set the bat's health to 0, killing it | SGTBUD
                            ((Bat) bat).setHealth(0.0D);
                        }
                    }
                }
            }, 60);
        }
    }
}