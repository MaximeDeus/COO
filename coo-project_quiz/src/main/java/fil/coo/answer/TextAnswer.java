package fil.coo.answer;

import fil.coo.answer.graphical.*;

/**
 * Answer's subclass who represents a Text Answer
 *
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class TextAnswer extends Answer<String> {
	
	//CONSTRUCTOR
	
	public TextAnswer(String correctAnswer) {
		super(correctAnswer);
	}
	
	//METHODS
	
	/**
	 * Returns the type of the answer
	 * @return the type of the answer
	 */
	public String getTypeOfAnswer()
	{
		return "[texte]";
	}
	
	/**
	 * Returns <code>true</code> if the <code>userAnswer</code> is correct
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>
	 * 		  will be compared with the 'correct' answer. 
	 * @return <code>true</code> if the <code>userAnswer</code> is correct
	 */
	public boolean isCorrectAnswer(String userAnswer)
	{
		if (this.isValidTypeOfAnswer(userAnswer))
		{
			return this.correctAnswer.equals(userAnswer);
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns <code>true</code> if <code>userAnswer</code> has the same type 
	 * as the correct answer. It's always true
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>'s type
	 * 		  will be compared with the 'correct' answer's type. 
	 * @return <code>true</code> if <code>userAnswer</code> has the same type 
	 */
	public boolean isValidTypeOfAnswer(String userAnswer)
	{
		return true;
	}

	
	/**
	 * Creates an Answer Panel. It'll be used in the GUI version
	 * @return an Answer Panel
	 */
	public AnswerPanel createMyAnswerPanel()
	{
		return new TextAnswerPanel(this);
	}

}

