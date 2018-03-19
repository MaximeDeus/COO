package fil.coo.exercices;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import fil.coo.plugin.Plugin;


public class PluginFilter implements FilenameFilter {


	public boolean accept(File dir, String name) {
		String pack = "fil.coo.plugin.";
		String filename = pack + name.replace(".class", "");
		
		try {
			Class<?> cls = Class.forName(filename);
			Constructor<?> cons = cls.getConstructor();			
		if(Plugin.class.isAssignableFrom(cls)) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		}
		return false;
	}

}
