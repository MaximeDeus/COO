package fil.coo.action;
import fil.coo.pool.*;


public class TakeResourceActionTest extends ActionTest {
	
	public Action createAction(int timeRemaining) {
		ResourcePool<Cubicle> res = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		return new TakeResourceAction<Cubicle>(res, user);
	}
}
