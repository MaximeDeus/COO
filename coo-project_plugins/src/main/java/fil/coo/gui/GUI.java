package fil.coo.gui;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import fil.coo.core.*;

/**
 * The Graphical Interface of the application.
 * Contains all the components of the Graphical User Interface, 
 * include listeners and and a file checker to scan for plugins.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class GUI{
	private JFrame frame;
	private JMenuBar menu;
	private JTextArea textArea;
	private FileChecker fileChecker;
	private JMenu fileMenu;
	private JMenu pluginMenu;
	private JMenu helpMenu;
	private JScrollPane panel;
	
	/**
	 * Creates new <code>GUI</code> instance.
	 * 
	 */
	public GUI() {
		this.initGUI();
		PluginFilter filter = new PluginFilter();
		this.fileChecker = new FileChecker(filter, "resources/");
		fileChecker.addEventListener(new PluginListener(this.textArea, this.pluginMenu, this.helpMenu));
		TimeableFileCheck tCheck = new TimeableFileCheck(this.fileChecker);
		Timer t = new Timer(1000, tCheck);
		t.start();
	}

	/**
	 * Initializes the <code>GUI</code>, creates all the panels and buttons.
	 * Adds listeners.
	 */
	public void initGUI() {
		this.frame = new JFrame("Project Plugins");
		this.textArea = new JTextArea(40, 100);
		this.panel = new JScrollPane(textArea);
		this.menu = new JMenuBar();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(this.panel); // scrolling properties 
		this.fileMenu = new JMenu("File");
		JMenuItem fileMenuOption = new JMenuItem("New");
		this.fileMenu.add(fileMenuOption);
		fileMenuOption = new JMenuItem("Open");
		fileMenuOption.addActionListener((ActionListener) new OpenFileListener(this.getTextArea()));
		this.fileMenu.add(fileMenuOption);
		menu.add(this.fileMenu);
		this.pluginMenu = new JMenu("Tools");
		menu.add(this.pluginMenu);
		this.helpMenu = new JMenu("Help");
		menu.add(this.helpMenu);
		this.frame.setJMenuBar(menu);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	/**
	 * Returns the text area of this graphical interface
	 * @return the text area of this graphical interface
	 */
	public JTextArea getTextArea() {
		return this.textArea;
	}

	/**
	 * Returns the frame of this graphical interface
	 * @return the frame of this graphical interface
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Returns the menu bar of this graphical interface
	 * @return the menu bar of this graphical interface
	 */
	public JMenuBar getMenu() {
		return menu;
	}

	/**
	 * Returns the file checker attributed to this graphical interface
	 * @return the file checker attributed to this graphical interface
	 */
	public FileChecker getFileChecker() {
		return fileChecker;
	}


	/**
	 * Returns the file menu of this graphical interface
	 * @return the file menu of this graphical interface
	 */
	public JMenu getFileMenu() {
		return fileMenu;
	}

	/**
	 * Returns the plugin menu of this graphical interface
	 * @return the plugin menu of this graphical interface
	 */
	public JMenu getPluginMenu() {
		return pluginMenu;
	}

	/**
	 * Returns the help menu of this graphical interface
	 * @return the help menu of this graphical interface
	 */
	public JMenu getHelpMenu() {
		return helpMenu;
	}

	
}
