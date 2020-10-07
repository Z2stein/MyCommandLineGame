package Character;

import java.util.ArrayList;
import java.util.HashMap;

import Character.RageTo.RageAction;
import Character.Attributes.BattleAttributes;
import Character.Attributes.CharacterAttributes;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Support.EzLog;
import World.Field;
import World.WorldMap;

public class GameCharacter {

	static private ArrayList<GameCharacter> allCharacters;

	static {
		allCharacters = new ArrayList<GameCharacter>();
	}

	final private String name;
	private int age;
	private Field currentField;
	private boolean isBot;

	public final CharacterAttributes charAttr;
	final BattleAttributes battleAttr;

	final public CharRace race;
	final public CharClass cClass;
	private HashMap<GameCharacter, RageTo> rageTo;

	public GameCharacter(String name, CharRace race, CharClass cClass, int age, int[] fieldCoordinates) {
		setBot(true);

		allCharacters.add(this);

		this.rageTo = new HashMap<>();

		this.name = name;
		this.age = age;
		this.currentField = (WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);

		// Set Race
		this.race = race; // enum

		// Set Class
		this.cClass = cClass;

		charAttr = new CharacterAttributes(this);

		battleAttr = new BattleAttributes(this);

	}

	/**
	 * 
	 * @param rageTarget the Char which is the target of the Race (e.g. the attacker)
	 * @param rageAction
	 */
	public void rageToChar(GameCharacter rageTarget, RageAction rageAction) {
		if (!rageTo.containsKey(rageTarget)) {
			rageTo.put(rageTarget, new RageTo(this, rageTarget));
		}
		int rageActionValue = rageAction.getRageValue();
		rageTo.get(rageTarget).increaseRage(rageActionValue);
	}

	public void getAllInfo() {

		String strRace = race.name();
		String strClass = cClass.name();

		System.out.println("You are " + name + ", a " + age + " year old " + strRace + ". Your Class is " + strClass);
	}

	public void doAttack(GameCharacter targetChar) {
		int modificationPoints = this.battleAttr.getAttackPoints();
		targetChar.battleAttr.modifyLifePoints(-modificationPoints);

		targetChar.rageToChar(this, RageAction.ATTACK);

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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


	public static ArrayList<GameCharacter> getAllCharacters() {
		return allCharacters;
	}

	public boolean isBot() {
		return isBot;
	}

	public void setBot(boolean isBot) {
		this.isBot = isBot;
	}

	public HashMap<GameCharacter, RageTo> getRageTo() {
		return rageTo;
	}

	public void nextRound() {
		rageTo.values().stream().forEach(s->s.decreaseRoundBased());
		}
}
