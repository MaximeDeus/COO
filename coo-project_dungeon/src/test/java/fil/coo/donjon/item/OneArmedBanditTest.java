package fil.coo.donjon.item;

import fil.coo.donjon.*;
import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;

public class OneArmedBanditTest extends ItemTest {
	
	@Test
	public void useTestWhenEnoughtMoney(){
		
		Gold g = new Gold(100);
		this.pl.addGold(g);
		assertEquals(100,this.pl.getGold().getQuantity());
		assertEquals(0,this.pl.getStrengthPoints()+this.pl.getLifePoints());
		this.it = new OneArmedBandit(50);
		this.room.addItem(it);
		this.room.getAllItems().get(0).use(this.pl);
		assertEquals(50, this.pl.getGold().getQuantity());
		assertEquals(10,this.pl.getStrengthPoints()+this.pl.getLifePoints());
		assertFalse(this.room.getAllItems().contains(it));
	}
	
	@Test
	public void useTestWhenNotEnoughtMoney(){
		
		Gold g = new Gold(10);
		this.pl.addGold(g);
		assertEquals(10,this.pl.getGold().getQuantity());
		assertEquals(0,this.pl.getStrengthPoints()+this.pl.getLifePoints());
		this.it = new OneArmedBandit(50);
		this.room.addItem(it);
		this.room.getAllItems().get(0).use(this.pl);
		assertEquals(10, this.pl.getGold().getQuantity());
		assertEquals(0,this.pl.getStrengthPoints()+this.pl.getLifePoints());
		assertFalse(this.room.getAllItems().contains(it));
	}

}
