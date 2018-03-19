package fil.coo.core;

import java.util.EventListener;

/**
 * A file listener class which associates actions 
 * to two file-related events:
 *  1. When a file is added
 *  2. When a file is removed
 * 
 * The class interested in processing file events 
 * described above, implements this interface.
 * 
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public interface FileListener extends EventListener {
	
	/**
	 * A method which is called when a file has been added
	 * @param event the broadcasted event, after a file was added
	 */
	public void fileAdded(FileEvent event);
	
	/**
	 * A method which is called when a file has been removed
	 * @param event the broadcasted event, after a file was removed
	 */
	public void fileRemoved(FileEvent event);
}
