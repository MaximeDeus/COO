package fil.coo.question;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.answer.*;


/**
 * 
 * A testing class for Question
 * 
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class QuestionTest {
	

	protected Answer <String> correctAnswer;
	protected Answer <String> incorrectAnswer;
	protected Question correctQuestion;
	
	@Before
	public void init()
	{
		correctAnswer = new MockAnswer("correct");
		incorrectAnswer = new MockAnswer("incorrect");
		correctQuestion = new Question ("The answer is 'correct'. 1 Point", correctAnswer, 1);
	}
	
	@Test
	public void getAnswerTest()
	{
		assertSame(correctAnswer, correctQuestion.getAnswer());
		assertNotSame(incorrectAnswer, correctQuestion.getAnswer());
	}
	
	@Test
	public void getNbPointsTest()
	{
		assertSame(1, correctQuestion.getNbPoints());
		assertNotSame(2, correctQuestion.getNbPoints());
	}
	
	@Test
	public void getTypeOfAnswerTest()
	{
		assertTrue(correctQuestion.getTypeOfAnswer().equals("[MOCK]"));
		assertFalse(correctQuestion.getTypeOfAnswer().equals("[MAUCK]"));
	}
	
	
	@Test
	public void isValidTypeOfAnswerTest()
	
	{
		assertTrue(correctQuestion.isValidTypeOfAnswer("correct"));
		assertTrue(correctQuestion.isValidTypeOfAnswer("incorrect"));
		assertFalse(correctQuestion.isValidTypeOfAnswer("not a valid type"));
	}
	
	@Test
	public void isCorrectAnswerTest()
	{
		assertTrue(correctQuestion.isCorrectAnswer("correct"));
		assertFalse(correctQuestion.isCorrectAnswer("incorrect"));
	}


}
