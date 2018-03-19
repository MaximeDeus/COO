package fil.coo.pool;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nbResources){
		super(nbResources);
	}
	
	
	public Basket createResource() {
		return new Basket();
	}

}
