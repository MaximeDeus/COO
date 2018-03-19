package fil.coo.question.graphical;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import fil.coo.question.*;

import java.util.*;


/**
 * 
 * A GUI questionnary class
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class QuestionnaireGui
{
  private JFrame f;
  private QuestionnaireFactory questionnaireFactory;
  protected static Questionnaire questionnaire;
  private List<QuestionPanel> allQuestionPanel; 
  public int finalScore;
  
  /**
   * Creates a Questionnary GUI with a Filename, who'll be used for creates the questionnary
   * @param filename a Filename, it must be corresponding to a good File format like question_tolkien_2.txt
   * @throws Exception
   */
  public QuestionnaireGui(String filename) throws Exception
  {
	  this.questionnaireFactory = new QuestionnaireFactory();
	  QuestionnaireGui.questionnaire = questionnaireFactory.createQuestionnaire(filename);
	  allQuestionPanel = new LinkedList<QuestionPanel>();
	  this.finalScore = 0;
  }

  
  /**
   * Generate the GUI interface
   * @throws Exception
   */
  public void createFrame() throws Exception
  {
    f = new JFrame();
    JPanel pp = new JPanel();
    pp.setLayout(new GridLayout(5, 1));
    JScrollPane p = new JScrollPane(pp);
    f.setLayout(new BorderLayout(2, 1));
    f.getContentPane().add(p, "Center");
    
    f.setSize(500, 150);
    f.addWindowListener(new FermeWindowEvent());
    
    for (Question q : questionnaire.getAllQuestions())
    {
    	 QuestionPanel qp = new QuestionPanel(q);
    	 allQuestionPanel.add(qp);
    	 pp.add(qp);
    }

    
    JButton finished = new JButton("Valider mes réponses");
    finished.addActionListener(new FinishedActionListener(this));
    f.add(finished, "South");
    
    f.setVisible(true);

  }
  
  
  
  
  
  private class FinishedActionListener implements ActionListener {
	final QuestionnaireGui questionnaireGuiMain;
    private FinishedActionListener(QuestionnaireGui q)
    {
    	this.questionnaireGuiMain = q;
    }
    
    public int FillScore()
    {
    	int finalScore = 0;
    	for (QuestionPanel qp : this.questionnaireGuiMain.allQuestionPanel)
        {
    		qp.setAnswer();
    		finalScore += qp.checkAnswer();
        }
    	
    	return finalScore;
    }

    
    public void actionPerformed(ActionEvent e) {
    
      
      JOptionPane.showMessageDialog(f, "Votre score : " + this.FillScore() + " point(s)", "Questionnaire terminé", 1);
    }
  }
  
  private class FermeWindowEvent extends WindowAdapter {
    private FermeWindowEvent() {}
    
    public void windowClosing(WindowEvent e) { System.exit(0); }
  }
  
  public static void main(String[] args) throws Exception
  {
    QuestionnaireGui qqq = new QuestionnaireGui(args[0]);
    qqq.createFrame();
  }
}
