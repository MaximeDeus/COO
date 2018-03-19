package fil.coo.action;

import fil.coo.pool.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SequentialSchedulerTest extends ActionTest {

	
	
	public Action createAction(int timeRemaining) {
		ResourcePool<Cubicle> res = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		Scheduler seqScheduler = new SequentialScheduler(timeRemaining);
		seqScheduler.addAction(new TakeResourceAction<Cubicle>(res, user));
		seqScheduler.addAction(new ForseeableAction(timeRemaining));
		return seqScheduler;
	}
	
	@Test
	public void testAddNormal() {
		SequentialScheduler s = (SequentialScheduler)this.action;
		
		int nbActions = s.getActions().size();
		assertEquals(nbActions, s.getActions().size());
		s.addAction(new ForseeableAction(10));
		assertEquals(nbActions + 1, s.getActions().size());
	}
	
	@Test(expected=SchedulerStartedException.class)
	public void testAddException() {
		SequentialScheduler s = (SequentialScheduler)this.action;
		s.doStep();
		assertEquals(ActionState.IN_PROGRESS, s.getState());
		s.addAction(new ForseeableAction(10));
	}

}
