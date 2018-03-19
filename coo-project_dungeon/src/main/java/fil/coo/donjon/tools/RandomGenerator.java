package fil.coo.donjon.tools;

import java.util.*;
import java.util.Random;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.room.*;

/**
 * Creates random Dungeon's objects, in order to generate random game 
 * @author DEROISSART / SASU
 */


public class RandomGenerator {
	
	//METHODES
	
	/**
	 * Generate a random monster
	 * @param maxLife the max life of a life potion
	 * @param maxStrength the maximum strength of a strenght potion
	 * @param room the room to put the item/character in
	 * @param maxGold the maximum gold of a gold pouch
	 * @return a random monster
	 */
	public static Monster generateRandomMonster(int maxLife, int maxStrength, Room room, int maxGold)
	{
		Random randomGenerator = new Random();
		int randomLife = randomGenerator.nextInt(maxLife-1)+1;
		int randomStrength = randomGenerator.nextInt(maxStrength-1)+1;
		int randomGold = randomGenerator.nextInt(maxGold-1)+1;
		return new Monster (randomLife,randomStrength,room,randomGold);
	}
	
	/**
	 * Generate a monster with some predefined characteristics (1-20 lifepoints, 1-3 strengthpoints, 1-20 golds)
	 * @param room the room to put the monster in 
	 * @return a random monster with some predefined characteristics
	 */
	public static Monster generateRandomMonster(Room room)
	{
		return generateRandomMonster (20,3,room,20);
	}
	
	
	/**
	 * Generate a random item
	 * @param maxLife the max life of a life potion
	 * @param maxStrength the maximum strength of a strenght potion
	 * @param maxGold the maximum gold of a gold pouch 
	 * @return a random item
	 */
	public static Item generateRandomItem(int maxLife, int maxStrength, int maxGold)
	{
		Random randomGenerator = new Random();
		int randomLife = randomGenerator.nextInt(maxLife-1)+1;
		int randomStrength = randomGenerator.nextInt(maxStrength-1)+1;
		int randomGold = randomGenerator.nextInt(maxGold-1)+1;
		
		List <Item> allItems = new ArrayList<Item>();
		Item lifePotion = new LifePotion (randomLife);
		Item strengthPotion = new StrengthPotion (randomStrength);
		Item oneArmedBandit = new OneArmedBandit (randomGold);
		
		allItems.add(lifePotion);
		allItems.add(oneArmedBandit);
		allItems.add(strengthPotion);
		int randomItem = randomGenerator.nextInt(allItems.size());
		return allItems.get(randomItem);
	}
	
	/**
	 * Generate a item with some predefined characteristics (1-10 lifepoints, 1-3 strengthpoints, 1-50 golds)
	 * @return a item with some predefined characteristics
	 */
	public static Item generateRandomItem()
	{
		return generateRandomItem (10,3,50);
	}
	
	
	/**
	 * Generate a random room (monster, item,neighbors)
	 * @param numberOfMonsters the number of monsters to be added in the room
	 * @param numberOfItems the number of items to be added in the room
	 * @param numberOfNeighbors the number of neighbors of the room
	 * @return a random room
	 */
	public static Room generateRandomRoom (int numberOfMonsters, int numberOfItems, int numberOfNeighbors)
	{
		
		List <Direction> allDirections = new ArrayList <Direction>();
		allDirections.add(Direction.N);
		allDirections.add(Direction.S);
		allDirections.add(Direction.E);
		allDirections.add(Direction.W);
		Iterator <Direction> it = allDirections.iterator();
		
		Room randomRoom = new Room();
		while (numberOfMonsters > 0)
		{
			randomRoom.addMonster(RandomGenerator.generateRandomMonster(randomRoom));			
			numberOfMonsters --;
		}
		
		while (numberOfItems > 0)
		{
			randomRoom.addItem(RandomGenerator.generateRandomItem());			
			numberOfItems --;
		}
		
		while (numberOfNeighbors > 0)
		{
			randomRoom.addNeighbors(it.next(), generateRandomRoom(numberOfMonsters,numberOfItems));	
			numberOfNeighbors --;
		}
		
		
		return randomRoom;
	}
	
	/**
	 * Generate a random room without neighbors(monster, item,neighbors)
	 * @param numberOfMonsters the number of monsters to be added in the room
	 * @param numberOfItems the number of items to be added in the room
	 * @return a random without neighbors
	 */
	public static Room generateRandomRoom (int numberOfMonsters, int numberOfItems)
	{
		
		return generateRandomRoom (numberOfMonsters, numberOfItems, 0);
	}

}
