package com.wiji.GrandFinale;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;



public class Finales{

	private final Main main;
	public Finales(Main main) {
	  this.main = main;
	}
	
	public void onFinale(Player player) {
		
		PotionEffect effect = new PotionEffect(PotionEffectType.BLINDNESS, (5 * 20), 10 , true, true);
		player.addPotionEffect(effect);
		
		PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, (30 * 20), 4 , true, true);
		player.addPotionEffect(effect2);
		
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
		    @Override
		    public void run() {
		        player.setHealth(0);
		    }
		}, 60L); 
		
		
	}
}
