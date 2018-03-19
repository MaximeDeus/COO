package fil.coo.donjon.item;
import fil.coo.donjon.character.*;

/**
 * Type of potion
 * Restore player's lifepoint.
 * @author DEROISSART / SASU
 *
 */

public class LifePotion extends Potion {

	//CONSTRUCTEURS
	
	public LifePotion (int lifePoints){
		super(lifePoints);
	}

	public LifePotion (){
		super();
	}
	
	//METHODES
	
	/**
	 * Use lifepotion 
	 */
	public void use(DungeonCharacter dc){
		dc.addLifePoints(this.points);
		dc.getRoom().removeItem(this);
	}
	
	public String toString() {
		return " Lifepotion : " + this.points + " life points";
	}
}
