package fil.coo.answer.graphical;

import fil.coo.answer.MultipleChoiceAnswer;

/**
 * 
 * A graphic representation of a MultipleAnswer, extended from MultipleAnswerPanel
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class MultipleChoiceAnswerPanel extends MultipleAnswerPanel<String>
{
	
	  //CONSTRUCTOR
	
	  public MultipleChoiceAnswerPanel(MultipleChoiceAnswer answer) {
	    super(answer);
	  }
	  
	  //METHOD
	  
	  /**
	    * Initializes the answer
	    */
	  protected void initTheValues()
	  {
	    theValues = ((MultipleChoiceAnswer)answer).getAllPossiblesAnswer();
	  }
}
