package fil.coo.pool;

import java.util.*;

/**
 * A class representing a resource pool
 * @author DEROISSART Maxime, SASU Daniel
 * @param <T> a Resource type object
 */


public abstract class ResourcePool<T extends Resource>{
	protected List<T> availableRes; // available resources 
	protected List<T> busyRes; // taken/busy resources
	
	/**
	 * Create a new resource of type T
	 * @return a resource of type T
	 */
	public abstract T createResource();
	
	/**
	 * Creating a resource pool filled with resources of type T
	 * @param nbResources the number of the resources in the pool to be created
	 */
	public ResourcePool(int nbResources){
		this.availableRes = new ArrayList<T>();
		this.busyRes = new ArrayList<T>();
		for(int i = 0; i < nbResources; i++){
			this.availableRes.add(this.createResource());
		}
	}

	/**
	 * Returns the number of available resources
	 * @return the number of available resources
	 */
	public int getNbAvailableResources(){
		return this.availableRes.size();
	}
	
	
	/**
	 * Returns the number of busy resources
	 * @return the number of busy resources
	 */
	public int getNbBusyResources(){
		return this.busyRes.size();
	}
	
	
	/**
	 * Provides a resource and puts it in the busy list
	 * @return a resource
	 * @throws NoSuchElementException if there are no available resources
	 */
	public T provideResource() throws NoSuchElementException {
		T res;
		if(this.getNbAvailableResources() == 0){
			throw new NoSuchElementException();
		}else{
			res = this.availableRes.get(0);
			this.busyRes.add(res);
			this.availableRes.remove(res);
			return res;
		}
	}
	
	/**
	 * Recovers a resource and puts it in the avaliable list 
	 * @param res resource to be recovered
	 * @throws IllegalStateException if there are no resources to be recovered or the resource was
	 * 			not generated in this pool
	 */
	public void recoverResource(T res) throws IllegalArgumentException{
		if(!this.busyRes.contains(res)){
			throw new IllegalArgumentException();
		} else{
			this.availableRes.add(res);
			this.busyRes.remove(res);
		}
	}
}
