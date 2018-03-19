package fil.coo.exercices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Exo1 {
	public static class ShowTime implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println(java.util.Calendar.getInstance().getTime().toString());
		}
	}
	
	public static void main(String[] args) {
		Timer t = new Timer(1000, new ShowTime());
		t.start();
		while(true);
	}
}
