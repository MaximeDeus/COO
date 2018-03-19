package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public abstract class ActionTest {
	
	protected Action action;
	protected Room emptyRoom;
	protected Monster randomMonster;
	protected Item randomItem;
	protected Player player;
	
	public abstract Action createAction();

	@Before
	public void setUp() {
		emptyRoom = RandomGenerator.generateRandomRoom(0,0,1);
		player = new Player(emptyRoom);
		action = this.createAction();
		randomMonster = RandomGenerator.generateRandomMonster(this.emptyRoom);
		randomItem = RandomGenerator.generateRandomItem();
	}

}
