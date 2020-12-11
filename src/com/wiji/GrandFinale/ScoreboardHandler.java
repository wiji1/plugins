package com.wiji.GrandFinale;

import java.text.NumberFormat;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler implements Listener {

	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	Objective objective1 = board.registerNewObjective("Player", "Scoreboard");
	
	
	public static int xp = 63129;
	public static int gold = 59681;
	public static int bounty = 0;
	
	@EventHandler
	public void onTest(PlayerJoinEvent e) {
		
		
	
		
	
		
	Player player = e.getPlayer();
		
		objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective1.setDisplayName(" " + ChatColor.YELLOW + "" + ChatColor.BOLD + "THE HYPIXEL PIT");
		Score score = objective1.getScore(ChatColor.GRAY + "12/09/20" + ChatColor.DARK_GRAY + " mega8D"); 
		score.setScore(11);
		Score score2 = objective1.getScore(" "); 
		score2.setScore(10);
		Score score3 = objective1.getScore("Prestige:" + ChatColor.YELLOW + " XXXI"); 
		score3.setScore(9);
		Score score4 = objective1.getScore("Level: [" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "106" + ChatColor.WHITE + "]"); 
		score4.setScore(8);
		Score score5 = objective1.getScore("Needed XP:" + ChatColor.AQUA + " 63,129"); 
		score5.setScore(7);
		Score score6 = objective1.getScore("  "); 
		score6.setScore(6);
		Score score7 = objective1.getScore("Gold:" + ChatColor.GOLD + " 59,681g");
		score7.setScore(5);
		Score score8 = objective1.getScore("   "); 
		score8.setScore(4);
		Score score9 = objective1.getScore("Status:" + ChatColor.GREEN + " Idling"); 
		score9.setScore(3);
		Score score12 = objective1.getScore("    ");
		score12.setScore(2);
		Score score13 = objective1.getScore(ChatColor.YELLOW + "www.hypixel.net"); 
		score13.setScore(1);
		
		
		
		
		
		player.setScoreboard(board);
		
		
	}
	
	public void updateObjective1(int kills, Player player) {
		
		System.out.println(kills + " v2");
		
		objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective1.setDisplayName(" " + ChatColor.YELLOW + "" + ChatColor.BOLD + "THE HYPIXEL PIT");
		Score score = objective1.getScore(ChatColor.GRAY + "12/09/20" + ChatColor.DARK_GRAY + " mega8D"); 
		score.setScore(13);
		Score score2 = objective1.getScore(" "); 
		score2.setScore(12);
		Score score3 = objective1.getScore("Prestige:" + ChatColor.YELLOW + " XXXI"); 
		score3.setScore(11);
		Score score4 = objective1.getScore("Level: [" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "106" + ChatColor.WHITE + "]"); 
		score4.setScore(10);
		xp = xp - 85;
	      NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	      String newxp = numberFormat.format(xp);		
		Score score5 = objective1.getScore("Needed XP:" + ChatColor.AQUA + " " + newxp); 
		score5.setScore(9);
		Score score6 = objective1.getScore("  "); 
		score6.setScore(8);
		gold = gold + 56;
		NumberFormat numberFormat2 = NumberFormat.getNumberInstance(Locale.US);
	      String newgold = numberFormat.format(gold);		
		
		Score score7 = objective1.getScore("Gold:" + ChatColor.GOLD + " " + newgold);
		score7.setScore(7);
		Score score8 = objective1.getScore("   "); 
		score8.setScore(6);
		
		double bountyChance = Math.random();
		
		if(kills > 99) {
			Score finale = objective1.getScore("Status:" + ChatColor.YELLOW + " Grand Finale");
			finale.setScore(5);
			if(kills == 100) {
				player.playSound(player.getLocation(), Sound.ENDERDRAGON_DEATH, (float) 1.5, (float) 1.8);
			}
			
		} else {
		if(bounty > 0 && kills > 0 || bountyChance < 0.15) {
			Score score9 = objective1.getScore("Status:" + ChatColor.RED + " Bountied"); 
		score9.setScore(5);
		} else {
			if(kills == 0) {
				Score score9 = objective1.getScore("Status:" + ChatColor.GREEN + " Idling"); 
				score9.setScore(5);
			} else {
			Score score9 = objective1.getScore("Status:" + ChatColor.RED + " Fighting"); 
			score9.setScore(5);
			}
		}
		
			
		
		}
		
		
		if (bountyChance < 0.15) {
			if(bounty < 201) {
				bounty = bounty + 50;
				player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BOUNTY!" + ChatColor.GRAY + " bump" + ChatColor.GOLD
						+ "" + ChatColor.BOLD + " 50g" + ChatColor.GRAY + " on" + ChatColor.WHITE + " [" + ChatColor.LIGHT_PURPLE
						+ "" + ChatColor.BOLD + "106" + ChatColor.WHITE + "]" + ChatColor.AQUA + " wiji1" + ChatColor.GRAY +
						" for high streak");
				player.playSound(player.getLocation(), Sound.WITHER_SPAWN, (float) 0.8, (float) 1.8);
			}
			if(bounty < 701 && bounty > 200) {
			bounty = bounty + 100;
			player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BOUNTY!" + ChatColor.GRAY + " bump" + ChatColor.GOLD
					+ "" + ChatColor.BOLD + " 100g" + ChatColor.GRAY + " on" + ChatColor.WHITE + " [" + ChatColor.LIGHT_PURPLE
					+ "" + ChatColor.BOLD + "106" + ChatColor.WHITE + "]" + ChatColor.AQUA + " wiji1" + ChatColor.GRAY +
					" for high streak");
			player.playSound(player.getLocation(), Sound.WITHER_SPAWN, (float) 0.8, (float) 1.8);
			}
			if(bounty > 700 && bounty < 5000) {
				
				bounty = bounty + 300;
				if(bounty < 5000) {
				
					player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BOUNTY!" + ChatColor.GRAY + " bump" + ChatColor.GOLD
						+ "" + ChatColor.BOLD + " 300g" + ChatColor.GRAY + " on" + ChatColor.WHITE + " [" + ChatColor.LIGHT_PURPLE
						+ "" + ChatColor.BOLD + "106" + ChatColor.WHITE + "]" + ChatColor.AQUA + " wiji1" + ChatColor.GRAY +
						" for high streak");
					player.playSound(player.getLocation(), Sound.WITHER_SPAWN, (float) 0.8, (float) 1.8);
				} else {
					bounty = 5000;
				}
				
			}
		
		}
		
		if(bounty > 0) {
			if (!(kills == 0)) {
		Score score10 = objective1.getScore("Bounty:" + ChatColor.GOLD + " " + bounty + "g"); 
		score10.setScore(4);
			} else {
				bounty = 0;
			}
		} 
		if(!(kills ==0)) {
		Score score11 = objective1.getScore("Streak:" + ChatColor.GREEN + " " + kills); 
		score11.setScore(3);
		}
		Score score12 = objective1.getScore("    ");
		score12.setScore(2);
		Score score13 = objective1.getScore(ChatColor.YELLOW + "www.hypixel.net"); 
		score13.setScore(1);
		
		player.setScoreboard(board);
		
	}
	
	
	
}
