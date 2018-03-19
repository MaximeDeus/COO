package fil.coo.exercices;

import java.io.File;
import java.io.FilenameFilter;

public class BeginsWithC implements FilenameFilter {

	public boolean accept(File dir, String name) {
		return name.charAt(0) == 'C';
	}

}
