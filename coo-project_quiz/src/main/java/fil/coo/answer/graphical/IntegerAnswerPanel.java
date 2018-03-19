package fil.coo.answer.graphical;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import fil.coo.answer.*;

/**
 * 
 * A graphic representation of an IntegerAnswer
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class IntegerAnswerPanel extends AnswerPanel{
	
	 //ATTRIBUTE
	
	 private JSpinner spinner;
	  
	 //CONSTRUCTOR
	 
	 public IntegerAnswerPanel(IntegerAnswer answer)
	 {
	   super(answer);
	 }
	  
	 //METHODS
	 
	 /**
	  * Creates a JPanel
	  * @return a JPanel
	  */
	 public JPanel getPanel()
	 {
	   JPanel result = new JPanel();
	   spinner = new JSpinner();
	   spinner.setPreferredSize(new Dimension(50, 50));
	   spinner.setAlignmentY(1.5F);
	   result.add(spinner);
	   return result;
	 }
	  
	 /**
	  * Returns the user answer
	  * @return the user answer
	  */
	 public String getAnswerText()
	 {
	   return spinner.getValue().toString();
	 }
}
