package fil.coo.donjon.character;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.tools.*;

/**
 * Superclass of all entities in the game, characterized by lifepoints, strengthpoints, gold and room
 * @author DEROISSART Maxime | SASU Daniel
 */

public abstract class DungeonCharacter {
	
	//ATTRIBUTS
	
	protected int lifePoints;
	protected int strengthPoints;
	protected Gold gold;
	protected Room room;
	
	//CONTRUCTEURS
	
	public DungeonCharacter (int lifePoints, int strengthPoints, Room room, int gold)
	{
		this.lifePoints = lifePoints;
		this.strengthPoints = strengthPoints;
		this.gold = new Gold(gold);
		this.room = room;
	}
	
	public DungeonCharacter (Room room)
	{
		this.lifePoints = 30;
		this.strengthPoints = 10;
		this.gold = new Gold(100);	
		this.room = room;
	}
	
	//METHODES

	/**
	 * return lifepoints of the character
	 * @return lifepoints
	 */
	
	public int getLifePoints() {
		return lifePoints;
	}

	/**
	 * Increase lifepoints of the character
	 * @param lifePoints the amount of life points to be added
	 */
	public void addLifePoints(int lifePoints) {
		this.lifePoints += lifePoints;
		String Entityname = this.toString().substring(0, this.toString().indexOf("[")-1);
		System.out.println(Entityname + " regained " + lifePoints + " lifepoints");
	}
	
	/**
	 * Substract lifepoints of the character
	 * @param lifePoints the amount of life points to be substracted
	 */
	public void substractLifePoints(int lifePoints) {
		this.lifePoints -= lifePoints;
		String Entityname = this.toString().substring(0, this.toString().indexOf("[")-1);
		System.out.println(Entityname + " lost " + lifePoints + " lifepoints");
	}

	/**
	 * return strengthpoints of the character
	 * @return strengthpoints
	 */
	public int getStrengthPoints() {
		return strengthPoints;
	}

	/**
	 * Increase strengthpoints of the character
	 * @param strengthPoints the amount of strenght to be added 
	 */
	public void addStrengthPoints(int strengthPoints) {
		this.strengthPoints += strengthPoints;
		String Entityname = this.toString().substring(0, this.toString().indexOf("[") -1);
		System.out.println(Entityname + " regained " + strengthPoints + " strengthpoints");
	}

	/**
	 * return actual room of the character
	 * @return actual room of the character
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Change the room of the character
	 * @param room a room in which we would like to place the character
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	/**
	 * return gold of the character
	 * @return gold of the character
	 */
	public Gold getGold() {
		return this.gold;
	}

	/**
	 * Increase gold of the character
	 * @param g the gold amount to be added
	 */
	public void addGold(Gold g) {
		this.gold.addQuantity(g);
	} 
	
	/**
	 * Subtract gold of the character
	 * @param g the gold amount to be subtracted
	 */
	public void subtractGold(Gold g) {
		this.gold.subtractQuantity(g);
	} 
	
	/**
	 * Check if the character is dead
	 * @return <code>true</code> if the player is dead, <code>false</code> if not
	 */
	public boolean isDead()
	{
		return this.lifePoints <= 0;
	}
	
	
	/**
	 * Applies some effects if the character is dead
	 */
	public abstract void die(); 
	
	/**
	 * Attack an other character. If the character injured isn't dead, he'll attack too
	 * @param dc a character to be attacked
	 */
	public void attack (DungeonCharacter dc){
		dc.substractLifePoints(this.strengthPoints);
		if (dc.isDead())
		{
			dc.die();
		}
		else
		{
			this.substractLifePoints(dc.getStrengthPoints());
		}
	}
	
	/**
	 * Describe an entity
	 */
	public void DescribesEntity()
	{
		System.out.println(this.toString());
	}
}
