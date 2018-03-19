package fil.coo.gui;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import fil.coo.plugin.Plugin;

/**
 * A plugin item for swing menu.
 * This class associates an menu item and the 
 * corresponding plugin.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class PluginItem extends JMenuItem {
	private Plugin plugin;

	/**
	 * Creates a new <code>PluginItem</code> instance.
	 * @param textArea the text area of the editor
	 * @param plugin the plugin to be attributed to this menu item
	 */
	public PluginItem(JTextArea textArea, Plugin plugin) {
		super(plugin.getLabel());
		this.plugin = plugin;
		this.addActionListener(new PluginItemAction(textArea, this));
	}

	/**
	 * Returns the plugin attributed to this menu item
	 * @return the plugin attributed to this menu item
	 */
	public Plugin getPlugin() {
		return plugin;
	}
	
}
