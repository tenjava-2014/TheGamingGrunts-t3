package com.tenjava.entries.TheGamingGrunts.t3;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.TheGamingGrunts.t3.commands.MainCommand;
import com.tenjava.entries.TheGamingGrunts.t3.events.EntityDeath;
import com.tenjava.entries.TheGamingGrunts.t3.events.RandomEvent;

public class TenJava extends JavaPlugin {
	
	private static TenJava plugin;
	
	public void onEnable(){
		plugin = this;
		
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(new EntityDeath(), TenJava.getInstance());
		getCommand("mm").setExecutor(new MainCommand());
		
		new RandomEvent().callRandomEvent(getConfig().getInt("General.RandomEventTime")); //Call random event every x minutes
	}
	
	public static TenJava getInstance(){
		return plugin;
	}
	
}
