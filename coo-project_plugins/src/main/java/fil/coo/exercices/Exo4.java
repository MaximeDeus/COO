package fil.coo.exercices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import javax.swing.Timer;

public class Exo4 {

	public static class Wrapper implements ActionListener{
		FileChecker fCheck;
		
		public Wrapper(FileChecker fc) {
			this.fCheck = fc;
		}
		public void actionPerformed(ActionEvent e) {
			this.fCheck.scanFolder();
		}
	}
	
	public static void main(String[] args) {
		FilenameFilter classFilter = new PluginFilter();
		FileChecker fCheck = new FileChecker(classFilter, args[0]);
		FileListener observer = new PluginObserver();
		fCheck.addEventListener(observer);
		Timer t = new Timer(1000, (ActionListener) new Wrapper(fCheck) );
		t.start();	
		while(true);
	}
}
