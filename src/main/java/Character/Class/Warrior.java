package Character.Class;

import Character.GameCharacter;

public class Warrior implements CharClassAction {


	static final private int strengthModifier;
	static final private int constitutionModifier;
	
	static {
		strengthModifier = 10;
		constitutionModifier = 10;
	}
	

	public int getStrengthmodifier() {
		return strengthModifier;
	}

	public int getConstitutionmodifier() {
		return constitutionModifier;
	}

}
