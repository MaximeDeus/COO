package fil.coo.question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import fil.coo.answer.*;



/**
 * 
 * A Mock questionnary class, used for QuestionnaireTest
 *
 * It is characterized by :
 * 
 * - A list of Question
 * - The ending score
 * 
 * Input are simulated (userAnswer are automatically filled)
 *  
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class MockQuestionnaire extends Questionnaire{

	protected MockQuestionnaire createQuestionnaire()
	{

		MockQuestionnaire questionnaire;
		
		Answer <String> textualAnswer1;
		Answer <String> booleanAnswer2;
		Answer <String> integerAnswer3;
		Answer <String> booleanAnswer4;
		Answer <String> integerAnswer5;
		Answer <List<String>> multipleAnswer6;
		Answer <String> multipleChoiceAnswer7;
		
		Question textualQuestion1;
		Question booleanQuestion2;
		Question integerQuestion3;
		Question booleanQuestion4;
		Question integerQuestion5;
		Question multipleQuestion6;
		Question multipleChoiceQuestion7;
		
		questionnaire = new MockQuestionnaire();
			
		textualAnswer1 = new TextAnswer("Tolkien");
		booleanAnswer2 = new BooleanAnswer("oui");
		integerAnswer3 = new IntegerAnswer("9");
		booleanAnswer4 = new BooleanAnswer("non");
		integerAnswer5 = new IntegerAnswer("1954");
		multipleAnswer6 = new MultipleAnswer("Frodo ; Pippin ; Merry ; Sam");
		multipleChoiceAnswer7 = new MultipleChoiceAnswer ("Bill | Bourricot | Robert | Jolly Jumper");
			
		textualQuestion1 = new Question ("Quel est le nom de l'auteur du Seigneur des Anneaux ?", textualAnswer1, 1);
		booleanQuestion2 = new Question ("Frodo est un Hobbit ?", booleanAnswer2, 1);
		integerQuestion3 = new Question ("Combien de membres composent la Compagnie de l'Anneau ?", integerAnswer3, 2);
		booleanQuestion4 = new Question ("Gandalf est un humain ?", booleanAnswer4, 3);
		integerQuestion5 = new Question ("En quelle annee est paru le Seigneur des Anneaux ?", integerAnswer5, 3);
		multipleQuestion6 = new Question ("Donnez le nom de l'un des hobbits de la Compagnie de l'Anneau ? ", multipleAnswer6, 1);
		multipleChoiceQuestion7 = new Question ("Comment s'appelle le poney qui accompagne la compagnie jusqu'a la Moria ?", multipleChoiceAnswer7, 3);
		
		questionnaire.addQuestion(textualQuestion1);
		questionnaire.addQuestion(booleanQuestion2);
		questionnaire.addQuestion(integerQuestion3);
		questionnaire.addQuestion(booleanQuestion4);
		questionnaire.addQuestion(integerQuestion5);
		questionnaire.addQuestion(multipleQuestion6);
		questionnaire.addQuestion(multipleChoiceQuestion7);
		
		return questionnaire;

	}
	
	public Question createQuestion (String nameOfAnswerClass, String text , String answer , String points ) throws Exception {
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question( text , AnswerFactory.FACTORY.buildAnswer(answer,nameOfAnswerClass) , nbPoints);
		}
		catch(NumberFormatException e) {
			throw new IOException("bad format");
		}
	}
	
	protected MockQuestionnaire createQuestionnaireUsingFactory (String fileName) throws Exception{
		MockQuestionnaire questionnaire = new MockQuestionnaire ();
		File source = new File (fileName);
		BufferedReader in = null ;
		try {
			in = new BufferedReader(new FileReader (source) );
			String nameOfAnswerClass;		
			// read block of 3 lines : text, answer and number of points
			while (( nameOfAnswerClass = in.readLine())!= null ) {
				String text = in.readLine();
				String answer = in.readLine ( );
				String nbPoints = in.readLine ( );
				if (answer == null || nbPoints == null ) {
					throw new IOException("bad format");
				}
				questionnaire.addQuestion( this.createQuestion (nameOfAnswerClass, text ,answer ,nbPoints));
			}
		} 
		catch (FileNotFoundException e) {
			throw new IOException(e);
		}
		finally {
				in.close();
		}
		return questionnaire ;
	}
	
	protected void askAllQuestions (List<String> allSimulatedUserAnswer)
	{
		Iterator<String> itAllSimulatedUserAnswer = allSimulatedUserAnswer.iterator();
		for (Question q : allQuestions)
		{
			q.displayQuestion();
			q.displayAnswerType();
			String userAnswer = itAllSimulatedUserAnswer.next();
			System.out.println(userAnswer);
			
			if(!q.isValidTypeOfAnswer(userAnswer))
			{
				System.out.println("Bad type!");
				q.displayAnswerType();
				userAnswer = itAllSimulatedUserAnswer.next();
				System.out.println(userAnswer);
			}
			
			if (q.isCorrectAnswer(userAnswer))
			{
				this.goodAnswerEffect(q);
			}
			
			else
			{
				this.badAnswerEffect(q);
			}
		}
		
		this.displayScore();
	}
}
