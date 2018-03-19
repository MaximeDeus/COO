package fil.coo.answer;

import fil.coo.answer.graphical.AnswerPanel;
import fil.coo.answer.graphical.TextAnswerPanel;

/**
 * Type of Answer only used for QuestionTest and AnswerTest
 * 
 * @author DEROISSART Maxime | SASU Daniel
 */

public class MockAnswer extends Answer <String>
{
	
	public MockAnswer (String correctAnswer)
	{
		super(correctAnswer);
	}

	
	public String getTypeOfAnswer()
	{
		return "[MOCK]";
	}
	
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
	 * 
	 * There is two accepted words
	 */
	public boolean isValidTypeOfAnswer(String userAnswer)
	{
		return userAnswer.equals("correct") || userAnswer.equals("incorrect");
	}
	
	public AnswerPanel createMyAnswerPanel()
	{
		return new TextAnswerPanel(this);
	}

	
}
