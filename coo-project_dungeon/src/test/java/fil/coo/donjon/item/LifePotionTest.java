package fil.coo.donjon.item;

import org.junit.*;
import static org.junit.Assert.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.*;

public class LifePotionTest extends PotionTest {

	public Potion createPotion(int i)
	{
		return new LifePotion(i);
	}
	
	public Potion createPotion()
	{
		return new LifePotion(10);
	}
	

}
