package fil.coo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

/**
 * An event listener which invokes the plugin effect,
 * on click on the corresponding button.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class PluginItemAction implements ActionListener {
	private PluginItem pluginItem;
	private JTextArea textArea;
	
	/**
	 * Creates a new <code>PluginItemAction</code> instance
	 * @param textArea the text area, which is an input for the plugin
	 * @param pluginItem a plugin menu item
	 */
	public PluginItemAction(JTextArea textArea, PluginItem pluginItem) {
		this.pluginItem = pluginItem;
		this.textArea = textArea;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.textArea.setText(this.pluginItem.getPlugin().transform(this.textArea.getText()));
	}
}
