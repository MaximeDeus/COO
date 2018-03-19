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

public abstract class DungeonCharacterTest {
	
	protected DungeonCharacter characterWithAllCharacteristicsAt0;
	protected DungeonCharacter normalCharacter;
	protected Room emptyRoom;
	protected Monster randomMonster;
	protected Item randomItem;
	


public abstract DungeonCharacter createCharacterWithAllCharacteristicsAt0();
public abstract DungeonCharacter createCharacter();

	@Before
	public void setUp() {
		characterWithAllCharacteristicsAt0 = this.createCharacterWithAllCharacteristicsAt0();
		normalCharacter = this.createCharacter();
		emptyRoom = RandomGenerator.generateRandomRoom( 0,0,0);
		randomMonster = RandomGenerator.generateRandomMonster(this.emptyRoom);
		randomItem = RandomGenerator.generateRandomItem();
	}
	
	@Test
	public void getLifePointTest()
	{
		assertEquals(0,characterWithAllCharacteristicsAt0.getLifePoints());
		assertEquals(100,normalCharacter.getLifePoints());
	}
	
	@Test
	public void getStrengthPointTest()
	{
		assertEquals(0,characterWithAllCharacteristicsAt0.getStrengthPoints());
		assertEquals(10,normalCharacter.getStrengthPoints());
	}
	
	@Test
	public void addStrengthPointTest()
	{
		assertEquals(0,characterWithAllCharacteristicsAt0.getStrengthPoints());
		characterWithAllCharacteristicsAt0.addStrengthPoints(10);
		assertEquals(10,characterWithAllCharacteristicsAt0.getStrengthPoints());
	}
	
	@Test
	public void getRoomTest()
	{
		assertEquals(this.randomMonster.getRoom(),this.emptyRoom);
		Room otherRoom = RandomGenerator.generateRandomRoom(2,2);
		this.randomMonster.setRoom(otherRoom);
		assertEquals(this.randomMonster.getRoom(),otherRoom);
		
	}
	
	@Test
	public void setRoomTest()
	{
		assertEquals(this.randomMonster.getRoom(),this.emptyRoom);
		Room otherRoom = RandomGenerator.generateRandomRoom(2,2);
		this.randomMonster.setRoom(otherRoom);
		assertEquals(this.randomMonster.getRoom(),otherRoom);
		
	}
	
	@Test
	public void getGoldTest()
	{
		assertEquals(0,characterWithAllCharacteristicsAt0.getGold().getQuantity());
		assertEquals(50,normalCharacter.getGold().getQuantity());
		
	}
	
	@Test
	public void addGoldTest()
	{
		assertEquals(0,characterWithAllCharacteristicsAt0.getGold().getQuantity());
		Gold fiftyCoins = new Gold(50);
		characterWithAllCharacteristicsAt0.addGold(fiftyCoins);
		assertEquals(50,characterWithAllCharacteristicsAt0.getGold().getQuantity());
	}
	
	@Test
	public void removeGoldTest()
	{
		assertEquals(50,normalCharacter.getGold().getQuantity());
		Gold fiftyCoins = new Gold(50);
		normalCharacter.subtractGold(fiftyCoins);
		assertEquals(0,normalCharacter.getGold().getQuantity());

	}
	
	@Test
	public void isDeadTest()
	{
		assertTrue(characterWithAllCharacteristicsAt0.isDead());
		assertFalse(normalCharacter.isDead());
		
	}
	
	@Test
	public void attackTest ()
	{
		characterWithAllCharacteristicsAt0.addStrengthPoints(10);
		assertEquals(100,normalCharacter.getLifePoints());
		characterWithAllCharacteristicsAt0.attack(normalCharacter);
		assertEquals(90,normalCharacter.getLifePoints());
	}
}
