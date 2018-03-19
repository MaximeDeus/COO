package fil.coo.answer.graphical;

import javax.swing.*;

import fil.coo.answer.Answer;

import java.awt.Dimension;

/**
 * 
 * A graphic representation of TextAnswer
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class TextAnswerPanel extends AnswerPanel {
	
	 //ATTRIBUTE
	
	 protected JTextField answer;
	  
	 //CONSTRUCTOR
	 
	  public TextAnswerPanel(Answer<?> answer)
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
	    answer = new JTextField("");
	    answer.setPreferredSize(new Dimension(100, 50));
	    answer.setAlignmentY(0.5F);
	    result.add(answer);
	    return result;
	  }
	  
	  /**
	   * Returns the user answer
	   * @return the user answer
	   */
	  public String getAnswerText()
	  {
	    return answer.getText();
	  }

}
