package fil.coo.answer;

import org.junit.*;

import static org.junit.Assert.*;


/**
 * 
 * A testing class for the Answer
 * 
 * @author DEROISSART Maxime | SASU Daniel
 *
 */


public class AnswerTest {

	
	private Answer <String> correctAnswer;
	
	@Before
	public void init()
	{
		correctAnswer = new MockAnswer("correct");
	}
	
	@Test
	public void getTypeOfAnswerTest()
	{
		assertTrue("[MOCK]".equals(correctAnswer.getTypeOfAnswer()));
		assertFalse("[MAUCK]".equals(correctAnswer.getTypeOfAnswer()));
	}
	
	@Test
	public void  isCorrectAnswerTest()
	{
		assertTrue(correctAnswer.isCorrectAnswer("correct"));
		assertFalse(correctAnswer.isCorrectAnswer("incorrect"));
		assertFalse(correctAnswer.isCorrectAnswer("not a valid type"));
	}
	
	@Test
	public void  isValidTypeOfAnswerTest()
	{
		assertTrue(correctAnswer.isValidTypeOfAnswer("correct"));
		assertTrue(correctAnswer.isValidTypeOfAnswer("incorrect"));
		assertFalse(correctAnswer.isValidTypeOfAnswer("not a valid type"));
	}

}
