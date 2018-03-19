package fil.coo.exercices;

import java.io.File;
import java.io.FilenameFilter;

public class Exo2 {
	public static void main(String[] args) {
		String[] list;
		
		FilenameFilter cFilter= new BeginsWithC();
		FilenameFilter classFilter= new ClassFiles();
		
		File dir = new File(args[0]);
		list = dir.list(cFilter);
		System.out.println("");
		System.out.println(" ---- Files that begin with C: ----");
		for(String s: list) {
			System.out.println(s);
		}
		
		System.out.println("");
		System.out.println(" ---- Files that begin with .class: ----");
		list = dir.list(classFilter);
		for(String s: list) {
			System.out.println(s);
		}
	}
}
