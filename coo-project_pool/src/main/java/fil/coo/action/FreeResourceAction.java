package fil.coo.action;

import fil.coo.pool.*;

/**
 * An action that takes the resource from the user and 
 * puts it back in the pool, making it available for use
 * @author DEROISSART Maxime, SASU Daniel
 * @param <R> a Resource type
 */
public class FreeResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> resourcePool;
	protected ResourceUser<R> resourceUser;
	
	public FreeResourceAction(ResourcePool<R> pool, ResourceUser<R> user){
		super(1);
		this.resourcePool = pool;
		this.resourceUser = user;
	}
	

	public void stepEffect() {
		R resource = this.resourceUser.getResource();
		this.resourcePool.recoverResource(resource);
		this.resourceUser.resetResource();
	}

	public boolean stopCondition() {
		return this.resourceUser.getResource() == null;
	}

}
