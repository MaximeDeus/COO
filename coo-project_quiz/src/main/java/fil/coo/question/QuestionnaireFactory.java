package fil.coo.question;

import fil.coo.answer.*;
import java.io.*;

/**
 * 
 * A factory class for generate a Questionnary with a File like question_tolkien.txt
 * 
 * @author DEROISSART Maxime | SASU Daniel
 *
 */
public class QuestionnaireFactory {
	
	/**
	 * Creates a question defined by the followed parameters
	 * 
	 * @param nameOfAnswerClass  the name of the answerClass who'll be used for this question
	 * @param text  the states of the question
	 * @param answer  the answer associated (creates thanks to the name of the answer class)
	 * @param points  number of points won if the user Answer is correct
	 * @return a Question object
	 * @throws Exception Raised if the format isn't correct
	 */
	public Question createQuestion (String nameOfAnswerClass, String text , String answer , String points ) throws Exception {
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question( text , AnswerFactory.FACTORY.buildAnswer(answer,nameOfAnswerClass) , nbPoints);
		}
		catch(NumberFormatException e) {
			throw new IOException("bad format");
		}
	}
	
	/**
	 * Generates a question using a File with the correct format
	 * 
	 * @param fileName : The name of the File used for creates the Questionnary
	 * @return a Questionnary
	 * @throws Exception if the File's format isn't correct
	 */
	public Questionnaire createQuestionnaire ( String fileName) throws Exception {
		Questionnaire questionnaire = new Questionnaire ();
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

}
