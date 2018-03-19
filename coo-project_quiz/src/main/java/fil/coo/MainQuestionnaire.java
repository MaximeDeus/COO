package fil.coo;

import fil.coo.question.*;
import fil.coo.question.graphical.*;
import java.util.Scanner;
public class MainQuestionnaire {
	
	private static Scanner scanner = new Scanner (System.in);
	
	public static void usage()
	{
		System.out.println("Voulez-vous jouer en mode textuel ou graphique ? \n (Entrez t pour textuel ou g pour graphique)");
	}
	
	public static void main(String[] args) throws Exception
	 {
		MainQuestionnaire.usage();
		String userChoice = MainQuestionnaire.scanner.nextLine();
		while (!userChoice.equals("t") && !userChoice.equals("g"))
		{
			MainQuestionnaire.usage();
			userChoice = MainQuestionnaire.scanner.nextLine();
			System.out.println(userChoice);
		}
		
		if (userChoice.equals("t"))
		{
			QuestionnaireFactory qf = new QuestionnaireFactory();
			Questionnaire q = qf.createQuestionnaire("question_tolkien_2.txt");
			q.askAllQuestions();
		}
		else if (userChoice.equals("g"))
		{
			QuestionnaireGui qg = new QuestionnaireGui("question_tolkien_2.txt");
		    qg.createFrame();
		}
	    
	 }

}
