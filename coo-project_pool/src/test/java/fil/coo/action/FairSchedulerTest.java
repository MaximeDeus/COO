package fil.coo.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.pool.*;

public class FairSchedulerTest extends ActionTest {


	public Action createAction(int timeRemaining) {
		ResourcePool<Cubicle> res = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		Scheduler fairScheduler = new FairScheduler(timeRemaining);
		fairScheduler.addAction(new TakeResourceAction<Cubicle>(res, user));
		fairScheduler.addAction(new ForseeableAction(timeRemaining));
		return fairScheduler;
	}
	
	
	@Test
	public void testAddNormal() {
		FairScheduler s = (FairScheduler)this.action;
		
		int nbActions = s.getActions().size();
		assertEquals(nbActions, s.getActions().size());
		s.addAction(new ForseeableAction(10));
		assertEquals(nbActions + 1, s.getActions().size());
	}
	
	
	@Test(expected=SchedulerStartedException.class)
	public void testAddException() {
		FairScheduler s = (FairScheduler)this.action;
		s.doStep();
		assertEquals(ActionState.IN_PROGRESS, s.getState());
		s.addAction(new ForseeableAction(10));
	}
	
	
	@Test
	public void fairAdvanceTest() {
		int nextIndex;
		FairScheduler s = (FairScheduler)this.action;
		while(!s.isFinished()) {
			nextIndex = s.getNextActionIndex();
			s.doStep();
			if(!s.getActions().isEmpty()) { /* avoiding index out of bounds*/
				assertEquals(ActionState.IN_PROGRESS, s.getActions().get(nextIndex).getState());
			}
		}
		assertEquals(ActionState.FINISHED, s.getState());

	}
}
