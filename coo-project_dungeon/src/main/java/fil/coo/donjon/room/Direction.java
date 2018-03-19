package fil.coo.donjon.room;

/**
 * All possibles direction of a room
 * @author DEROISSART / SASU
 *
 */

public enum Direction {N,S,E,W;
	
	//METHODE

	/**
	 * return the opposite direction of a direction
	 * @return the opposite direction of a direction
	 */
	public Direction getOppositeDirection ()
	{
		if (this == Direction.E)
			return Direction.W;
		else if (this == Direction.W)
			return Direction.E;
		else if (this == Direction.N)
			return Direction.S;
		else
			return Direction.N;
		
	}
	
	public void DescribesDirection()
	{
		System.out.println(this.name());
	}
	




}


