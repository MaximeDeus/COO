package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public class RestActionTest extends ActionTest {

	public Action createAction()
	{
		return new RestAction();
	}
	
	@Test
	public void isPossibleTest()
	{

		assertTrue(action.isPossible(player));
		action.execute(player);
		assertTrue(action.isPossible(player));

		
	}
	
	@Test
	public void executeTest()
	{
		player.addAction(action);
		assertTrue(30 == player.getLifePoints());
		action.execute(player);
		action.execute(player);
		action.execute(player);
		assertTrue(30 < player.getLifePoints());
		
	}

	

}
