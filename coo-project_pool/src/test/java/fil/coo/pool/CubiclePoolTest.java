package fil.coo.pool;

public class CubiclePoolTest extends ResourcePoolTest {

	
	public void createVariables() {
		this.pool = new CubiclePool(1);
		this.zeroPool = new CubiclePool(0);
		this.r = new Cubicle();
	}

}
