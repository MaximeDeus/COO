package fil.coo.answer;
 
import java.lang.reflect.*;
/**
 * An factory Answer class
 * It's composed by a singleton who'll generate Answer object using buildAnswer method 
 * @author DEROISSART Maxime | SASU Daniel
 */
public class AnswerFactory {
	
	//ATTRIBUTE
	
	public static final AnswerFactory FACTORY = new AnswerFactory(); //SINGLETON

	
	//FACTORY METHOD
	
	/**
	 * Built a new Answer object in function of the String nameOfAnswerClass
	 * @param answer : The answer
	 * @parem nameOfAnswerClass : the className of the Answer
	 * @return an Answer object in function of the String nameOfAnswerClass
	 */
	
	public Answer<?> buildAnswer(String answer, String nameOfAnswerClass) throws Exception
	{

		Class<?> AnswerClass = Class.forName(nameOfAnswerClass);
			    
		Constructor<?> AnswerConstructor = AnswerClass.getConstructor(new Class[] { String.class });
			    
		Answer<?> answerObject = (Answer<?>)AnswerConstructor.newInstance(new Object[] { answer });
		
		return answerObject;	
	}

}
