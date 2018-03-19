package fil.coo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fil.coo.plugin.Plugin;

/**
 * A plugin listener shows the help message of the plugin
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class HelpItemActionListener implements ActionListener {
	
	private String helpMessage;
	private String pluginName;

	/**
	 * Creates a new <code>HelpItemActionListener</code> instance
	 * @param pluginName the name of the plugin 
	 * @param helpMessage the help message of the plugin
	 */
	public HelpItemActionListener(String pluginName, String helpMessage) {
		this.helpMessage = helpMessage;
		this.pluginName = pluginName;
	}

	/**
	 * Shows the help message in a separate panel
	 */
	public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog(null, this.helpMessage, pluginName, 1);
	}
	
}
