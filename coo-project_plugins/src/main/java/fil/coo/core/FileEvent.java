package fil.coo.core;

import java.util.EventObject;

/**
 * An event class which will be used to describe 
 * an file-related event, the event is characterized
 * by the filename.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class FileEvent extends EventObject {
	
	protected String name;
	
	/**
	 * Creates a new <code>FileEvent</code> instance
	 * @param name the name of the file involved in the event
	 */
	public FileEvent(String name){
		super(name);
		this.name = name;
	}
	
	/**
	 * Returns the string representation of this class, in this case 
	 * the filename.
	 * @return the string representation of this class, in this case
	 * the filename.
	 */
	public String toString(){
		return this.name;
	}
}
