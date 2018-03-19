package fil.coo.question;

import java.util.*;
import java.util.Scanner;

/**
 * 
 * A questionnary class
 *
 * It is characterized by :
 * 
 * - A list of Question
 * - The ending score
 * - a Scanner for the input
 *  
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class Questionnaire {
	
	//ATTRIBUTE
	
	protected List<Question> allQuestions;
	protected int score;
	protected Scanner in = new Scanner(System.in);
	
	//CONSTRUCTOR
	
	public Questionnaire ()
	{
		allQuestions = new LinkedList<Question>();
		score = 0;
	}

	//METHODS
	
	/**
	 * Returns the score
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	

	/**
	 * Returns the list who contains all Question object
	 * @return the list who contains all Question object
	 */
	public List<Question> getAllQuestions() {
		return allQuestions;
	}


	/**
	  * add a Question to the list of Question
	  */
	protected void addQuestion(Question q)
	{
		allQuestions.add(q);
	}
	
	/**
	  * Applies effect when the userAnswer is good
	  */
	protected void goodAnswerEffect(Question q)
	{
		int nbPoints = q.getNbPoints();
		System.out.println("correct, (" + nbPoints + " point(s))");
		this.score += nbPoints;
	}
	
	/**
	  * Applies effect when the userAnswer isn't good
	  */
	protected void badAnswerEffect(Question q)
	{
		System.out.println("incorrect, la bonne reponse etait " + q.getAnswer().getCorrectAnswer());
	}
	
	/**
	  * Display the score when the questionnary is finished
	  */
	protected void displayScore()
	{
		System.out.println("Vous avez obtenu " + this.score + " point(s)");
	}
	
	/**
	  * Ask a question to the user
	  */
	protected void askQuestion (Question q)
	{
		q.displayQuestion();
		q.displayAnswerType();
		String userAnswer = in.nextLine();
		
		while(!q.isValidTypeOfAnswer(userAnswer))
		{
			q.displayAnswerType();
			userAnswer = in.nextLine();
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
	
	/**
	  * Ask all questions to the user
	  */
	public void askAllQuestions()
	{
		for (Question q : allQuestions)
		{
			this.askQuestion(q);
		}
	this.displayScore();
	in.close();
	}
}
