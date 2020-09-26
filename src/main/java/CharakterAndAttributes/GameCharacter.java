package CharakterAndAttributes;

import CharakterAndAttributes.Class.Warrior;
import CharakterAndAttributes.Race.CharRace;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class GameCharacter {
	private String name;
	private int age;
	private CharClass cClass;
	private Field currentField;

	protected int condition;
	protected int strength;
	protected int agitily;
	protected int intelligence;
	protected CharAction chrActClass;
	protected CharRace race;

	public GameCharacter(String name, CharakterAndAttributes.Race.CharRace race, int age, int[] fieldCoordinates) {
		this.name = name;
		this.age = age;
		cClass = new Warrior();
		this.currentField = (WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);
		this.race = race;
		this.setRaceClass(race);
	}

	private void setRaceClass(CharakterAndAttributes.Race.CharRace charRace) {

		switch (charRace) {
		case Human:
			this.chrActClass = new CharakterAndAttributes.Race.Human(this);
			break;
		case Orc:
			this.chrActClass = new CharakterAndAttributes.Race.Orc(this);
			break;

		default:
			break;
		}

	}

	public void getAllInfo() {

		String strRace = race.name();
		String strClass = FormatingOut.getLastPackage(cClass.getClass().getName());

		System.out.println("You are " + name + ", a " + age + " year old " + strRace + ". Your Class is " + strClass);
	}

	public void doAttack(GameCharacter targetChar) {

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

	public CharAction getChrActClass() {
		return chrActClass;
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

	public void setChrActClass(CharAction chrActClass) {
		this.chrActClass = chrActClass;
	}

	public void setRace(CharRace race) {
		this.race = race;
	}

	public static GameCharacter createRandom(String name, int[] fieldCoordinates) {
		GameCharacter tempCharacter = new GameCharacter(name, CharRace.Human, 24, fieldCoordinates);
		return tempCharacter;
	}

	public void removeCharacter() {
		this.getCurrentField().removeCharakter(this);
	}

}
