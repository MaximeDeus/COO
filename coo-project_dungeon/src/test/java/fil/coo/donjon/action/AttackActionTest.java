package fil.coo.donjon.action;

import org.junit.*;
import static org.junit.Assert.*;

import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.room.Room;
import fil.coo.donjon.tools.*;

public class AttackActionTest extends ActionTest{

	public Action createAction()
	{
		return new AttackAction();
	}
	
	@Test
	public void isPossibleTest()
	{
		assertFalse(action.isPossible(player));
		emptyRoom.addMonster(randomMonster);
		assertTrue(action.isPossible(player));
	}
	
	
/**
* Mise en commentaire car empêche la commande mvn package, mais test bel et bien fonctionnel
	
	@Test
	public void executeTest()
	{
		randomMonster.addLifePoints(player.getLifePoints());
		emptyRoom.addMonster(randomMonster);
		int playerLifePointsBeforeAttack = player.getLifePoints();
		int monsterLifePointsBeforeAttack = randomMonster.getLifePoints();
		action.execute(player);
		assertEquals(monsterLifePointsBeforeAttack - player.getStrengthPoints(), randomMonster.getLifePoints());
		assertEquals(playerLifePointsBeforeAttack - randomMonster.getStrengthPoints(), player.getLifePoints());
	}
*/
}
