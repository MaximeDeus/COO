package fil.coo.donjon.item;
import fil.coo.donjon.character.*;

/**
 * Type of potion
 * Increase player's strength.
 * @author DEROISSART / SASU
 *
 */

public class StrengthPotion extends Potion {

	//CONSTRUCTEURS
	
	public StrengthPotion (int StrengthPoints){
		super(StrengthPoints);
	}
	
	public StrengthPotion (){
		super();
	}

	//METHODES 
	
	/**
	 * Use strengthpotion 
	 */
	public void use(DungeonCharacter dc){
		dc.addStrengthPoints(this.points);
		dc.getRoom().removeItem(this);
	}

	public String toString() {
		return " StrengthPotion : " + this.points + " strength points";
	}
}