package fil.coo.action;


/**
 *  A scheduler that advances each task by 
 *  a step
 *  @author DEROISSART Maxime, SASU Daniel
 */


public class FairScheduler extends Scheduler {

	protected int index; // the index of the ,ext action
	
	public FairScheduler(int timeToEnd){
		super(timeToEnd);
		this.index=0;
	}
	
	/**
	 * Returns the index of the current task
	 * @return the index of the next action
	 */
	public int getNextActionIndex() {
		return this.index;
	}


	public void stepEffect() {
		Action nextAction = this.actions.get(this.index);
		nextAction.doStep();
		if(nextAction.isFinished()){
			this.actions.remove(this.index);
		} else {
			index = (index + 1)%this.actions.size();	
		}
		if(this.actions.isEmpty()) return;
		
	}

}
