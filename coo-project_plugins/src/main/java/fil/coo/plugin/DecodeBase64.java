package fil.coo.plugin;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * A plugin which decodes from Base64 
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class DecodeBase64 implements Plugin {

	public String transform(String s) {
		byte[] b =  Base64.getDecoder().decode(s);
		return new String(b);
	}

	public String getLabel() {
		return "Decode Base 64";
	}

	public String helpMessage() {
		return "Decode from the Base64";
	}

}
