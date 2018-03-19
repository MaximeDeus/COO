package fil.coo.action;

import java.util.*;

/**
 * A class that describes the scheduler type. 
 * A scheduler executes a list of actions in a defined order.
 * @author DEROISSART Maxime, SASU Daniel
 *
 */

public abstract class Scheduler extends Action {

	protected List<Action> actions; // actions to be accomplished by this scheduler
	
	public Scheduler(int timeToEnd) {
		super(timeToEnd);
		this.actions = new ArrayList<Action>();
	}
	
	/**
	 * Returns the list of actions to be accomplished by 
	 * this scheduler
	 * @return the list of actions of this scheduler
	 */
	public List<Action> getActions() {
		return this.actions;
	}


	public boolean stopCondition() {
		return this.actions.isEmpty() && this.state != ActionState.READY;
	}
	
	public void addAction(Action a) throws ActionFinishedException{	
		if (a.isFinished()) {
			throw new ActionFinishedException();
		}
		if (this.isFinished()) {
			throw new ActionFinishedException();
		}
		if(this.getState() == ActionState.IN_PROGRESS) {
			throw new SchedulerStartedException();
		}
		else {
			this.actions.add(a);
		}
	}
	
	public abstract void stepEffect();

}
