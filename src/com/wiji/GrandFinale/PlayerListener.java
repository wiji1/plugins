package com.wiji.GrandFinale;

import java.util.HashMap;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

public class PlayerListener implements Listener {
	
	public static HashMap<String, Integer> playerKills = new HashMap<String, Integer>();
	

	private final Finales finales;
	public PlayerListener(Finales finales) {
		this.finales = finales;
	 
	}
	
	
		@EventHandler
		public void onJoin(PlayerJoinEvent e) {
			playerKills.put("e", 0);
			
			
			PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + "TEST" + "\"}"), (byte) 2);
			((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(packet); 
			
			
			
			
			
			
			
		}
		
		
		@EventHandler
		public void onLeave(PlayerQuitEvent e) {
			playerKills.remove(e.getPlayer().getDisplayName());
		}
	
		@EventHandler
		public void onDeath(PlayerDeathEvent e) {
			
			playerKills.remove("e");
			playerKills.put("e", 0);
			int resetkills = playerKills.get("e");
			
			ScoreboardHandler cls = new ScoreboardHandler();
			cls.updateObjective1(resetkills, e.getEntity().getPlayer());;
			
		}
		
		
	
		@EventHandler
		public void onTest(EntityDeathEvent e) {
			System.out.println("Triggered");
			
			
			
			if(playerKills.containsKey("e")) {
			
				System.out.println(playerKills);
			
			int kills = playerKills.get("e");
			playerKills.remove("e");
			
			playerKills.put("e", kills + 1);
			
			int kills2 = playerKills.get("e");
			
			if(kills2 == 100) {
				
				finales.onFinale(e.getEntity().getKiller());
			}
			
			
			double rank = Math.random();
			if(rank > 0.7) {
				String entity = ChatColor.GRAY + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.GRAY + " [" +  ChatColor.DARK_GREEN + "32" + ChatColor.GRAY + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else if(rank > 0.5) {
				String entity = ChatColor.GREEN + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.BLUE + " [" + ChatColor.YELLOW + "56" + ChatColor.BLUE + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else if(rank > 0.3) {
				String entity = ChatColor.GOLD + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.RED + " [" + ChatColor.WHITE + "" + ChatColor.BOLD + "112" + ChatColor.RED + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else if(rank > 0.1) {
				String entity = ChatColor.AQUA + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.GRAY + " [" + ChatColor.AQUA + "" + ChatColor.BOLD + "120" + ChatColor.GRAY + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else if(rank > 0.06 ) {
				String entity = ChatColor.BLUE + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.DARK_PURPLE + " [" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "106" + ChatColor.DARK_PURPLE + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else if(rank > 0.03) {
				String entity = ChatColor.DARK_GREEN + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.GOLD + " [" + ChatColor.RED + "" + ChatColor.BOLD + "72" + ChatColor.GOLD + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			} else {
				String entity = ChatColor.RED + e.getEntity().getName();
				e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "KILL!" + ChatColor.GRAY
						+ " on" + ChatColor.YELLOW + " [" + ChatColor.DARK_GREEN + "32" + ChatColor.YELLOW + "] " + entity + ChatColor.AQUA + 
						" +85XP" + ChatColor.GOLD + " +56g");
			}
			
			
			
			
			
			ScoreboardHandler cls = new ScoreboardHandler();
			cls.updateObjective1(kills2, e.getEntity().getKiller());
			System.out.println("sent");
			} else {
				System.out.println("no e");
			}
			
}
			
			
		}
	
		

