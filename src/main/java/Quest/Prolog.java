package Quest;

import CharakterAndAttributes.GameCharacter;
import Support.EzLog;

public class Prolog {
	
	GameCharacter character;
	
	public Prolog(GameCharacter character) {
		this.character=character;
	}

	private static void ak1_crash() {
		
		EzLog.log("Test",'1');
		
	}

	public void startNewStory() {
		ak1_crash();
	}
	
}
