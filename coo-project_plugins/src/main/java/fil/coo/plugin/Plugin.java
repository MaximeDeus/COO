package fil.coo.plugin;

/**
 * An interface for plugins, specifying the mandatory 
 * methods for a plugin class.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public interface Plugin {
	/**
	 * Applies the transformation to the string <code>s</code>
	 * @param s the string to be transformed
	 * @return the result of the transformation of <code>s</code>
	 */
	public String transform(String s);
	
	/**
	 * Returns the label of this plugin aka the name
	 * @return the name of this plugin
	 */
	public String getLabel();
	
	/**
	 * Returns the help message of this plugin 
	 * @return the help message of this plugin
	 */
	public String helpMessage();
}
