package fil.coo.exercices;


public class ClassObserver implements FileListener {

	public void fileAdded(FileEvent event) {
		System.out.println(event.toString() + " detecté ");

	}

	public void fileRemoved(FileEvent event) {
		System.out.println(event.toString() + " supprimé ");
	}

}
