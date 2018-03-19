package fil.coo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

/**
 * A listener class loading a file content into 
 * a JTextArea.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class OpenFileListener implements ActionListener {
	
	private JTextArea textArea;
	
	/**
	 * Creates an instance of <code>OpenFileListener</code>
	 * @param textArea a JTextArea object to be filled with 
	 * 				   the opened file content
	 */
	public OpenFileListener(JTextArea textArea) {
		this.textArea = textArea;
	}



	public void actionPerformed(ActionEvent e) {
		StringBuffer fileToString = new StringBuffer("");
		JFileChooser nautilus = new JFileChooser();
		
		
		if (nautilus.showOpenDialog(this.textArea) == 0) {
			
			try {
				String line;
				BufferedReader buffer = new BufferedReader(new FileReader(nautilus.getSelectedFile()));
				while ((line = buffer.readLine()) != null) {
					fileToString.append(String.valueOf(line) + "\n");
				}
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(this.textArea, "Error cannot open the file");
			}
			
			
			this.textArea.setText(fileToString.toString());
		}
	}
	
}
