package Quest;

import CharakterAndAttributes.GameCharacter;
import Support.EzLog;

public class Prolog {
	
	GameCharacter character;
	
	public Prolog(GameCharacter character) {
		this.character=character;
	}

	private static void ak1_unknown() {
		
		EzLog.log("you wake up. It's dark, night. No sound. You feel the grass tickling you.",1);
		
	}

	public void startNewStory() {
		ak1_unknown();
	}
	
}
