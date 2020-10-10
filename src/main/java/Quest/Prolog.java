package Quest;

import Character.GameCharacter;
import Support.EzLog;
import Support.MsgType;

public class Prolog {
	
	GameCharacter character;
	
	public Prolog(GameCharacter character) {
		this.character=character;
	}

	private static void ak1_unknown() {
		
		EzLog.log("you wake up. It's dark, night. No sound. You feel the grass tickling you.",MsgType.INFO_AREA);
		
	}

	public void startNewStory() {
		ak1_unknown();
	}
	
}
