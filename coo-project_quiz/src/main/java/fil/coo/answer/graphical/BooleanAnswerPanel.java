package fil.coo.answer.graphical;

import java.util.*;
import fil.coo.answer.*;

/**
 * 
 * A graphic representation of a BooleanAnswer, extended from MultipleAnswerPanel
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class BooleanAnswerPanel extends MultipleAnswerPanel<String>{
	
    //CONSTRUCTOR
	
	public BooleanAnswerPanel(BooleanAnswer question)
    {
		super(question);
    }
	
	//METHOD
  
	 /**
	  * Initialize the values for the button, who represents a possible user answer
	  */
	 protected void initTheValues()
	 {
		 theValues = new ArrayList<String>(Arrays.asList("oui","non"));
	 }
}