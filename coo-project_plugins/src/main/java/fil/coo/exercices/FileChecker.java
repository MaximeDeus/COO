package fil.coo.exercices;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;


public class FileChecker {
	private ArrayList<FileListener> fileListeners = new ArrayList<FileListener>();
	private HashSet<String> knownFiles = new HashSet<String>();
	private String path;
	private FilenameFilter filter;

	public FileChecker(FilenameFilter filter, String path){
		this.filter = filter;
		this.path = path;
	}

	public void addEventListener(FileListener fileListener){
		if(this.fileListeners.contains(fileListener)) {
			return;
		}else {
			this.fileListeners.add(fileListener);
		}
	}
	

	private void fireFileAdded(String filename){
		ArrayList<FileListener> fileListenersCopy = (ArrayList<FileListener>) fileListeners.clone();
		if(fileListenersCopy.size() == 0)return;
		FileEvent event = new FileEvent(filename);
		for(FileListener fl : fileListenersCopy) {
			fl.fileAdded(event);
		}
	}
	

	private void fireFileRemoved(String filename){
		ArrayList<FileListener> fileListenersCopy = (ArrayList<FileListener>) fileListeners.clone();
		if(fileListenersCopy.size() == 0) return;
		FileEvent event = new FileEvent(filename);
		for(FileListener fl : fileListenersCopy) {
			fl.fileRemoved(event);
		}
	}
	
	

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