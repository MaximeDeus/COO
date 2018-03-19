package fil.coo.donjon.tools;

/**
 * Exception class used when the direction choosen in Room.changeDirection doesn't exist
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class WrongDirectionException extends RuntimeException {

	public WrongDirectionException(String msg) 
	{
		super(msg);
	}

}
