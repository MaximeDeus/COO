package fil.coo.donjon.room;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.tools.*;

public abstract class RoomTest {
	
	public abstract Room createEmptyRoom();
	
	protected Room emptyRoom;
	protected Room notAnEmptyRoom;
	protected Monster randomMonster;
	protected Item randomItem;
	protected Player playerInTheEmptyRoom;
	protected Player playerNotInTheEmptyRoom;

	@Before
	public void setUp() {
		emptyRoom = this.createEmptyRoom();
		playerInTheEmptyRoom = new Player(emptyRoom);
		notAnEmptyRoom = RandomGenerator.generateRandomRoom( 1,1,1);
		playerNotInTheEmptyRoom = new Player (notAnEmptyRoom);
		randomMonster = RandomGenerator.generateRandomMonster(this.notAnEmptyRoom);
		randomItem = RandomGenerator.generateRandomItem();
	}
	
	@Test
	public void getNumberTest()
	{
		assertEquals (emptyRoom.getNumber()+1,notAnEmptyRoom.getNumber());
	}
	
	@Test
	public void isExitTest()
	{
		if (emptyRoom instanceof ExitRoom)
		{
			assertTrue(emptyRoom.isExit());
		}
		assertFalse(notAnEmptyRoom.isExit());
	}
	
	@Test
	public void getAllMonstersTest()
	{
		assertTrue (emptyRoom.getAllMonsters().isEmpty());
		assertFalse (notAnEmptyRoom.getAllMonsters().isEmpty());
		emptyRoom.addMonster(randomMonster);
		assertFalse (emptyRoom.getAllMonsters().isEmpty());
		emptyRoom.addMonster(randomMonster);
		assertEquals(emptyRoom.getAllMonsters().get(0),emptyRoom.getAllMonsters().get(1));
		assertEquals(2, emptyRoom.getAllMonsters().size());	
	}
	
	@Test
	public void addMonsterTest()
	{
		assertTrue (emptyRoom.getAllMonsters().isEmpty());
		emptyRoom.addMonster(randomMonster);
		assertFalse (emptyRoom.getAllMonsters().isEmpty());
		assertEquals(1, emptyRoom.getAllMonsters().size());	
	}
	
	@Test
	public void removeMonsterTest()
	{
		
		assertTrue (emptyRoom.getAllMonsters().isEmpty());
		emptyRoom.addMonster(randomMonster);
		assertFalse (emptyRoom.getAllMonsters().isEmpty());
		assertEquals(1, emptyRoom.getAllMonsters().size());	
		emptyRoom.removeMonster(randomMonster);
		assertTrue (emptyRoom.getAllMonsters().isEmpty());
	}
	
	@Test
	public void getAllItemsTest()
	{
		assertTrue (emptyRoom.getAllItems().isEmpty());
		assertFalse (notAnEmptyRoom.getAllItems().isEmpty());
		emptyRoom.addItem(randomItem);
		assertFalse (emptyRoom.getAllItems().isEmpty());
		emptyRoom.addItem(randomItem);
		assertEquals(emptyRoom.getAllItems().get(0),emptyRoom.getAllItems().get(1));
		assertEquals(2, emptyRoom.getAllItems().size());	
	}
	
	@Test
	public void addItemTest()
	{
		assertTrue (emptyRoom.getAllItems().isEmpty());
		emptyRoom.addItem(randomItem);
		assertFalse (emptyRoom.getAllItems().isEmpty());
		assertEquals(1, emptyRoom.getAllItems().size());	
	}
	
	@Test
	public void removeItemTest()
	{
		
		assertTrue (emptyRoom.getAllItems().isEmpty());
		emptyRoom.addItem(randomItem);
		assertFalse (emptyRoom.getAllItems().isEmpty());
		assertEquals(1, emptyRoom.getAllItems().size());	
		emptyRoom.removeItem(randomItem);
		assertTrue (emptyRoom.getAllItems().isEmpty());
	}
	
	@Test
	public void getNeighborsTest()
	{
		assertTrue(emptyRoom.getNeighbors().isEmpty());
		Room roomWithTwoNeighbors = RandomGenerator.generateRandomRoom(0, 0, 2);
		assertEquals(2,roomWithTwoNeighbors.getNeighbors().size());
		assertTrue(roomWithTwoNeighbors.getNeighbors().keySet().contains(Direction.N));
		assertTrue(roomWithTwoNeighbors.getNeighbors().keySet().contains(Direction.S));
	}
	
	@Test
	public void addNeighBorsTest()
	{
		Room firstRoom = new Room ();
		Room secondRoom = new Room ();
		assertTrue(firstRoom.neighbours.isEmpty());
		firstRoom.addNeighbors(Direction.N, secondRoom);
		assertEquals(firstRoom.changeRoom(Direction.N), secondRoom);
		assertEquals(secondRoom.changeRoom(Direction.S),firstRoom);
	}
	
	@Test
	public void getPossibleDirectionTest()
	{
		emptyRoom.addNeighbors(Direction.E, notAnEmptyRoom);
		assertTrue(emptyRoom.getPossibleDirection().contains(Direction.E));
		assertTrue(notAnEmptyRoom.getPossibleDirection().contains(Direction.W));
	}
	
	@Test
	public void isThereAMonsterTest()
	{
		assertFalse(emptyRoom.isThereAMonster());
		emptyRoom.addMonster(randomMonster);
		assertTrue(emptyRoom.isThereAMonster());
	}
	
	@Test
	public void isThereAnItemTest()
	{
		assertFalse(emptyRoom.isThereAnItem());
		emptyRoom.addItem(randomItem);
		assertTrue(emptyRoom.isThereAnItem());
	}
	
	
	
	
	
	
	
}
