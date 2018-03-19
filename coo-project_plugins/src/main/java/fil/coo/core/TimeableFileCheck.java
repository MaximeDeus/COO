package fil.coo.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A wrapper class which makes FileChecker 
 * compatible with javax.swing.Timer
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class TimeableFileCheck implements ActionListener {
	private FileChecker fChecker;
	
	/**
	 * Wraps the file checker in TimeableFileCheck
	 * @param fChecker an instance of FileChecker
	 */
	public TimeableFileCheck(FileChecker fChecker){
		this.fChecker = fChecker;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		fChecker.scanFolder();
	}

}
