package fil.coo.question;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * 
 * A testing class for Questionnaire
 * 
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class QuestionnaireTest {
	
	protected MockQuestionnaire mockQ;
	protected MockQuestionnaire Q;
	protected MockQuestionnaire FQ;
	
	protected  List<String> simulatedInput;

	
	
	
	@Before
	public void init() throws Exception
	{
		mockQ = new MockQuestionnaire();
		Q = mockQ.createQuestionnaire();
		FQ = mockQ.createQuestionnaireUsingFactory("question_tolkien_2.txt");
		
		simulatedInput = new LinkedList<String>();
		
		String badAnswerForQ1 = "Not Tolkien";
		String badTypeForQ2 = "maybe";
		String goodAnswerForQ2 = "oui";
		String badTypeForQ3 = "neuf";
		String goodAnswerForQ3 = "9";
		String badAnswerForQ4 = "oui";
		String goodAnswerForQ5 = "1954";
		String goodAnswerForQ6 = "Sam";
		String badTypeForQ7 = "JollyJumper";
		String badAnswerForQ7 = "Bourricot";
		
		simulatedInput.add(badAnswerForQ1);
		simulatedInput.add(badTypeForQ2);
		simulatedInput.add(goodAnswerForQ2);
		simulatedInput.add(badTypeForQ3);
		simulatedInput.add(goodAnswerForQ3);
		simulatedInput.add(badAnswerForQ4);
		simulatedInput.add(goodAnswerForQ5);
		simulatedInput.add(goodAnswerForQ6);
		simulatedInput.add(badTypeForQ7);
		simulatedInput.add(badAnswerForQ7);
	}
	
	@Test
	public void askAllQuestionsTest()
	{
		assertSame(0, Q.score);
		Q.askAllQuestions(simulatedInput);
		assertSame(7, Q.score);
	}
	
	@Test
	public void askAllQuestionsTestUsingFactory()
	{
		assertSame(0, FQ.score);
		FQ.askAllQuestions(simulatedInput);
		assertSame(7, FQ.score);
	}

}
