package fil.coo.plugin;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * A plugin which encodes to Base64 
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class EncodeBase64 implements Plugin {

	public String transform(String s) {
		byte[] b = s.getBytes(Charset.forName("UTF-8"));
		return Base64.getEncoder().encodeToString(b);
	}

	public String getLabel() {
		return "EncodeBase64";
	}

	public String helpMessage() {
		return "Encodes the text into Base64";
	}

}
