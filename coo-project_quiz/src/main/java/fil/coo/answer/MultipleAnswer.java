package fil.coo.answer;

import java.util.*;

import fil.coo.answer.graphical.*;

/**
 * 
 * An answer Class who contains multiple textual answer
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class MultipleAnswer extends Answer <List<String>>{
	
	
	//CONSTRUCTOR
	
	public MultipleAnswer(String textAllAnswers)
	{
		super(null);
		correctAnswer = ConvertStringSeparatedBySemicolonToList(textAllAnswers);
	}

	//METHODS
	
	
	/**
	 * Convert a String to an Arraylist of String, word are separated by ';'
	 * @param textAnswers is a line with words separated by ';'
	 * @return a list of String
	 */
	public List<String> ConvertStringSeparatedBySemicolonToList (String textAllAnswers)
	{
		return Arrays.asList(textAllAnswers.split(" ; "));
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
			return this.correctAnswer.contains(userAnswer);
		}
		
		else
		{
		return false;
		}
	}
	

	/**
	 * Returns the type of the answer
	 * @return the type of the answer
	 */
	public String getTypeOfAnswer() {
		int numberOfAnswer = this.correctAnswer.size();
		return "( " + numberOfAnswer + " réponses possibles)\n";
	}


	/**
	 * Returns <code>true</code> if <code>userAnswer</code> has the same type 
	 * as the correct answer. It's always true
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>'s type
	 * 		  will be compared with the 'correct' answer's type. 
	 * @return <code>true</code> if <code>userAnswer</code> has the same type 
	 */
	public boolean isValidTypeOfAnswer(String userAnswer) {
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
