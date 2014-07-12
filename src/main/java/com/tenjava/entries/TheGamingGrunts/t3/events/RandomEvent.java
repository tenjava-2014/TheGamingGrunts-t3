package com.tenjava.entries.TheGamingGrunts.t3.events;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.tenjava.entries.TheGamingGrunts.t3.TenJava;
import com.tenjava.entries.TheGamingGrunts.t3.enums.EventType;

public class RandomEvent {

	public void callRandomEvent(int ticks){
		new BukkitRunnable(){
			public void run(){
				EventType et = EventType.getRandomEvent();
				switch(et){
				case CHANGE_RIDER:
					Bukkit.getPluginManager().callEvent(new ChangeRiderEvent());
					break;
				case MOB_DOWNPOUR:
					Bukkit.getPluginManager().callEvent(new MobDownpourEvent());
					break;
				case HAILSTORM:
					Bukkit.getPluginManager().callEvent(new HailStormEvent());
				default:
					break;
				}
			}
		}.runTaskTimer(TenJava.getInstance(), 0, ticks * 1200);
	}
}
