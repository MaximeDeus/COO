package fil.coo.exercices;

import java.io.File;
import java.io.FilenameFilter;

public class ClassFiles implements FilenameFilter {

	public boolean accept(File dir, String name) {
		return name.endsWith(".class");
	}

}
