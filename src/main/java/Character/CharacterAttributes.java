package CharakterAndAttributes;

public class CharacterAttributes {
	private int constitution;
	private int strength;
	public CharacterAttributes(GameCharacter character) {
		super();
		this.constitution = character.chrRaceAct.getConstitutionmodifier()+character.chrClassAct.getConstitutionmodifier();
		this.strength = character.chrRaceAct.getStrengthmodifier()+character.chrClassAct.getStrengthmodifier();;
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
}
