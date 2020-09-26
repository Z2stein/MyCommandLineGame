package Character.Class;

import Character.CharAction;

public class Warrior implements CharAction {


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
