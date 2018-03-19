package fil.coo.core;

import static org.junit.Assert.*;


import java.io.File;
import java.io.FilenameFilter;
import org.junit.Before;
import org.junit.Test;

public class PluginFilterTest {
	
	private File dir;
	private FilenameFilter filter = new PluginFilter();

	@Before
	public void setUp(){
		this.dir  = new File("plugins_test/");
	}

	@Test
	public void testOK() {
		assertTrue(this.filter.accept(this.dir, "ToUpperCase.class"));
	}
	
	
	@Test
	public void testNotExistingFile() {
		assertFalse(this.filter.accept(this.dir, "notexistingfile"));
	}
	
	@Test
	public void testTextFile() {
		assertFalse(this.filter.accept(this.dir, "simple_file.txt"));
	}
	
	@Test
	public void testNotValidClassFile() {
		assertFalse(this.filter.accept(this.dir, "CesarCode.class"));
	}

}

