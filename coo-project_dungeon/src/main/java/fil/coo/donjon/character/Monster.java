package fil.coo.donjon.character;

import fil.coo.donjon.room.*;
import fil.coo.donjon.item.*;
import java.util.Random;

/**
 * Monster class
 * @author DEROISSART Maxime | SASU Daniel
 */

public class Monster extends DungeonCharacter {
	
	//CONSTRUCTEURS

	
	public Monster(int lifePoints, int strengthPoints, Room room, int gold) {
		super(lifePoints, strengthPoints, room, gold);
	}

	public Monster(Room room) {
		super(room);
	}
	
	//METHODES
	
	public String toString() {
		return " Monster [lifePoints=" + lifePoints + ", strengthPoints=" + strengthPoints + ", gold=" + gold+"]";
	}

	/**
	 * If the monster is dead, he will drop his Gold and disappear from the room
	 */
	public void die() {
		System.out.println("Monster is dead. He dropped " + this.getGold().toString());
		Room MonsterRoom = (Room)this.room;
		MonsterRoom.addItem(this.getGold());
		MonsterRoom.removeMonster(this);
	}

}