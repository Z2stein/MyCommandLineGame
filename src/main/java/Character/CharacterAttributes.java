package Character;

public class CharacterAttributes {
	private int constitution;
	private int strength;
	public CharacterAttributes(GameCharacter character) {
		super();
		this.constitution = character.charAction.getConstitutionmodifier()+character.charAction.getConstitutionmodifier();
		this.strength = character.charAction.getStrengthmodifier()+character.charAction.getStrengthmodifier();;
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
