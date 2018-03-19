package fil.coo.core;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class FileCheckerTest {
	
	protected FileChecker scanner;
	protected MockFileListener listener;
	protected final String testDirectory = "plugin_test";
	
	
	public class MockFileListener implements FileListener{
		protected int counter;
		
		public MockFileListener() {
			counter = 0;
		}
		
		public void fileAdded(FileEvent e){
			counter++;
		}
		
		public void fileRemoved(FileEvent e) {
			counter--;
		}
		
		public int getCounter(){
			return this.counter;
		}
	}
	
	public class MockFilenameFilter implements FilenameFilter{

		public boolean accept(File dir, String name) {
			return true;
		}
		
	}

	@Before 
	public void setUp() {
		this.scanner = new FileChecker(new MockFilenameFilter(), "plugins_test");
		this.listener = new MockFileListener();
	}
	
	
	@Test
	public void testScanFolder() {
		this.scanner.addEventListener(listener);
		File dir = new File("plugins_test");
		dir.mkdir();
		File f = new File("plugins_test/file1");
		File f2 = new File("plugins_test/file2");
		
		assertEquals(0,listener.getCounter());
		try {
			f.createNewFile();
			this.scanner.scanFolder();
			assertEquals(1,listener.getCounter());
			f2.createNewFile(); 
			this.scanner.scanFolder();
			assertEquals(2,listener.getCounter());
		} catch (IOException e) {
			e.printStackTrace();
			fail("File could not be created");
		}
		
		f.delete();
		this.scanner.scanFolder();
		assertEquals(1,listener.getCounter());
		f2.delete();
		this.scanner.scanFolder();
		assertEquals(0,listener.getCounter());
		dir.delete();
	}	
}
