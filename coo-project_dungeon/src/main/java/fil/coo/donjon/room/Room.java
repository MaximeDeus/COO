package fil.coo.donjon.room;

import java.util.*;
import java.util.Random;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.tools.*;

/**
 * Room of the dungeon game
 * it's characterized by all entities inside, and the possibles directions
 * @author DEROISSART / SASU
 *
 */

public class Room {
	
	//ATTRIBUTS
	
	protected List <Monster> allMonsters;
	protected List <Item> allItems;
	protected Map <Direction,Room> neighbours;
	protected int roomNumber;
	protected static int NumberOfRooms = 0;
	
	//CONSTRUCTEUR
	
	public Room()
	{
		this.allMonsters = new ArrayList <Monster>();
		this.allItems = new ArrayList <Item>();
		this.neighbours = new HashMap <Direction,Room>();
		this.roomNumber = NumberOfRooms;
		Room.NumberOfRooms++;
	}
	
	//METHODES
	
	/**
	 * Return the room's number
	 * @return the room's number
	 */
	public int getNumber()
	{
		return this.roomNumber;
	}
	
	/**
	 * Check if it is an Exit (only ExitRoom is an exit)
	 * @return false;
	 */
	public boolean isExit()
	{
		return false;
	}

	/**
	 * Return the list of all monsters in the room
	 * @return the list of all monsters in the room
	 */
	public List<Monster> getAllMonsters() {
		return allMonsters;
	}


	/**
	 * Add a monster in the room
	 * @param m the monster to be added
	 */
	public void addMonster (Monster m) {
		this.allMonsters.add(m);
		m.setRoom(this);
	}
	
	/**
	 * Remove a monster in the room
	 * @param m the monster to be removed
	 */
	public void removeMonster (Monster m) {
		this.allMonsters.remove(m);
	}

	/**
	 * Return the list of all items in the room
	 * @return the list of all items in the room
	 */
	public List<Item> getAllItems() {
		return allItems;
	}

	/**
	 * Add an item in the room
	 * @param i the item to be added
	 */
	public void addItem(Item i) {
		this.allItems.add(i);
	}
	
	/**
	 * Remove an item in the room
	 * @param i the item to be removed
	 */
	public void removeItem(Item i) {
		this.allItems.remove(i);
	}

	/**
	 * Get all neighbors of the room
	 * @return all neighbors of the room
	 */
	public Map<Direction, Room> getNeighbors() {
		return neighbours;
	}

	/**
	 * Add a neighbors in the room
	 * @param d the direction of the room
	 * @param r the room to be added
	 */
	public void addNeighbors(Direction d, Room r) {
		this.neighbours.put(d,r);
		r.neighbours.put(d.getOppositeDirection(),this);
	}
	
	/**
	 * Return a neighbor room
	 * @param direction the direction of the next room
	 * @return a neighbor room
	 */
	public Room changeRoom(Direction direction) throws WrongDirectionException
	{
		if (!this.getPossibleDirection().contains(direction))	
		{
			throw new WrongDirectionException ("This direction is not valid");
		}
		else
		{
			return this.neighbours.get(direction);
		}
	}
	
	/**
	 * Return all possibles directions of the room
	 * @return all possibles directions of the room
	 */
	public Set<Direction> getPossibleDirection()
	{
		return this.neighbours.keySet();	
	}
	
	/**
	 * Return true if there's a monster in the room
	 * @return true if there's a monster in the room
	 */
	public boolean isThereAMonster()
	{
		return (!this.allMonsters.isEmpty());
	}
	
	/**
	 * Return true if there's an item in the room
	 * @return true if there's an item in the room
	 */
	public boolean isThereAnItem()
	{
		return (!this.allItems.isEmpty());
	}
	
	public String toString() {
		return "Room "+ roomNumber;
	}	
	
	/**
	 * Describes the room
	 */
	public void displayRoom()
	{
		System.out.println(this.toString());
		System.out.println("\nAll monsters :");
		int index = 0;
		
		for (Monster m : this.getAllMonsters())
		{
			System.out.print(index + " ");
			m.DescribesEntity();
			index ++;
		}
		index = 0;
		
		System.out.println("\nAll items :");
		
		for (Item i : this.getAllItems())
		{
			System.out.print(index + " " );
			i.DescribesItem();
			index ++;
		}
		index = 0;
		
		System.out.println("\nAll Directions :");
		
		for (Direction d : this.getPossibleDirection())
		{
			System.out.print(index + " " );
			d.DescribesDirection();
			index ++;
		}
		
		System.out.println("\n");
	}
}
