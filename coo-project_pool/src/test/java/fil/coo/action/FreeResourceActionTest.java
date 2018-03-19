package fil.coo.action;

import fil.coo.pool.*;

import org.junit.*;
import static org.junit.Assert.*;


public class FreeResourceActionTest extends ActionTest {



	public Action createAction(int timeRemaining) {
		ResourcePool<Basket> res = new BasketPool(1);
		ResourceUser<Basket> user = new ResourceUser<Basket>();
		user.setResource(res.provideResource());
		return new FreeResourceAction<Basket>(res, user);
	}
}
