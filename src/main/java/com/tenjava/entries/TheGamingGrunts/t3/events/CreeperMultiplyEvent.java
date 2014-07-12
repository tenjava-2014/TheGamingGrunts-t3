package com.tenjava.entries.TheGamingGrunts.t3.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.tenjava.entries.TheGamingGrunts.t3.TenJava;

public class CreeperMultiplyEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean isCancelled;
	private Random random = new Random();
	private int amount, distance;
	private final int CHANCE = 1;
	
	/**
	 * Spawn a random amount of creepers at a random distance from a given location
	 * 
	 * @param location : The location where the original Creeper was damaged
	 */
	public CreeperMultiplyEvent(Location location){
		if (isEnabled()){
			if (random.nextInt(2) == CHANCE){
				this.amount = random.nextInt(TenJava.getInstance().getConfig().getInt("CreeperControl.MaxSpawnAmount"));
		
				for (int i = 0; i < amount; i++){ 
					this.distance = random.nextInt(TenJava.getInstance().getConfig().getInt("CreeperControl.MaxSpawnDistance"));
					location.getWorld().spawnEntity(new Location(location.getWorld(), location.getX() + distance, 
							location.getY(), location.getZ() + distance), EntityType.CREEPER);
				}
			}
		}
	}
	
	/**
	 * Determine if this event is cancelled
	 */
	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	/**
	 * Set the cancellation state of this event
	 * @param cancel : True to cancel the event
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = cancel;
	}

	/**
	 * Get the handlers for this event
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	/**
	 * Get the amount of zombies spawned when this event was fired
	 * 
	 * @return The amount of zombies that were spawned
	 */
	public int getAmount(){
		return amount;
	}
	
	/**
	 * Determine if this event is enabled in the config.yml
	 * 
	 * @return True if enabled, false otherwise
	 */
	public boolean isEnabled(){
		return TenJava.getInstance().getConfig().getBoolean("CreeperControl.Enabled");
	}
}
