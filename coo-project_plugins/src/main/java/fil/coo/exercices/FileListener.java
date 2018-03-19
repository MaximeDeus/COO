package fil.coo.exercices;

import java.util.EventListener;

public interface FileListener extends EventListener {
	
	public void fileAdded(FileEvent event);
	public void fileRemoved(FileEvent event);
}
