package fil.coo.question;

import fil.coo.answer.Answer;

/**
 * Class who represents a question 
 * It's characterized by :
 * 
 * - The question (String)
 * - An Answer (Answer)
 * - A number of point assigned
 * 
 * - An attribute has been added in order to get the UserAnswer with GUI
 * 
 * @author DEROISSART Maxime | SASU Daniel
 *
 */

public class Question {
	
	//ATTRIBUTE
	
	protected String text;
	protected Answer<?> answer; 
	protected int nbPoints;
	protected String userAnswerGUI; //UserAnswer with GUI
	
	
	//CONSTRUCTOR
	
	public Question(String text, Answer<?> answer, int nbPoints) {
		this.text = text;
		this.answer = answer;
		this.nbPoints = nbPoints;
	}
	

	/**
	  * Returns text
	  * @return text 
	  */
	public String getText() {
		return text;
	}

	/**
	  * Returns answer
	  * @return answer 
	  */
	public Answer<?> getAnswer() {
		return this.answer;
	}

	/**
	  * Returns nbPoints
	  * @return nbPoints
	  */
	public int getNbPoints() {
		return nbPoints;
	}
	
	//METHODS
	
	/**
	  * Display the question with the correct format
	  */
	
	public void displayQuestion()
	{
		String line = "-----------------------------------------\n";
		System.out.print(line + text + "\n");
	}
	
	/**
	  * Display the AnswerType with the correct format
	  */
	
	public void displayAnswerType()
	{
		System.out.print("Quelle est votre réponse " + this.getTypeOfAnswer() + " ?\n");
	}
	
	
	/**
	  * Returns the expected type of the answer
	  * @return the expected type of the answer
	  */
	
	public String getTypeOfAnswer()
	{
		return answer.getTypeOfAnswer();
	}
	
	/**
	  * Checks if the type of the answer is the same as the user input
	  * @param userAnswer the user input
	  * @return <code>true</code> if the type is correct, <code>false</code> otherwise
	  */
	
	public boolean isValidTypeOfAnswer(String userAnswer)
	{
		return answer.isValidTypeOfAnswer(userAnswer);
	}
	
	/**
	  * Checks if the answer is correct
	  * @param userAnswer the user input
	  * @return <code>true</code> if the answer is correct, <code>false</code> otherwise
	  */
	public boolean isCorrectAnswer(String userAnswer)
	{
		return answer.isCorrectAnswer(userAnswer);
	}
	
	/**
	 * Get the user selection or the user input in the GUI mode, then add it to the attribute 
	 * <em> userAnswerGUI </em> in order to check if it is the correct answer
	 * @param userAnswerText the selected answer, or the user input for this question
	 */
	public void setUserAnswerGUI(String userAnswerText) {
		this.userAnswerGUI = userAnswerText;
	  }

	/**
	 * Get the user selection or the user input in the GUI mode, it must be filled before (initialized as null) 
	 * @return the UserAnswer in GUI mode
	 */  
	public String getUserAnswerGUI() {
	  return this.userAnswerGUI;
	}
	
	
	


	
	
	

}
