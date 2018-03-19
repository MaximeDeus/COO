package fil.coo.donjon.character;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.tools.*;
import fil.coo.donjon.action.*;
import java.util.*;

/**
 * Player class
 * @author DEROISSART Maxime | SASU Daniel
 */

public class Player extends DungeonCharacter {
	
	//ATTRIBUTS
	
	protected List<Action> allPossibleActions;

	//CONSTRUCTEURS
	
	public Player(int lifePoints, int strengthPoints, Room room, int gold) {
		super(lifePoints, strengthPoints, room, gold);
		this.allPossibleActions = new ArrayList<Action>();
		

	}
	
	public Player(Room room) {
		super(room);
		this.allPossibleActions = new ArrayList<Action>();
	}
	
	//METHODES
	
	/**
	 * Describe the player's actions
	 * @return a String with the description of the player's action
	 */
	
	public String DescribesAllPossiblesAction()
	{
		int index = 0;
		String allActions = "********** YOU CAN DO THE FOLLOWING ************\n";
		
		for (Action a : this.allPossibleActions)
		{
			allActions += index + a.toString()+"\n";
			index ++;
		}
		allActions += "************************************************\n\n\n";
		return allActions;
	}

	public String toString() {
		return "*** YOUR STATS:  [lifePoints="+lifePoints+", strengthPoints="+strengthPoints+", gold="+gold+"] *** \n"+ "\nAll possibles actions : \n" + this.DescribesAllPossiblesAction();
	}


	/**
	 * If the player is dead, end of the game
	 */
	public void die() {
		System.out.println("You died! GAME OVER.");

	}
	
	/**
	 * Move the player to another room
	 * @param direction the direction of the next room
	 */
	public void changeRoom (Direction direction)
	{
		Room nextRoom = this.room.changeRoom(direction);
		this.room = nextRoom;
	}
	
	/**
	 * Add an action to the player
	 * @param action the action to be added
	 */
	public void addAction (Action action)
	{
		if (action.isPossible(this))
		{
			this.allPossibleActions.add(action);
		}
		
	}
	
    /**
	  * Remove an action to the player
	  * @param action the action to be removed
      */
	public void removeAction (Action action)
	{
		allPossibleActions.remove(action);
	}
	
	/**
	  * Set all possible actions of the player each turn
      */
	public void setAllActions()
	{
		this.allPossibleActions.clear();
		List<Action> allActions = new ArrayList<Action>();
		allActions.add(new AttackAction());
		allActions.add(new LookAction());
		allActions.add(new RestAction());
		allActions.add(new UseAction());
		allActions.add(new ChangeRoomAction());
		Iterator <Action> it = allActions.iterator();
		while (it.hasNext())
		{
			Action action = it.next();
			this.addAction(action);
		}
		
	}
	
	/**
	  * Return all possible actions
	  * @return all possible actions
      */
	public List<Action> getAllActions()
	{
		return this.allPossibleActions;
	}
	
}
