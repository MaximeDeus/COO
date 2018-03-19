package fil.coo.donjon.item;
import fil.coo.donjon.character.*;

/**
 * Simulates in-game gold coins
 * @author DEROISSART / SASU
 */

public class Gold implements Item{
	
	//ATTRIBUTS
	
	int gold;
	
	//CONSTRUCTEURS
	
	
	public Gold (int goldQuantity){
		this.gold = goldQuantity;
	}
	
	public Gold (){
		this.gold = 100;
	}

	//METHODES
	
	/**
	 * Returns the amount of gold contained by this object
	 * @return the amount of gold contained by this object
	 */
	public int getQuantity(){
		return this.gold;
	}
	
	/**
	 * Add gold
	 * @param g the gold to be added
	 */
	public void addQuantity(Gold g){
		this.gold += g.getQuantity();
	}
	
	/**
	 * Substract gold
	 * @param g the gold to be substracted
	 */
	public void subtractQuantity(Gold g){
		this.gold -= g.getQuantity();
	}

	
	/**
	 * Adds the gold to player's "pouch"
	 * @param dc a character to be "used"
	 */
	public void use(DungeonCharacter dc){
		dc.addGold(this);
		System.out.println("You picked up " + this.toString());
		dc.getRoom().removeItem(this); // object has been used !		
	}
	
	/**
	 * Returns the string representation of the object
	 * @return the string representation of this object
	 */
	public String toString() {
		return " " + this.gold + " gold coins";
	}
	
	public void DescribesItem()
	{
		System.out.println(this.toString());
	}
	
	
}
