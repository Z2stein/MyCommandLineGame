package Character.Race;

import Character.CharAction;
import Character.GameCharacter;

public class Human  implements CharAction {

	private GameCharacter gameChar;

	static final private int strengthModifier;
	static final private int constitutionModifier;
	
	static {
		strengthModifier = 3;
		constitutionModifier = 10;
	}
	
	
	public Human(GameCharacter gameCharacter) {
		this.gameChar = gameCharacter;
	}


	public int getStrengthmodifier() {
		return strengthModifier;
	}

	public int getConstitutionmodifier() {
		return constitutionModifier;
	}

}
