package Character.Attributes;

import Character.GameCharacter;

public class CharacterAttributes {
	final static private int initalStrength;
	static final int initalConstitution;
	private static final int initalDexterity;
	private static final int initalIntelligence;
	private static final int initalWisdom;
	private static final int initalCharisma;
	private int strength, constitution, dexterity, intelligence, wisdom, charisma;

	static {
		initalStrength = 0;
		initalConstitution = 0;
		initalDexterity = 0;
		initalIntelligence = 0;
		initalWisdom = 0;
		initalCharisma = 0;
	}

	public int getStrength() {
		return strength;
	}
	public int getConstitution() {
		return constitution;
	}
	public int getDexterity() {
		return dexterity;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public int getCharisma() {
		return charisma;
	}

	public CharacterAttributes(GameCharacter character) {
		super();
		strength = initalStrength;
		constitution = initalConstitution;
		dexterity = initalDexterity;
		intelligence = initalIntelligence;
		wisdom = initalWisdom;
		charisma = initalCharisma;

		strength += character.race.strengthModifier;
		constitution += character.race.constitutionModifier;
		dexterity += character.race.dexterityModifier;
		intelligence += character.race.intelligenceModifier;
		wisdom += character.race.wisdomModifier;
		charisma += character.race.charismaModifier;

		strength += character.cClass.strengthModifier;
		constitution += character.cClass.constitutionModifier;
		dexterity += character.cClass.dexterityModifier;
		intelligence += character.cClass.intelligenceModifier;
		wisdom += character.cClass.wisdomModifier;
		charisma += character.cClass.charismaModifier;

	}

}
