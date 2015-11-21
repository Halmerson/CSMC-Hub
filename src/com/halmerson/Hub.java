package com.halmerson;

import com.halmerson.events.*;
import com.halmerson.gadgets.BatLauncher;
import com.halmerson.gadgets.Launcher;
import com.halmerson.gadgets.Stacker;
import com.halmerson.guis.Gadgets;
import com.halmerson.guis.MainMenu;
import com.halmerson.guis.Morphs;
import com.halmerson.guis.Pets;
import com.halmerson.morphs.MorphingPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Dad on 26/10/2015.
 */
public class Hub extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Stacker(), this);
        getServer().getPluginManager().registerEvents(new MainMenu(), this);
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
        getServer().getPluginManager().registerEvents(new Gadgets(), this);
        getServer().getPluginManager().registerEvents(new Morphs(), this);
        getServer().getPluginManager().registerEvents(new Pets(), this);
        getServer().getPluginManager().registerEvents(new com.halmerson.pets.Pets(), this);
        getServer().getPluginManager().registerEvents(new MorphingPlayer(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new BatLauncher(this), this);
        getServer().getPluginManager().registerEvents(new Launcher(), this);
        getServer().getPluginManager().registerEvents(this, this);

    }

    public void onDisable() {

    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void damage(EntityDamageEvent e) {
        e.setCancelled(true);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void hunger(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }
}
