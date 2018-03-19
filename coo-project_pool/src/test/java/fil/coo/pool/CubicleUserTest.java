package fil.coo.pool;

public class CubicleUserTest extends ResourceUserTest<Cubicle> {

	public void createResourceUser(){
		this.user = new ResourceUser<Cubicle>();
		this.res = new Cubicle();
		this.res2 = new Cubicle();
		this.user.setResource(res);
	}
}
