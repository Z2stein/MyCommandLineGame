package Character.Attributes;

import Character.CharAction;
import Character.GameCharacter;

public class CharacterAttributes {
	static private int	initalConstitution,	initalStrength;
	
	static {
		initalConstitution = 0;
		initalStrength =0;
	}
	
	private int constitution;
	private int strength;
	public CharacterAttributes(GameCharacter character) {
		super();
		constitution = initalConstitution;
		strength = initalStrength;
		
		for(CharAction charAction:character.getCharAction()) {
			this.constitution += charAction.getConstitutionmodifier();
			this.strength += charAction.getStrengthmodifier();
		}
	}
	public int getConstitution() {
		return constitution;
	}
	public int getStrength() {
		return strength;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public static int getInitalConstitution() {
		return initalConstitution;
	}
	public static int getInitalStrength() {
		return initalStrength;
	}
}
