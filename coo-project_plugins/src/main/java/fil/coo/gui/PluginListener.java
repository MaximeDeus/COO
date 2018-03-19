package fil.coo.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import fil.coo.core.FileEvent;
import fil.coo.core.FileListener;
import fil.coo.plugin.Plugin;

/**
 * A plugin listener wich adds/removes the plugin entries 
 * in the plugin and help menu.
 * 
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class PluginListener implements FileListener {
	
	private JMenu pluginMenu;
	private JMenu helpMenu;
	private JTextArea textArea;
	
	/**
	 * Creates a new <code>PluginListener</code> instance
	 * @param textArea the text area of the editor
	 * @param pluginMenu the plugin menu of the editor
	 * @param helpMenu the help menu of the editor
	 */
	public PluginListener(JTextArea textArea, JMenu pluginMenu, JMenu helpMenu) {
		this.pluginMenu = pluginMenu;
		this.helpMenu = helpMenu;
		this.textArea = textArea;
		
	}
	
	/**
	 * Creates a new <code>Plugin</code> instance from 
	 * a .class file 
	 * @param e a file event
	 * @return a <code>Plugin</code> instance 
	 * @throws Exception the instance cannot be created
	 */
	private Plugin getPlugin(FileEvent e) throws Exception {
		String pluginName = e.toString().replace(".class", "");
		Class<?> c = Class.forName("fil.coo.plugin." + pluginName);
		Plugin plugin = (Plugin) c.newInstance();
		return plugin;
	}

	/**
	 * Adds the plugin entries to the plugin and help menus
	 */
	public void fileAdded(FileEvent e) {
		Plugin plugin;
		try {
			plugin = this.getPlugin(e);
			this.pluginMenu.add(new PluginItem(this.textArea, plugin));
			JMenuItem helpItem = new JMenuItem(plugin.getLabel());
			helpItem.addActionListener(new HelpItemActionListener(plugin.getLabel(), plugin.helpMessage()));
			this.helpMenu.add(helpItem);
		} catch (Exception e1) {
			System.out.println("adding class failed");
		}
	}

	/**
	 * Removes the plugin entries to the plugin and help menus
	 */
	public void fileRemoved(FileEvent e){
		for(int i=0; i < this.pluginMenu.getItemCount(); i++){
			if(pluginMenu.getItem(i).getText().equals(e.toString().replace(".class", ""))){		
				this.pluginMenu.remove(i);
				this.helpMenu.remove(i);
			}
		}
	}

}
