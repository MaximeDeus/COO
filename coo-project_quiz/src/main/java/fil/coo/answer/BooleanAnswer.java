package fil.coo.answer;

import fil.coo.answer.graphical.*;

/**
 * Answer's subclass who represents a boolean Answer (yes/no)
 *
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class BooleanAnswer extends Answer<String> {
	
	//CONSTRUCTOR
	
	public BooleanAnswer(String correctAnswer) {
		super(correctAnswer);
	}
	
	//METHODS
	
	/**
	 * Returns the type of the answer
	 * @return the type of the answer
	 */
	public String getTypeOfAnswer()
	{
		return "[oui non]";
	}
	
	/**
	 * Returns <code>true</code> if the <code>userAnswer</code> is correct
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>
	 * 		  will be compared with the 'correct' answer. 
	 * @return <code>true</code> if the <code>userAnswer</code> is correct
	 */
	public boolean isCorrectAnswer(String userAnswer){
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
	 * as the correct answer. It must be yes or no 
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>'s type
	 * 		  will be compared with the 'correct' answer's type.
	 * @return <code>true</code> if <code>userAnswer</code> has the same type 
	 */
	
	public boolean isValidTypeOfAnswer(String userAnswer){
		System.out.println(userAnswer);
		return userAnswer.equals("oui") || userAnswer.equals("non");
	}
	
	/**
	 * Creates an Answer Panel. It'll be used in the GUI version
	 * @return an Answer Panel
	 */
	public AnswerPanel createMyAnswerPanel()
	{
		return new BooleanAnswerPanel(this);
	}

}
