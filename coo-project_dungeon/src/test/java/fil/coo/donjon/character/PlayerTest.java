package fil.coo.donjon.character;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.tools.*;
import fil.coo.donjon.room.*;

public class PlayerTest extends DungeonCharacterTest {
	
	protected Player normalPlayer;


	public Player createCharacterWithAllCharacteristicsAt0()
	{
		return new Player (0,0,super.emptyRoom,0);
	}

	public Player createCharacter() {
	return new Player (100,10,super.emptyRoom,50);
	}
	
	@Before
	public void init()
	{
		normalPlayer = this.createCharacter();
	}
	
	@Test
	public void changeRoomTest()
	{
		Room roomA = RandomGenerator.generateRandomRoom(0, 0, 1);
		Room roomB = roomA.changeRoom(Direction.N);
		normalPlayer.setRoom(roomA);
		assertEquals(roomA,normalPlayer.getRoom());	
		normalPlayer.changeRoom(Direction.N);	
		assertEquals(roomB,normalPlayer.getRoom());
	}

}
