package fil.coo.plugin;

/**
 * A plugin that duplicates the content of the file.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class Duplicate implements Plugin {

	public String transform(String s) {
		return s+"\n\n"+s;
	}

	public String getLabel() {
		return "Duplicate";
	}

	public String helpMessage() {
		return "Duplicates the content of the file";
	}

}
