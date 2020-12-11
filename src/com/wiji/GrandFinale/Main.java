package com.wiji.GrandFinale;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	
	
	
	@Override
	public void onEnable() {
		System.out.println("Enabling GrandFxinale");
		Bukkit.getPluginManager().registerEvents(new PlayerListener(new Finales(this)), this);
		Bukkit.getPluginManager().registerEvents(new ScoreboardHandler(), this);
		
	
			
	       
	}
	
	@Override
	public void onDisable() {
		
	}
	
	

}
