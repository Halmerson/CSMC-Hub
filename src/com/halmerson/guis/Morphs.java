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
public class Morphs implements Listener {

    @EventHandler
    public void inventoryCLickl(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType() == Material.MONSTER_EGG && ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Cosmetics")) {
            player.getWorld().playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1.5F);
            Inventory morphs = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Morphs");

            int rand = (int) (Math.random() * (16 - 0)) + 0;
            ItemStack one = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) rand);
            ItemMeta onemeta = one.getItemMeta();
            onemeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Welcome to " + ChatColor.GRAY + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC");
            one.setItemMeta(onemeta);
            morphs.setItem(0, one);
            player.openInventory(morphs);

            for (int i = 0; i < 27; i++) {
                morphs.setItem(i, one);
            }

            // VILLAGER \\

            ItemStack villager = new ItemStack(Material.MONSTER_EGG, 1, (short) 120);
            ItemMeta villagermeta = villager.getItemMeta();
            villagermeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Villager Morph");
            villager.setItemMeta(villagermeta);
            morphs.setItem(14, villager);

            // VILLAGER \\

            // COW \\

            ItemStack cow = new ItemStack(Material.MONSTER_EGG, 1, (short) 92);
            ItemMeta cowmeta = cow.getItemMeta();
            cowmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Cow Morph");
            cow.setItemMeta(cowmeta);
            morphs.setItem(12, cow);

            // COW \\

            // SQUID \\

            ItemStack squid = new ItemStack(Material.MONSTER_EGG, 1, (short) 94);
            ItemMeta squidmeta = squid.getItemMeta();
            squidmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Squid Morph");
            squid.setItemMeta(squidmeta);
            morphs.setItem(10, squid);

            // SQUID \\

            // PIG \\

            ItemStack pig = new ItemStack(Material.MONSTER_EGG, 1, (short) 90);
            ItemMeta pigmeta = pig.getItemMeta();
            pigmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Pig Morph");
            pig.setItemMeta(pigmeta);
            morphs.setItem(16, pig);

            // PIG \\

            ItemStack back = new ItemStack(Material.BEDROCK);
            ItemMeta backmeta = back.getItemMeta();
            backmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "CS:" + ChatColor.RED + ChatColor.BOLD + "MC " + ChatColor.DARK_RED + ChatColor.BOLD + "Un-Equip");
            back.setItemMeta(backmeta);
            morphs.setItem(26, back);

        }

        if (e.getCurrentItem().getType() == Material.MONSTER_EGG && ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Morphs")) {

        }

        if (e.getCurrentItem().getType() != Material.WATCH || e.getCurrentItem().getType() != Material.BOW || e.getCurrentItem().getType() != Material.PISTON_BASE || e.getCurrentItem().getType() != Material.DOUBLE_PLANT) {
            e.setCancelled(true);
        }else{
            // TODO IF THEY CLICK SOMETHING, MAKE SURE THEY HAVE PERMSIIONS TO USE IT. THEN SEND A MESSAGE!
            // TODO MAKE SURE TO GET THE ITEM THEY CLICK!

        }
    }
}
