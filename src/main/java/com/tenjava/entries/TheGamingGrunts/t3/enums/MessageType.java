package com.tenjava.entries.TheGamingGrunts.t3.enums;

import org.bukkit.ChatColor;

public enum MessageType {

	PREFIX("&8[&bMinecraftMadness&8] "),
	HAILSTORM(PREFIX.getMsg() + "&7Hailstorm incoming!"),
	DOWNPOUR(PREFIX.getMsg() + "&7Mob Downpour incoming!"),
	PASSENGER(PREFIX.getMsg() + "&7You now have a &bmob &7as a passenger!"),
	CMD_INVALID(PREFIX.getMsg() + "&4Invalid command argument specified!");
	
	String msg;
	
	MessageType(String msg){
		this.msg = msg;
	}
	
	/**
	 * Get the message
	 * 
	 * @return The message to be sent
	 */
	public String getMsg(){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
