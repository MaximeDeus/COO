package fil.coo.action;

/**
 * An abstract class to represent an action type
 * @author DEROISSART Maxime, SASU Daniel
 *
 */

public abstract class Action {
	
	protected ActionState state;
	protected int totalTime; //the time of execution of this action
	
	public Action(int timeToEnd) {
			this.totalTime = timeToEnd;
			this.state = ActionState.READY;
	}
	
	/**
	 * Returns the state of this action
	 * @return the state of this action
	 */
	public ActionState getState() {
		return this.state;
	}
	
	/**
	 * Returns <code>true</code> if this action is finished
	 * @return <code>true</code> if this action is finished
	 */
	public boolean isFinished() {
		if(this.stopCondition()){
			this.state = ActionState.FINISHED;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Advances the action by a step
	 * @throws ActionFinishedException if the action is finished
	 */
	public void doStep() throws ActionFinishedException{	
		if(isFinished()) {
			throw new ActionFinishedException();
		}else {
			this.state = ActionState.IN_PROGRESS;
			stepEffect();
		}
	}
	
	/**
	 * Describes the progress of one step of this action
	 */
	public abstract void stepEffect();
	
	/**
	 * Returns the <code>true</code> if the stop condition is met
	 * @return <code>true</code> if the stop condition is met
	 */
	public abstract boolean stopCondition();
}
