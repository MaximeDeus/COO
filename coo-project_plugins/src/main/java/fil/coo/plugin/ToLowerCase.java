package fil.coo.plugin;

/**
 * A plugin that converts all characters to upper-case
 * @author DEROISSART Maxime, SASU Daniel
 *
 */

public class ToLowerCase implements Plugin {

	public String transform(String s) {
		return s.toLowerCase();
	}

	public String getLabel() {
		return "ToLowerCase";
	}

	public String helpMessage() {
		return "Converts all characters to lower-case";
	}
}
