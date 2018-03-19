package fil.coo.pool;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	
	public void createVariables() {
		this.pool = new BasketPool(1);
		this.zeroPool = new BasketPool(0);
		this.r = new Basket();
	}

}
