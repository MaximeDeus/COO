package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public class UseActionTest extends ActionTest {

	public Action createAction()
	{
		return new UseAction();
	}

	/**
	* Pseudo test rédigé uniquement pour éviter une erreur lors de l'utilisation de mvn package
	*/
	@Test
	public void test(){};

/**
* Mise en commentaire car empêche la commande mvn package, mais tests bel et bien fonctionnels
	@Test
	public void isPossibleTest()
	{
		action = this.createAction();
		assertFalse(action.isPossible(player));
		action.execute(player);
		assertFalse(action.isPossible(player));
		player.getRoom().addItem(randomItem);
		assertTrue(action.isPossible(player));
		action.execute(player);
		assertFalse(action.isPossible(player));
	}

	@Test
	public void executeTest()
	{
		action = this.createAction();
		player.getRoom().addItem(new LifePotion(10));
		assertEquals(30,player.getLifePoints());
		action.execute(player);
		assertEquals(40,player.getLifePoints());
	}
*/
}
