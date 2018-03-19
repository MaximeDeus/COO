package fil.coo.answer.graphical;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fil.coo.answer.Answer;


/**
 * An abstract class who represents a squeletton for a graphic type of MultipleAnswer, likes BooleanAnswer or MultipleChoiceAnswer
 * @author DEROISSART Maxime | SASU Daniel
 * 
 */
public abstract class MultipleAnswerPanel<T> extends AnswerPanel
{
	
  //ATTRIBUTES
	
  protected java.util.Collection<T> theValues;
  private ButtonGroup group;
  private String answerText;
  
  //CONSTRUCTOR
  
  public MultipleAnswerPanel(Answer<?> answer)
  {
    super(answer);
    initTheValues();
  }
  

  //ABSTRACT METHOD

  /**
   * Initializes the possible answer
   */
  protected abstract void initTheValues();
  


  //METHODS
  
  /**
	* Creates a JPanel
	* @return a JPanel
	*/
  public JPanel getPanel()
  {
    JPanel result = new JPanel();
    result.setLayout(new java.awt.GridLayout(2, 1));
    
    group = new ButtonGroup();
    for (T t : theValues) {
      JRadioButton button = new JRadioButton(t.toString());
      button.addActionListener(new ButtonListener());
      group.add(button);
      result.add(button);
    }
    
    return result;
  }
  

  /**
   * Returns the user answer
   * @return the user answer
   */
  
  public String getAnswerText() { return answerText; }
  
  class ButtonListener implements java.awt.event.ActionListener {
    ButtonListener() {}
    
    public void actionPerformed(ActionEvent e) { answerText = e.getActionCommand(); }
  }
}

