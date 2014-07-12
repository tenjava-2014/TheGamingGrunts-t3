package com.tenjava.entries.TheGamingGrunts.t3.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.tenjava.entries.TheGamingGrunts.t3.TenJava;
import com.tenjava.entries.TheGamingGrunts.t3.enums.Entity;
import com.tenjava.entries.TheGamingGrunts.t3.enums.MessageType;

public class MobDownpourEvent extends Event implements Cancellable {

	private boolean isCancelled;
	private static HandlerList handlers = new HandlerList();
	private Random randomX = new Random();
	private Random randomZ = new Random();
	private int mobsToSpawn = TenJava.getInstance().getConfig().getInt("MobDownpourControl.MobsToSpawn");
	private int distance = TenJava.getInstance().getConfig().getInt("MobDownpourControl.MaxSpawnDistance");
	
	/**
	 * At random, flaming mobs will be spawned high in the air and will rain down upon everyone
	 * 
	 * @param world : The world in which the "downpour" will occur
	 */
	public MobDownpourEvent(){
		if (isEnabled()){
			for (World world : Bukkit.getWorlds()){
				for (Player p : world.getPlayers()){
					for (int i = 0; i < mobsToSpawn; i++){
						String e = Entity.getRandomEntity().toString();
						Location l = p.getLocation().add(randomX.nextInt(distance), 110, randomZ.nextInt(distance));
						org.bukkit.entity.Entity en = world.spawnEntity(l, EntityType.valueOf(e));
						en.setFireTicks(120);
					}
				}	
			}
			Bukkit.broadcastMessage(MessageType.DOWNPOUR.getMsg());
		}
	}
	
	/**
	 * Determing if this event is cancelled
	 * 
	 * @return True if cancelled, false otherwise
	 */
	@Override
	public boolean isCancelled() {
		return isCancelled;
	}
	
	/**
	 * Set the cancellation state of this event
	 * 
	 * @param cancel : True to cancel the event
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = cancel;
	}

	/**
	 * Get the handlers for this event
	 * 
	 * @return The handlers for this event
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	/**
	 * Determine if this feature is enabled, as set in the config.yml
	 * 
	 * @return True if enabled, false if not
	 */
	public boolean isEnabled(){
		return TenJava.getInstance().getConfig().getBoolean("MobDownpourContro.Enabled");
	}

}
