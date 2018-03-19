package fil.coo.action;

import org.junit.*;
import static org.junit.Assert.*;

public class ForseeableActionTest extends ActionTest {
	
	protected final int time = 10;

	public Action createAction(int timeRemaining) {
		return new ForseeableAction(time);
	}
	
	@Test
	public void testCount() {
		int count = 0;
		while (!this.action.isFinished()){
			action.doStep();
			count ++;
		}
		assertEquals(time, count);
	}

}
