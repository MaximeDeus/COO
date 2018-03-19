	package fil.coo.donjon.action;

import fil.coo.donjon.character.*;

/**
 * Action interface
 * An action must have a test (if the player can use or not this action), an execution and a description
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public interface Action {

	/**
	 * Check if the player can use this action
	 * @param p a player who can
	 * @return <code>true</code> if the action is possible, <code>false</code> if not 
	 */
	public boolean isPossible(Player p);
	/**
	 * Apply effect of this action
	 * @param p the player who executes this action
	 */
	public void execute(Player p);
	/**
	 * Describe action
	 */
	public void DescribesAction();
	/**
	 * Returnts the string representation of this object
	 * @return the string representation of this object
	 */
	public String toString();
}

