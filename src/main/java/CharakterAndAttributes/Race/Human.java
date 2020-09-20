package CharakterAndAttributes.Race;

import CharakterAndAttributes.CharAction;
import CharakterAndAttributes.GameCharacter;

public class Human implements CharAction{

	private GameCharacter gameChar;

	public Human(GameCharacter gameCharacter) {
		this.gameChar = gameCharacter;
	}

}
