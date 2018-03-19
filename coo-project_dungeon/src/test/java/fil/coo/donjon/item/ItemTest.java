package fil.coo.donjon.item;

import fil.coo.donjon.*;
import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;

public class ItemTest {
	
	protected Room room;
	protected DungeonCharacter pl;
	protected Item it;
	
	
	@Before
	public void setUp() {
		this.room = new Room();
		this.pl = new Player(0,0, room, 0);
	}

       /**
	* Pseudo test rédigé uniquement pour éviter une erreur lors de l'utilisation de mvn package
	*/
	@Test
	public void test(){};
}
