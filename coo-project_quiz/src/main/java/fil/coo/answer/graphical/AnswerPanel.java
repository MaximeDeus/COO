package fil.coo.answer.graphical;

import javax.swing.JPanel;

import fil.coo.answer.Answer;

/**
 * 
 * An abstract class who represents a squeletton for a graphic type of answer
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public abstract class AnswerPanel
{
	//ATTRIBUTE
	
	protected Answer<?> answer;
  
	//CONSTRUCTOR
	
	public AnswerPanel(Answer<?> answer)
	{
	   this.answer = answer;
	}
	
	//ABSTRACT METHOD
	  
	/**
	  * Creates a JPanel for each type of answer object
	  * @return a JPanel
	  */
	public abstract JPanel getPanel();
	
	  
	/**
	  * Returns the user answer
	  * @return the user answer
	  */
	public abstract String getAnswerText();
}