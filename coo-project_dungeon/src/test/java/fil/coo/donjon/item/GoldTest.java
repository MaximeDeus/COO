package fil.coo.donjon.item;

import fil.coo.donjon.*;
import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;

public class GoldTest extends ItemTest {
	
	@Test
	public void testEffect(){
		this.it = new Gold(100);
		this.room.addItem(it);
		this.room.getAllItems().get(0).use(this.pl);
		assertEquals(100, this.pl.getGold().getQuantity());
		assertFalse(this.room.getAllItems().contains(it));
	}
}
 