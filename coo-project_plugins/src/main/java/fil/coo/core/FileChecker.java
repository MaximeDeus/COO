package fil.coo.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * An event broadcaster which keeps track of the files 
 * in a given path, and notifies it's listeners to changes 
 * like addition/deletion of files in the directory.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class FileChecker {
	private ArrayList<FileListener> fileListeners = new ArrayList<FileListener>();
	private HashSet<String> knownFiles = new HashSet<String>();
	private String path;
	private FilenameFilter filter;

	/**
	 * Creates a new <code>FileChecker</code> instance
	 * @param filter a file filter 
	 * @param path a directory 
	 */
	public FileChecker(FilenameFilter filter, String path){
		this.filter = filter;
		this.path = path;
	}
	
	/**
	 * Returns the value of the path field of this <code>FileChecker</code>
	 * @return the value of the path field of this <code>FileChecker</code>
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the value of path attribute to <code>path</code>
	 * @param path a path to be attributed to this <code>FileChecker</code>
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Adds an event listener which will react to the events 
	 * boradcasted by this <code>FileChecker</code>
	 * @param fileListener the file listener to be added
	 */
	public void addEventListener(FileListener fileListener){
		if(this.fileListeners.contains(fileListener)) {
			return;
		}else {
			this.fileListeners.add(fileListener);
		}
	}
	
	/**
	 * Broadcasts the adding of a file to the listeners
	 * @param filename the name of the added file
	 */
	private void fireFileAdded(String filename){
		ArrayList<FileListener> fileListenersCopy = (ArrayList<FileListener>) fileListeners.clone();
		if(fileListenersCopy.size() == 0)return;
		FileEvent event = new FileEvent(filename);
		for(FileListener fl : fileListenersCopy) {
			fl.fileAdded(event);
		}
	}
	
	/**
	 * Broadcasts the deletion of a file to the listeners
	 * @param filename the name of the deleted file
	 */
	private void fireFileRemoved(String filename){
		ArrayList<FileListener> fileListenersCopy = (ArrayList<FileListener>) fileListeners.clone();
		if(fileListenersCopy.size() == 0) return;
		FileEvent event = new FileEvent(filename);
		for(FileListener fl : fileListenersCopy) {
			fl.fileRemoved(event);
		}
	}
	
	
	/**
	 * Scans the path changes.
	 * If there are any changes the listeners are notified.
	 */
	public void scanFolder(){
		HashSet<String> knownFilesCopy = (HashSet<String>) knownFiles.clone();
		File dir = new File(this.path);
		String [] fileList = dir.list(this.filter);
		
		for(String s : fileList){
			if(!this.knownFiles.contains(s)){
				this.fireFileAdded(s);
				this.knownFiles.add(s);
			}
			else{
				knownFilesCopy.remove(s);
			}
		}
		for(String s : knownFilesCopy){
			this.fireFileRemoved(s);
			knownFiles.remove(s);
		}
	}
		
}