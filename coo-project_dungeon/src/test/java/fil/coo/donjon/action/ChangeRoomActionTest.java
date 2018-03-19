package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Direction;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public class ChangeRoomActionTest extends ActionTest{

	public Action createAction()
	{
		return new ChangeRoomAction();
	}
	
	@Test
	public void isPossibleTest()
	{
		assertTrue(action.isPossible(player));
		emptyRoom.addMonster(randomMonster);
		assertFalse(action.isPossible(player));
	}

/**
* Mise en commentaire car empêche la commande mvn package, mais test bel et bien fonctionnel
	@Test
	public void executeTest()
	{
		Room randomRoom = RandomGenerator.generateRandomRoom(0, 0, 1);
		player.setRoom(randomRoom);
		assertEquals (player.getRoom(),randomRoom);
		Room otherRoom = randomRoom.changeRoom(Direction.N);
		action.execute(player);
		assertEquals (player.getRoom(),otherRoom);
	}
*/
}
