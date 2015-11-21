package com.halmerson.pets;

import com.dsh105.echopet.api.EchoPetAPI;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.plugin.EchoPet;
import com.halmerson.MoneyAPI;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Dad on 27/10/2015.
 */
public class Pets implements Listener {

    public EchoPetAPI getEchoPetAPI() {
        return EchoPetAPI.getAPI();
    }

    // TODO WHATS GOING ON HERE? IN PETS INVENROY, IF I HAVE A MORPH EQUIPPED, AND CLICK ANYWHERE IN PETS INVENTORY IT SAYS YOU HAVE A MORPH EQUIPPED!
    // TODO LOOK INTO THAT!!!!

    @EventHandler
    public void onInventoryCLIck(InventoryClickEvent e) {
        MoneyAPI api = new MoneyAPI();
        Player player = (Player) e.getWhoClicked();
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Pets")) {

            if (DisguiseAPI.isDisguised(player)) {
                DisguiseAPI.undisguiseToAll(player);
            }

            if (e.getSlot() == 14) {
                if (api.hasMoney(player, 5000.0)) {
                    EchoPetAPI.getAPI().givePet(player, PetType.VILLAGER, false);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a villager pet!");
                api.removeMoney(player, 5000.0);
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Pets> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 12) {
                if (api.hasMoney(player, 5000.0)) {
                    EchoPetAPI.getAPI().givePet(player, PetType.COW, false);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a cow pet!");
                    api.removeMoney(player, 5000.0);
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Pets> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 10) {
                if (api.hasMoney(player, 5000.0)) {
                    EchoPetAPI.getAPI().givePet(player, PetType.SQUID, false);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a squid pet!");
                api.removeMoney(player, 5000.0);
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Pets> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 16) {
                if (api.hasMoney(player, 5000.0)) {
                    EchoPetAPI.getAPI().givePet(player, PetType.PIG, false);
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + "" + ChatColor.BOLD + "MC" + ChatColor.DARK_GRAY + "> " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You equipped a pig pet!");
                api.removeMoney(player, 5000.0);
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "Pets> " + ChatColor.BOLD+ChatColor.BOLD + "You do not have enough money!");
                }
            }
            if (e.getSlot() == 26) {
                EchoPetAPI.getAPI().removePet(player, false, true);
            }
        }
    }
            @EventHandler
            public void onplayerleave(PlayerQuitEvent e){
                Player player = e.getPlayer();
                EchoPetAPI.getAPI().removePet(player, false, true);
            }
        }
