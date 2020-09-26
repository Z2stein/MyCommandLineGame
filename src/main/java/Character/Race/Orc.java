package Character.Race;

import Character.CharAction;
import Character.GameCharacter;

public class Orc  implements CharAction {

	private GameCharacter gameChar;

	static final private int strengthModifier;
	static final private int constitutionModifier;
	
	static {
		strengthModifier = 5;
		constitutionModifier = 10;
	}
	
	public Orc(GameCharacter gameCharacter) {
		this.gameChar = gameCharacter;
	}

	public int getStrengthmodifier() {
		return strengthModifier;
	}

	public int getConstitutionmodifier() {
		return constitutionModifier;
	}


}
