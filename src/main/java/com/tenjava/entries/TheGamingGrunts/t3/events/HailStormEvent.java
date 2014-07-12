package com.tenjava.entries.TheGamingGrunts.t3.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.tenjava.entries.TheGamingGrunts.t3.TenJava;
import com.tenjava.entries.TheGamingGrunts.t3.enums.MessageType;

public class HailStormEvent extends Event implements Cancellable {

	private boolean isCancelled;
	private static HandlerList handlers = new HandlerList();
	private Random randomX = new Random();
	private Random randomZ = new Random();
	private int hailCount = TenJava.getInstance().getConfig().getInt("HailControl.HailCount");
	private int maxDistance = TenJava.getInstance().getConfig().getInt("HailControl.MaxSpawnDistance");
	
	public HailStormEvent(){
		if (isEnabled()){
			new BukkitRunnable(){
				private int counter = 0; //Count of how many blocks have been spawned in
				public void run(){
					this.counter++; // increment the block count
					if (counter == hailCount){
						this.cancel(); //cancel this timer if the block count reaches the amount to spawn
					}else{
						for (Player p : Bukkit.getOnlinePlayers()){
							int dX = randomX.nextInt(maxDistance);
							int dZ = randomZ.nextInt(maxDistance);
							p.getWorld().spawnFallingBlock(p.getLocation().add(dX, 50, dZ), Material.PACKED_ICE, (byte) 0).setVelocity(new Vector(0, -4, 0));
						}
					}
				}
			}.runTaskTimer(TenJava.getInstance(), 0, 2);
			Bukkit.broadcastMessage(MessageType.HAILSTORM.getMsg());
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
		return TenJava.getInstance().getConfig().getBoolean("HailControl.Enabled");
	}

}
