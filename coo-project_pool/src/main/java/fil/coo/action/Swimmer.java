package fil.coo.action;

import fil.coo.pool.*;

public class Swimmer extends SequentialScheduler {
	protected String name;
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	protected int timeUndressing;
	protected int timeSwimming;
	protected int timeDressing;
	
	public Swimmer(String name,BasketPool basketPool, CubiclePool cubiclePool, int timeUndressing, int timeSwimming, int timeDressing){
		super(1);
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeUndressing = timeUndressing;
		this.timeSwimming = timeSwimming;
		this.timeDressing = timeDressing;
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>();
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>();
		actions.add(new TakeResourceAction<Basket>(this.basketPool, basketUser));
		actions.add(new TakeResourceAction<Cubicle>(this.cubiclePool, cubicleUser));
		actions.add(new ForseeableAction(this.timeUndressing));
		actions.add(new FreeResourceAction<Cubicle>(this.cubiclePool, cubicleUser));
		actions.add(new ForseeableAction(this.timeSwimming));
		actions.add(new TakeResourceAction<Cubicle>(this.cubiclePool, cubicleUser));
		actions.add(new ForseeableAction(this.timeDressing));
		actions.add(new FreeResourceAction<Cubicle>(this.cubiclePool, cubicleUser));
		actions.add(new FreeResourceAction<Basket>(this.basketPool, basketUser));

		
	}
	
	public String toString(){
		return this.name;
	}
}
