package fil.coo.donjon.action;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.character.*;
import java.util.*;

/**
 * LookAction
 * Display the room's state
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class LookAction implements Action {
	 
	//METHODES
	
	/**
	  * Player can always use this action
	  * @return true
	  */
	public boolean isPossible(Player p) {
		return true;

	}
	
	/**
	 * Display a category of the elements in the room (monster, items..)
	 * @param element a list of elements 
	 */
	public static void display (List <?> element)
	{
		int index = 0;
		Iterator <?> Itelement = element.iterator();
		{
			while (Itelement.hasNext())
			{
				System.out.println(index + Itelement.next().toString());
				index++;
			}
		}
	}


	public void execute(Player p) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Room currentRoom = p.getRoom();
		System.out.println(currentRoom.toString());
		System.out.println(p.toString());
		System.out.println("========= THE ROOM CONTAINS: ===========");
		List <Monster> allMonsters = currentRoom.getAllMonsters();
		LookAction.display(allMonsters);
		List <Item> allItems = currentRoom.getAllItems();
		LookAction.display(allItems);
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		}
	
	/**
	 * Describes the action effect
	 */
	public void DescribesAction()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return " LookAction : Describes the room ";
	}
		

	
	}