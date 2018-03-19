package fil.coo.pool;
/**
 * A class to represent a resource user
 * @author DEROISSART Maxime, SASU Daniel
 * @param <R> a resource object 
 */
public class ResourceUser<R extends Resource> {
	
	protected R resource;
	
	/**
	 * Returns the resource taken by this user
	 * @return the resource taken by this user
	 */
	public R getResource(){
		return this.resource;
	}
	
	/**
	 * Affects a resource to this user/the user takes
	 * a resource.
	 * @param resource a resource object
	 */
	public void setResource(R resource){
		this.resource = resource;
	}
	
	/**
	 * Takes the resource from this user,
	 * as a result of this method this users resource
	 * becomes null
	 */
	public void resetResource(){
		this.resource = null;
	}

}
