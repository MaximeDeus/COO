package fil.coo.donjon;
import java.util.*;



import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.room.*;
import fil.coo.donjon.tools.*;

/**
 * Main class of the game
 * @author DEROISSART Maxime | SASU Daniel
 */

public class DonjonGame {
	
	//ATTRIBUTS
	
	protected RandomGenerator randomGenerator = new RandomGenerator(); //Generate randoms elements of the game (monster, item, room..) 
	protected static Player player = new Player(new ExitRoom()); //Player, initialized with an Exit Room

	
	//CONTRUCTEUR
	
	public DonjonGame() {}


	
	//METHODES
	
	
	/**
	 * Initialize the game, fill the room 
	 */
	public static void init()
	{
		
		System.out.println ("How many rooms would you like( 4 + your choice )?");
		int input = ScannerInt.readInt(104-4)+1;

		while (input > 0) //Add rooms consecutively
		{
			Room randomRoom = RandomGenerator.generateRandomRoom(2,2,3);
			Direction southDirection = Direction.S;	
			player.getRoom().addNeighbors(southDirection, randomRoom);
			player.changeRoom(southDirection);
			input --;
		}
	}
	
	/**
	 * Check if the player is in an ExitRoom
	 * @return true if the player is in an ExitRoom
	 */
	
	public static boolean goodEnding() //If the player is in an ExitRoom
	{
		System.out.println("");
		System.out.println("You won !");
		return true;
	}
	
	/**
	 * Check if the player is dead
	 * @return false if the player is dead
	 */
	public static boolean badEnding() //If the player is dead
	{
		player.die();
		return false;
	}
	
	/**
	 * Test if the player is still in the room
	 * @param otherRoom an another room
	 * @return true if the player is still in the room, false otherwise
	 */
	public static boolean stillInTheSameRoom (Room otherRoom)
	{
		return player.getRoom() == otherRoom;
	}
	
	
	/**
	 * Sequence of battle in a room
	 * Display every elements in the room, and successives actions until the player leave the Room
	 */
	public static void oneTurn()
	{
		Room currentPlayerRoom = player.getRoom();
		while (stillInTheSameRoom(currentPlayerRoom))
		{
			player.setAllActions();
			player.DescribesEntity();
			int input = ScannerInt.readInt(player.getAllActions().size());
			player.getAllActions().get(input).execute(player);
		}
	}
	
	/**
	 * Principal function of the game
	 * @return true if the player won, false otherwise
	 */
	public static boolean play()
	{
		System.out.println("");
		
		System.out.println("-------------------------------------");
		System.out.println("----> WELCOME TO THE UNDERWORLD <----");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("Let the games begin!");
		System.out.println("");
		System.out.println("");
		while (!player.isDead())
		{
			if (player.getRoom().isExit())
			{
				return DonjonGame.goodEnding();
			}
			else
			{
				player.setAllActions();	
				player.DescribesEntity();
				player.getRoom().displayRoom();
				DonjonGame.oneTurn();
			}
			
			
		}
		return DonjonGame.badEnding();
	}
	
	public static void main (String[] args)
	{
		DonjonGame.init();
		DonjonGame.play();
	}
}
