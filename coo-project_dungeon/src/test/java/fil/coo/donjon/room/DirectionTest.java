package fil.coo.donjon.room;

import org.junit.*;
import static org.junit.Assert.*;

public class DirectionTest {
	
	@Test
	public void getOppositeDirectionTest() {
		assertEquals(Direction.N.getOppositeDirection(),Direction.S);
		assertEquals(Direction.E.getOppositeDirection(),Direction.W);	
	}

}
