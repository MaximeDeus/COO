package fil.coo.question.graphical;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fil.coo.answer.*;
import fil.coo.answer.graphical.AnswerPanel;
import fil.coo.question.Question;

/**
 * 
 * An class who represents a graphical Question
 * @author DEROISSART Maxime | SASU Daniel
 *
 */


public class QuestionPanel extends JPanel {

	  //ATTRIBUTES
	
	  protected JLabel text;
	  protected AnswerPanel inputAnswerPanel;
	  protected Question question;
	  
	  //CONSTRUCTOR
	  
	  /**
	   * Build a QuestionPanel with a question
	   * @param question a Question object
	   * @return a QuestionPanel
	   */
	  public QuestionPanel(Question question)
	  {
	    this.question = question;
	    
	    text = new JLabel("  " + question.getText());
	    
	    setLayout(new GridLayout(1, 2));
	    setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    text.setAlignmentY(0.5F);
	    add(text);
	    inputAnswerPanel = createInputAnswerPanel();
	    inputAnswerPanel.getPanel().setAlignmentY(0.5F);
	    add(inputAnswerPanel.getPanel());
	  }
	  
	  //METHODS
	  
	  /**
	   * Get the input of the user, and then add it to the attribute question(stocked in his attribute UserAnswerGUI), in order to check if this is the good answer or not
	   */
	  public void setAnswer()
	  {
	    question.setUserAnswerGUI(this.inputAnswerPanel.getAnswerText());
	  }
	
	  /**
	   * Creates the answerPanel
	   * @return the answerPanel
	   */
	  private AnswerPanel createInputAnswerPanel()
	  {
	    return question.getAnswer().createMyAnswerPanel();
	  }
	  
	  /**
	   * Check if the input of the user is the good answer or not
	   * @return if the user answer is correct, returns the number of points of the question. If the user haven't filled the answer, or if the answer isn't correct, returns 0 
	   */
	  public int checkAnswer()
	  {
		  if (this.inputAnswerPanel.getAnswerText() == null ) //If the user haven't fill the answer
		  {
			  return 0;
		  }
		  else if (this.question.isCorrectAnswer(this.inputAnswerPanel.getAnswerText())) //If the user is correct
		  {
			  return this.question.getNbPoints();
		  }
		  else //If the user isn't correct
		  {
			  return 0;
		  }
	  }
	  
}
