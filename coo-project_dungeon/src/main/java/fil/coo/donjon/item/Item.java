package fil.coo.donjon.item;

import fil.coo.donjon.character.*;

/**
 * An interface for the objects/collectibles found in the dungeon.
 * They have to define the effects applied and if they've been used or not
 * @author DEROISSART / SASU
 *
 */

public interface Item {
	
	
	/**
	 * Applies the effect of an object. For example, a potion used by a Character restore his lifepoint
	 * @param dc a character who uses this item
	 */
	public void use (DungeonCharacter dc);
	
	/**
	 * Returns the string representation of this item
	 * @return the string representation of this item
	 */
	public String toString();
	
	/**
	 * Prints the item description
	 */
	public void DescribesItem();

}
