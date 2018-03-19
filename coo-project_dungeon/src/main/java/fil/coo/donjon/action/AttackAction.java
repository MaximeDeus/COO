package fil.coo.donjon.action;

import fil.coo.donjon.character.Player;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.tools.*;

import java.util.*;

/**
 * AttackAction
 * Attack a monster
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class AttackAction implements Action {
	
	static final Scanner scanner = new Scanner(System.in); //Input of player

	//METHODES
	
	public boolean isPossible(Player p) {
		
		return p.getRoom().isThereAMonster();
	}
	

	public void execute(Player p) {
		if (isPossible(p))
		{
		 System.out.println("Choose an enemy");
		 int input = ScannerInt.readInt(p.getRoom().getAllMonsters().size());
		 p.attack(p.getRoom().getAllMonsters().get(input));
		}
	}
	
	
	public void DescribesAction()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return " AttackAction : Attack an enemy";
	}
	
	

}
