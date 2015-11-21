package com.halmerson.commands;

import com.halmerson.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Dad on 09/11/2015.
 */
public class Money implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        MoneyAPI api = new MoneyAPI();
        Player player = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);
        if(cmd.getName().equalsIgnoreCase("g")) {
            try{
                Double.parseDouble(args[1]);
                api.addMoney(player, Double.parseDouble(args[1]));
            }catch(NumberFormatException e){
                player.sendMessage(ChatColor.RED + "Not a valid number!");
            }
        }
        return true;
    }
}
