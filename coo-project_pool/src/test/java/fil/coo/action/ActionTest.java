package fil.coo.action;

import org.junit.*;
import static org.junit.Assert.*;



public abstract class ActionTest {

	protected Action action;
	
	public abstract Action createAction(int timeRemaining);
	
	@Before
	public void setUp(){
		this.action = createAction(10);
	}

	
	@Test
	public void testNormalProcess(){
		assertEquals(ActionState.READY, this.action.getState());
		
		while (!this.action.isFinished()){
			action.doStep();
		}
		
		assertEquals(ActionState.FINISHED, this.action.getState());
	}
	
	@Test(expected=ActionFinishedException.class)
	public void testExceptionProcess(){
		assertEquals(ActionState.READY, this.action.getState());
		
		while (!this.action.isFinished()){
			try{
				action.doStep();
			}catch(ActionFinishedException e){
				fail();
			}
		}
		assertEquals(ActionState.FINISHED, this.action.getState());
		
		// Exception expected
		action.doStep();
	}
	
}
