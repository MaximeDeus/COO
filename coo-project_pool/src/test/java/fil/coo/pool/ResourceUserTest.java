package fil.coo.pool;

import org.junit.*;
import static org.junit.Assert.*;


public abstract class ResourceUserTest<T extends Resource>{
	
	protected ResourceUser<T> user;
	protected T res;
	protected T res2;
	
	protected abstract void createResourceUser();
	
	@Before
	public void setUp(){
		createResourceUser();
	}
	
	@Test
	public void testInit(){
		assertNotNull(user);
	}
	
	@Test
	public void testGetResource(){
		assertEquals(res, user.getResource());
	}
	
	@Test
	public void testSetResource(){
		user.setResource(res2);
		assertEquals(res2, user.getResource());
	}
	
	@Test
	public void testResetResource(){
		assertNotNull(user.getResource());
		user.resetResource();
		assertNull(user.getResource());
	}
}
