package fil.coo.exercices;


public class PluginObserver implements FileListener {

	public void fileAdded(FileEvent event) {
		System.out.println(event.toString() +" plugin found!");

	}

	public void fileRemoved(FileEvent event) {
		System.out.println(event.toString() + " plugin removed!");

	}

}
