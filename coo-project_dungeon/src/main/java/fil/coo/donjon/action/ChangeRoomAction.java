package fil.coo.donjon.action;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.tools.*;
import java.util.Random;
import java.util.*;

/**
 * ChangeRoomAction
 * An action that changes the room/ assignes the player to the other room
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class ChangeRoomAction implements Action {

	//METHODES
	

	public boolean isPossible(Player p) {
		
		return !p.getRoom().isThereAMonster();
	}
	


	public void execute(Player p) {
		
		Iterator <Direction> it = p.getRoom().getPossibleDirection().iterator();
		
		if (isPossible(p))
		{
			System.out.println("Choose a Direction : N=0 | S=1 | E=2 | W=3");
			int input = ScannerInt.readInt(p.getRoom().getPossibleDirection().size());
			while (input > 0)
			{
				it.next();
				input--;
			}
			p.changeRoom(it.next());
		}	
	}
	

	public void DescribesAction()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return " ChangeDirectionAction : Change Room";
	}
	


}

