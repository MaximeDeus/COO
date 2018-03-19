package fil.coo.donjon.item;

import org.junit.*;
import static org.junit.Assert.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.*;

public abstract class PotionTest {
	
	Potion p_default_10_points;
	Potion p_10_points;
	public abstract Potion createPotion(int i);
	public abstract Potion createPotion();
	
	@Before
	public void setUp() {
		this.p_default_10_points = this.createPotion();
		this.p_10_points = this.createPotion (10);
	}
	
	@Test
	public void PotionCreationTest()
	{
		assertNotNull (p_default_10_points);
		assertEquals(p_default_10_points, p_10_points);
		
	}
		
}
