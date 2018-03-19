package fil.coo.plugin;

/**
 * A plugin that converts all characters to upper-case
 * @author DEROISSART Maxime, SASU Daniel
 *
 */

public class ToUpperCase implements Plugin {

	public String transform(String s) {
		return s.toUpperCase();
	}

	public String getLabel() {
		return "ToUpperCase";
	}

	public String helpMessage() {
		return "Converts all characters to upper-case";
	}
	
}
