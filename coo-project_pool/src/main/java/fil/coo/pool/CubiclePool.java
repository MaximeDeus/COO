package fil.coo.pool;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nbResources){
		super(nbResources);
	}
	
	public Cubicle createResource() {
		return new Cubicle();
	}

}
