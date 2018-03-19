package fil.coo.donjon.action;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.tools.*;
import fil.coo.donjon.tools.ScannerInt;

import java.util.*;

/**
 * UseAction
 * Use an item of the room
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class UseAction implements Action {

	//METHODES

	public boolean isPossible(Player p) {
		
		return p.getRoom().isThereAnItem();
	}
	

	public void execute(Player p) {
		if (isPossible(p))
		{
		System.out.println("Choose an item");
		int indexSelectedItem = ScannerInt.readInt(p.getRoom().getAllItems().size());
		Item selectedItem = p.getRoom().getAllItems().get(indexSelectedItem);
		selectedItem.use(p);
		p.getRoom().removeItem(selectedItem);
		}
		else
		{
			System.out.println("There's no item left in this room !");
		}
		
	

	}
	

	public void DescribesAction()
	{
		System.out.println(this.toString());
	}
	
	public String toString() {
		return " UseAction : Use an item";
	}

}
