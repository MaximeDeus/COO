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

public class MonsterTest extends DungeonCharacterTest {


	public Monster createCharacterWithAllCharacteristicsAt0()
	{
		return new Monster (0,0,super.emptyRoom,0);
	}

	@Override
	public DungeonCharacter createCharacter() {
	return new Monster (100,10,super.emptyRoom,50);
	}
	
	@Test
	public void dieTest()
	{
		assertTrue(emptyRoom.getAllMonsters().isEmpty());
		emptyRoom.addMonster(randomMonster);
		assertTrue(emptyRoom.getAllItems().isEmpty());
		assertFalse(emptyRoom.getAllMonsters().isEmpty());
		randomMonster.die();
		assertTrue(emptyRoom.getAllMonsters().isEmpty());
		assertFalse(emptyRoom.getAllItems().isEmpty());
		
	}

}
