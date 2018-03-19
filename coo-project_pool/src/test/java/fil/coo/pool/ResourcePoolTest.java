package fil.coo.pool;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public abstract class ResourcePoolTest<T extends Resource>{
	
	protected ResourcePool<T> pool; 
	protected ResourcePool<T> zeroPool; //an empty resource pool
	protected T r;
	
	public abstract void createVariables();
	
	@Before
	public void setUp() {
		createVariables();
	}
	
	@Test
	public void testProvideResource(){
		int nbAvailableRes = pool.getNbAvailableResources();
		int nbBusyRes = pool.getNbBusyResources();
		T r1 = pool.provideResource();
		assertEquals(nbAvailableRes - 1, pool.getNbAvailableResources());
		assertEquals(nbBusyRes + 1, pool.getNbBusyResources());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testProvideResourceException() {
		T r1;
		try {
			r1 = pool.provideResource();
		}catch(NoSuchElementException e) {
			fail();
		}
		zeroPool.provideResource();
	}
	
	
	@Test
	public void testRecoverResource() {
		int nbAvailableRes = pool.getNbAvailableResources();
		int nbBusyRes = pool.getNbBusyResources();
		T r1 = pool.provideResource();
		assertEquals(nbAvailableRes - 1, pool.getNbAvailableResources());
		assertEquals(nbBusyRes + 1, pool.getNbBusyResources());
		pool.recoverResource(r1);
		nbAvailableRes = pool.getNbAvailableResources();
		nbBusyRes = pool.getNbBusyResources();
		assertEquals(1, nbAvailableRes);
		assertEquals(0, nbBusyRes);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecoverResourceException() {
		T r1 = pool.provideResource();
		try {
			pool.recoverResource(r1);
		}catch(IllegalArgumentException e) {
			fail();
		}
		zeroPool.recoverResource(r);
	}
}
