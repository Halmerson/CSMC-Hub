package com.halmerson.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Dad on 28/10/2015.
 */
public class InventoryClick implements Listener {

    @EventHandler
    public void invCLIck(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (player.hasPermission("hub.invmove")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
    }
}
