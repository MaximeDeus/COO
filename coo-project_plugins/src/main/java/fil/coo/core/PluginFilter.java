package fil.coo.core;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import fil.coo.plugin.Plugin;

/**
 * A filter that accepts only plugin files.
 * Plugin files are meet following conditions:
 * 	 - it is a .class java file
 *   - implements the fil.coo.Plugin interface
 *   
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class PluginFilter implements FilenameFilter {


	public boolean accept(File dir, String name) {
		String pack = "fil.coo.plugin.";
		String filename = pack + name.replace(".class", "");
		System.out.print("Checking file: ");
		System.out.println(filename);
		
		try {
			Class<?> cls = Class.forName(filename);
			Constructor<?> cons = cls.getConstructor();
			
		if(Plugin.class.isAssignableFrom(cls)) {
			System.out.println("plugin found!");
				return true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("class not found!");
			return false;
		} catch (NoSuchMethodException e) {
			System.out.println("method not found!");
			return false;
		} catch (SecurityException e) {
			System.out.println("");
			return false;
		}
		return false;
	}

}
