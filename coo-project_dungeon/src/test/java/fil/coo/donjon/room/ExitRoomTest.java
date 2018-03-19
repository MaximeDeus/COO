package fil.coo.donjon.room;

import org.junit.*;
import static org.junit.Assert.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.item.*;
import fil.coo.donjon.tools.*;

public class ExitRoomTest extends RoomTest {

	@Override
	public Room createEmptyRoom() {
		return new ExitRoom();
	}

}
