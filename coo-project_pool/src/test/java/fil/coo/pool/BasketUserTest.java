package fil.coo.pool;

public class BasketUserTest extends ResourceUserTest<Basket> {

	protected void createResourceUser() {
		this.user = new ResourceUser<Basket>();
		this.res = new Basket();
		this.res2 = new Basket();
		this.user.setResource(res);
	}

}
