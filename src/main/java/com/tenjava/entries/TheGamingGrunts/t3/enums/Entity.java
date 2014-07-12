package com.tenjava.entries.TheGamingGrunts.t3.enums;

import java.util.Random;

public enum Entity {

	COW, CREEPER, ZOMBIE, SKELETON, PIG, SHEEP, MUSHROOM_COW, SILVERFISH,
	SPIDER, HORSE, GIANT, CHICKEN, PIG_ZOMBIE, SLIME, CAVE_SPIDER, WITCH, VILLAGER;
	
	private static Random random = new Random();
	
	/**
	 * Get a random entity from this enum
	 * 
	 * @return Random entity
	 */
	public static Entity getRandomEntity(){
		Entity[] entities = Entity.values();
		
		return entities[random.nextInt(entities.length)];
	}
}
