package CharakterAndAttributes.Race;

import CharakterAndAttributes.CharAttr;
import CharakterAndAttributes.GameCharacter;

public class Human implements CharRaceAction{

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
