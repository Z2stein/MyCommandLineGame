package Character;

import java.util.ArrayList;
import java.util.HashMap;

import Actions.DoAction;
import Character.RageTo.RageAction;
import Character.Attributes.BattleAttributes;
import Character.Attributes.CharacterAttributes;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Support.EzLog;
import Support.MsgType;
import World.Field;
import World.WorldMap;

public class GameCharacter extends DoAction {

	static private ArrayList<GameCharacter> allCharacters;

	static {
		setAllCharacters(new ArrayList<GameCharacter>());
	}

	final private String name;
	private int age;
	private Field currentField;
	private boolean isBot;

	public final CharacterAttributes charAttr;
	final public BattleAttributes battleAttr;

	final public CharRace race;
	final public CharClass cClass;
	private HashMap<GameCharacter, RageTo> rageTo;

	public GameCharacter(String name, CharRace race, CharClass cClass, int age, int[] fieldCoordinates) {
		setBot(true);

		getAllCharacters().add(this);

		this.rageTo = new HashMap<>();

		this.name = name;
		this.age = age;
		this.currentField = (WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);

		this.race = race;
		this.cClass = cClass;

		charAttr = new CharacterAttributes(this);

		battleAttr = new BattleAttributes(this);

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

	public static void setAllCharacters(ArrayList<GameCharacter> allCharacters) {
		GameCharacter.allCharacters = allCharacters;
	}

	public HashMap<GameCharacter, RageTo> getRageTo() {
		return rageTo;
	}

	public void getAllInfo() {

		String strRace = race.name();
		String strClass = cClass.name();

		System.out.println("You are " + name + ", a " + age + " year old " + strRace + ". Your Class is " + strClass);
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

	/**
	 * 
	 * @param rageTarget the Char which is the target of the Race (e.g. the
	 *                   attacker)
	 * @param rageAction
	 */
	public void rageToChar(GameCharacter rageTarget, RageAction rageAction) {
		if (!rageTo.containsKey(rageTarget)) {
			rageTo.put(rageTarget, new RageTo(this, rageTarget));
		}
		int rageActionValue = rageAction.getRageValue();
		rageTo.get(rageTarget).increaseRage(rageActionValue);
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
		getAllCharacters().remove(this);
	}

	public void nextRound() {

		// Rage
		GameCharacter resultingTargenCharacter = null;
		for (GameCharacter rageTarget : rageTo.keySet()) {
			if (resultingTargenCharacter == null)
				resultingTargenCharacter = rageTarget;

			RageTo currentRage = rageTo.get(rageTarget);

			if (rageTo.get(resultingTargenCharacter).getRageValue() < currentRage.getRageValue()) 
				resultingTargenCharacter=currentRage.getRageTarget();
		}
		
		
		if (resultingTargenCharacter == null) return;
		if (rageTo.get(resultingTargenCharacter).getRageValue() >= RageTo.getCriticalattackrage())
			this.doAttack(resultingTargenCharacter);
		
		rageTo.keySet().stream().forEach(s->rageTo.get(s).decreaseRoundBased());

	}

	public void doAttack(GameCharacter targetChar) {

		int modificationPoints = this.battleAttr.getAttackPoints();
		targetChar.battleAttr.modifyLifePoints(-modificationPoints);

		targetChar.rageToChar(this, RageAction.ATTACK);

		if (targetChar.battleAttr.getLifePoints() == 0)
			targetChar.dying();

	}

	private void dying() {
		EzLog.log(this.name + " is dead!", MsgType.DONE_ACTION);
		this.currentField.removeCharakter(this);
		this.currentField = WorldMap.getCemetery();
	}

}
