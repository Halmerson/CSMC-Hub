package com.halmerson.morphs;

import com.dsh105.echopet.api.EchoPetAPI;
import com.halmerson.MoneyAPI;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Dad on 27/10/2015.
 */
public class MorphingPlayer implements Listener {

    public EchoPetAPI getEchoPetAPI() {
        return EchoPetAPI.getAPI();
    }

    @EventHandler
    public void onInventoryCLIck(InventoryClickEvent e) {
        MoneyAPI api = new MoneyAPI();
        Player player = (Player) e.getWhoClicked();
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Morphs")) {

            if(EchoPetAPI.getAPI().hasPet(player)) {
                EchoPetAPI.getAPI().removePet(player, false, true);
            }

            if (e.getSlot() == 14) {
                if(api.hasMoney(player, 5000.0)) {
                    player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                    DisguiseAPI.disguiseToAll(player, new MobDisguise(DisguiseType.VILLAGER));
                    player.getWorld().playSound(player.getLocation(), Sound.VILLAGER_HIT, 20, 20);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a villager morph!");
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Morphs> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 12) {
                if (api.hasMoney(player, 5000.0)) {
                    player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                    DisguiseAPI.disguiseEntity(player, new MobDisguise(DisguiseType.COW));
                    player.getWorld().playSound(player.getLocation(), Sound.COW_HURT, 20, 20);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a cow morph!");
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Morphs> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 10) {
                if (api.hasMoney(player, 5000.0)) {
                    player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                    DisguiseAPI.disguiseEntity(player, new MobDisguise(DisguiseType.SQUID));
                    player.getWorld().playSound(player.getLocation(), Sound.WATER, 20, 20);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a squid morph!");
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Morphs> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 16) {
                if (api.hasMoney(player, 5000.0)) {
                    player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                    DisguiseAPI.disguiseEntity(player, new MobDisguise(DisguiseType.PIG));
                    player.getWorld().playSound(player.getLocation(), Sound.PIG_DEATH, 20, 20);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a pig morph!");
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Morphs> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 26) {
                player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
                DisguiseAPI.undisguiseToAll(player);
            }
        }
    }
}