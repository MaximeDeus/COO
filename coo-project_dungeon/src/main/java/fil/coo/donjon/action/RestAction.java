package fil.coo.donjon.action;

import fil.coo.donjon.item.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.tools.*;
import java.util.Random;
import java.util.*;

/**
 * RestAction
 * Player can restore his lifepoints if there's no enemy left in the room
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class RestAction implements Action {


	public boolean isPossible(Player p) {
		
		return !p.getRoom().isThereAMonster();
	}
	


	public void execute(Player p) {
		if (isPossible(p))
		{
		Random randomGenerator = new Random();
		int rest = randomGenerator.nextInt(10);
		p.addLifePoints(rest);
		p.removeAction(this);
		}
	}
	

	public void DescribesAction()
	{
		System.out.println(this.toString());
	}

	public String toString() {
		return " RestAction : Rest (regain few lifePoints)";
	}
	
	

}
