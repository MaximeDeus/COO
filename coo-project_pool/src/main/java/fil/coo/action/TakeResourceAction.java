package fil.coo.action;

import java.util.NoSuchElementException;

import fil.coo.pool.*;

/**
 * An action that takes a resource from the resource pool <code>pool</code>*
 * and assigns it to the user <code>user</code>
 * @author DEROISSART Maxime, SASU Daniel
 *
 * @param <R> a Resource type
 */
public class TakeResourceAction<R extends Resource> extends Action {
	
	protected ResourcePool<R> resourcePool;
	protected ResourceUser<R> resourceUser;

	
	public TakeResourceAction(ResourcePool<R> pool, ResourceUser<R> user){
		super(1);
		this.resourcePool = pool;
		this.resourceUser = user;
	}
	
	
	public void stepEffect() {
		try {
			R resource = this.resourcePool.provideResource();
			this.resourceUser.setResource(resource);
			System.out.println(" ...success");
		} catch(NoSuchElementException e) {
			System.out.println(" ...failure");
		}

	}

	public boolean stopCondition() {
		return this.resourceUser.getResource() != null;
	}

}
