package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public class LookActionTest extends ActionTest {

	public Action createAction()
	{
		return new LookAction();
	}
	
	@Test
	public void isPossibleTest()
	{
		assertTrue(action.isPossible(player));
	}

}
