package fil.coo.donjon.item;

import org.junit.*;
import static org.junit.Assert.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.*;

public class StrengthPotionTest extends PotionTest {

	public Potion createPotion(int i)
	{
		return new StrengthPotion(i);
	}
	
	public Potion createPotion()
	{
		return new StrengthPotion(10);
	}
}
