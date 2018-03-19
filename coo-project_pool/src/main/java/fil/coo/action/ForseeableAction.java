package fil.coo.action;

/**
 * A class describing a forseeable action aka 
 * an action that takes n steps to complete
 * @author DEROISSART Maxime, SASU Daniel
 *
 */
public class ForseeableAction extends Action {
	
	protected int remainingTime;
	
	public ForseeableAction(int timeToEnd){
		super(timeToEnd);
		this.remainingTime=timeToEnd;
	}
	
	

	public void stepEffect() {
		this.remainingTime--;
	}


	public boolean stopCondition() {
		return this.remainingTime == 0;
	}

}
