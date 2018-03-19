package fil.coo.answer;

import java.util.*;

import fil.coo.answer.graphical.*;

/**
 * 
 * An answer Class who contains multiple choices of answer
 * Only one possible answer is good
 * The possibles answer always are randomly displayed
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class MultipleChoiceAnswer extends TextAnswer{
	
	//ATTRIBUTE
	
	protected List<String> allPossiblesAnswer;
	
	//CONSTRUCTOR
	
	public MultipleChoiceAnswer(String textAllAnswers)
	{
		super(MultipleChoiceAnswer.getGoodAnswerFromAllPossiblesAnswer(textAllAnswers));
		this.allPossiblesAnswer = MultipleChoiceAnswer.ConvertStringSeparatedByPipeToList(textAllAnswers);
		
	}
	
	//METHODS
	
	public List<String> getAllPossiblesAnswer()
	{
		return this.allPossiblesAnswer;
	}

	/**
	 * Convert a String to an Arraylist of String, word are separated by '|'
	 * @param textAnswers is a line with words separated by '|'
	 * @return a list of String
	 */
	public static List<String> ConvertStringSeparatedByPipeToList (String textAllAnswers)
	{
		return Arrays.asList(textAllAnswers.split(" \\|"));
	}
	
	/**
	 * Returns the correct answer from the line of possibles answers
	 * The correct answer must be on the 1st position
	 * @param textAnswers : the line of possibles answers
	 * @return The correct answer
	 */
	public static String getGoodAnswerFromAllPossiblesAnswer (String textAllAnswers)
	{
		int indexFirstSpace = textAllAnswers.indexOf(" ");
		return textAllAnswers.substring(0 , indexFirstSpace);
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
	 * Returns the type of the answer
	 * @return the type of the answer
	 */
	public String getTypeOfAnswer() {
		String line = "(";
		Collections.shuffle(allPossiblesAnswer);
		for (String s : allPossiblesAnswer)
		{
			line += s + " ";
		}
		line += ")";
		return line;
	}

	/**
	 * Returns <code>true</code> if <code>userAnswer</code> has the same type 
	 * as the correct answer, it must be one of all possibilities
	 * @param userAnswer an answer provided by the user, the <code>userAnswer</code>'s type
	 * 		  will be compared with the 'correct' answer's type. 
	 * @return <code>true</code> if <code>userAnswer</code> has the same type 
	 */
	public boolean isValidTypeOfAnswer(String userAnswer) {
		return allPossiblesAnswer.contains(userAnswer);
	}
	
	
	/**
	 * Creates an Answer Panel. It'll be used in the GUI version
	 * @return an Answer Panel
	 */
	public AnswerPanel createMyAnswerPanel()
	{
		return new MultipleChoiceAnswerPanel(this);
	}
}
