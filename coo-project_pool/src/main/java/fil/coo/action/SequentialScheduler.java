package fil.coo.action;

/**
 * A scheduler that accomplishes the tasks in 
 * a sequential manner, when a task is finished it begins
 * the next task, the order of tasks is  defined by their position in
 * the list.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */

public class SequentialScheduler extends Scheduler {

	public SequentialScheduler(int timeToEnd){
		super(timeToEnd);
	}
	
	public void stepEffect() {
		Action a = this.actions.get(0);
		a.doStep();
		if(a.isFinished()) {
			this.actions.remove(a);
		}
	}

}