package com.tenjava.entries.TheGamingGrunts.t3.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;

import com.tenjava.entries.TheGamingGrunts.t3.TenJava;
import com.tenjava.entries.TheGamingGrunts.t3.enums.Entity;
import com.tenjava.entries.TheGamingGrunts.t3.enums.MessageType;

public class ChangeRiderEvent extends Event implements Cancellable {

	private boolean isCancelled;
	private static HandlerList handlers = new HandlerList();
	private org.bukkit.entity.Entity passenger;
	
	/**
	 * Event to change the passenger on players' heads
	 */
	public ChangeRiderEvent(){
		if (isEnabled()){
			for (final Player p : Bukkit.getOnlinePlayers()){
				if (p.getPassenger() != null) //clear the current passenger, if there is one
					p.getPassenger().remove();
				this.passenger = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.valueOf(Entity.getRandomEntity().toString()));
	
				new BukkitRunnable(){ //without this, the entity doesn't always get set as the passenger :(
					@Override
					public void run() {
						p.setPassenger(passenger);
					}
				}.runTaskLater(TenJava.getInstance(), 2);
				p.sendMessage(MessageType.PASSENGER.getMsg().replace("mob", passenger.getType().toString()));
			}
		}
	}
	
	/**
	 * Determine if this event is cancelled.
	 * 
	 * @return True if cancelled, false if not
	 */
	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	/**
	 * Set the cancellation state of this event
	 * 
	 *@param cancel : True to cancel the event
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
	 * Get the current passenger that was set
	 * 
	 * @return The current passenger
	 */
	public org.bukkit.entity.Entity getPassenger(){
		return passenger;
	}
	
	/**
	 * Determine if this feature is enabled, as set in the config.yml
	 * 
	 * @return True if enabled, false if not
	 */
	public boolean isEnabled(){
		return TenJava.getInstance().getConfig().getBoolean("PassengerControl.Enabled");
	}
}
