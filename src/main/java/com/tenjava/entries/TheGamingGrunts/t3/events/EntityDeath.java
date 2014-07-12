package com.tenjava.entries.TheGamingGrunts.t3.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener{
	
	@EventHandler
	public void onDamage(EntityDeathEvent e){
		if (e.getEntity() instanceof Creeper){
			if (e.getEntity().getKiller() instanceof Player){
				Bukkit.getPluginManager().callEvent(new CreeperMultiplyEvent(e.getEntity().getLocation()));
			}
		}
	}
}
