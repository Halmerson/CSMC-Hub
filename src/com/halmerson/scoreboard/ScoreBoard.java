package com.halmerson.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * Created by Dad on 27/10/2015.
 */
public class ScoreBoard implements Listener {

    private Scoreboard sb;

    public void setupScoreBoard() {
        sb = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective broken = sb.registerNewObjective("broken", "dummy");
        broken.setDisplayName("CS:MC");
        broken.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public Scoreboard getScoreboard() {
        return this.sb;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setScoreboard(getScoreboard());
    }
}
