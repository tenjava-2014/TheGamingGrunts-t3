package com.tenjava.entries.TheGamingGrunts.t3.enums;

import java.util.Random;

public enum EventType {

	CHANGE_RIDER, MOB_DOWNPOUR, HAILSTORM;
	
	private static Random rand = new Random();
	
	/**
	 * Get a random event from the available events in this enu,
	 * 
	 * @return A random event
	 */
	public static EventType getRandomEvent(){
		EventType[] events = EventType.values();
		
		return events[rand.nextInt(events.length)];
	}
}
