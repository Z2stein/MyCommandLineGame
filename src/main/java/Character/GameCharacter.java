package Character;

import java.util.ArrayList;
import java.util.HashMap;

import Character.Attributes.BattleAttributes;
import Character.Attributes.CharacterAttributes;
import Character.Class.CharClass;
import Character.Class.Warrior;
import Character.Race.CharRace;
import Character.Race.Human;
import Character.Race.Orc;
import Support.EzLog;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class GameCharacter {

	static private ArrayList<GameCharacter> allCharacters;

	static {
		allCharacters = new ArrayList<GameCharacter>();
	}

	private String name;
	private int age;
	private Field currentField;
	private boolean isBot;
	
	private CharacterAttributes charAttr;
	private BattleAttributes battleAttr;
	private ArrayList<CharAction> charAction;

	protected CharRace race;
	protected CharClass cClass;

	public GameCharacter(String name, CharRace race, CharClass cClass, int age, int[] fieldCoordinates) {
		setBot(true);
		
		allCharacters.add(this);

		this.charAction = new ArrayList<>();

		this.name = name;
		this.age = age;
		this.currentField = (WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);

		// Set Race
		this.race = race; // enum
		this.setRaceClass(race); // actionClass

		// Set Class
		this.cClass = cClass;
		this.setClassAction(cClass);

		charAttr = new CharacterAttributes(this);

		battleAttr = new BattleAttributes(this);

	}

	private void setClassAction(CharClass cClass2) {

		switch (cClass2) {
		case WARRIOR:
			charAction.add(new Warrior());
			break;

		default:
			break;
		}
	}

	private void setRaceClass(CharRace charRace) {

		switch (charRace) {
		case HUMAN:
			charAction.add(new Human());
			break;
		case ORC:
			charAction.add(new Orc());
			break;

		default:
			break;
		}

	}

	public void getAllInfo() {

		String strRace = race.name();
		String strClass = cClass.name();

		System.out.println("You are " + name + ", a " + age + " year old " + strRace + ". Your Class is " + strClass);
	}

	public void doAttack(GameCharacter targetChar) {
		int modificationPoints = this.battleAttr.getAttackPoints();
		targetChar.battleAttr.modifyLifePoints(-modificationPoints);

		if (targetChar.battleAttr.getLifePoints() == 0)
			targetChar.dying();

	}

	private void dying() {
		EzLog.log(this.name + " is dead!", 1);
		this.currentField.removeCharakter(this);
		this.currentField = WorldMap.getCemetery();
	}

	public int[] getCharakterPosition() {
		return currentField.getCoordinates();
	}

	public Field getCurrentField() {
		return currentField;
	}

	public void setCurrentField(Field currentField) {
		this.currentField = currentField;
	}

	public String getCharakterPositionStr() {
		String resStr;
		resStr = "[" + getCharakterPosition()[0] + "|" + getCharakterPosition()[1] + "]";
		return resStr;
	}

	public void switchField(int[] newCoord) {
		removeCharacter();
		Field newField = WorldMap.getField(newCoord);
		newField.addCharakter(this);
		setCurrentField(newField);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public CharClass getcClass() {
		return cClass;
	}

	public CharRace getRace() {
		return race;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setcClass(CharClass cClass) {
		this.cClass = cClass;
	}

	public void setRace(CharRace race) {
		this.race = race;
	}

	public static GameCharacter createRandom(String name, int[] fieldCoordinates) {
		GameCharacter tempCharacter = new GameCharacter(name, CharRace.HUMAN, CharClass.WARRIOR, 24, fieldCoordinates);
		return tempCharacter;
	}

	public static GameCharacter createRandom() {
		return createRandom("TestChar", new int[] { 2, 2 });
	}

	public void removeCharacter() {
		this.getCurrentField().removeCharakter(this);
		allCharacters.remove(this);
	}

	public CharacterAttributes getCharAttr() {
		return charAttr;
	}

	public void setCharAttr(CharacterAttributes charAttr) {
		this.charAttr = charAttr;
	}

	public ArrayList<CharAction> getCharAction() {
		return charAction;
	}

	public BattleAttributes getBattleAttr() {
		return battleAttr;
	}

	public void setBattleAttr(BattleAttributes battleAttr) {
		this.battleAttr = battleAttr;
	}

	public static ArrayList<GameCharacter> getAllCharacters() {
		return allCharacters;
	}

	public boolean isBot() {
		return isBot;
	}

	public void setBot(boolean isBot) {
		this.isBot = isBot;
	}

}
