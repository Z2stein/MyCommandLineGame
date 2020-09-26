package Character;

import Character.Class.CharClass;
import Character.Class.CharClassAction;
import Character.Class.Warrior;
import Character.Race.CharRace;
import Character.Race.CharRaceAction;
import Character.Race.Human;
import Character.Race.Orc;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class GameCharacter {
	private String name;
	private int age;
	private Field currentField;

	protected CharacterAttributes charAttr;
	
	protected BattleAttributes battleAttr;

	
	protected CharRaceAction chrRaceAct;
	protected CharClassAction chrClassAct;
	protected CharRace race;
	protected CharClass cClass;

	public GameCharacter(String name, CharRace race, CharClass cClass, int age, int[] fieldCoordinates) {
		this.name = name;
		this.age = age;
		this.currentField = (WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);
		
		//Set Race
		this.race = race; //enum
		this.setRaceClass(race); //actionClass
		
		// Set Class
		this.cClass = cClass;
		this.setClassAction(cClass);
		
		charAttr=new CharacterAttributes(this);
		
		battleAttr=new BattleAttributes(this);
		
//		this.setAttributes();
		
//TODO Battle Attr		
	}


	private void setClassAction(CharClass cClass2) {

		switch (cClass2) {
		case Warrior:
			this.chrClassAct = new Warrior();
			break;

		default:
			break;
		}
	}


	private void setRaceClass(CharRace charRace) {

		switch (charRace) {
		case Human:
			this.chrRaceAct = new Human(this);
			break;
		case Orc:
			this.chrRaceAct = new Orc(this);
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
		GameCharacter tempCharacter = new GameCharacter(name, CharRace.Human,CharClass.Warrior, 24, fieldCoordinates);
		return tempCharacter;
	}

	public void removeCharacter() {
		this.getCurrentField().removeCharakter(this);
	}


	public CharacterAttributes getCharAttr() {
		return charAttr;
	}


	public void setCharAttr(CharacterAttributes charAttr) {
		this.charAttr = charAttr;
	}




}
