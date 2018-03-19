package fil.coo.exercices;

import java.util.EventObject;

public class FileEvent extends EventObject {
	
	protected String name;
	
	public FileEvent(String name){
		super(name);
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
}
