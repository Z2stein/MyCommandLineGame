package CharakterAndAttributes;

import CharakterAndAttributes.Class.Warrior;
import CharakterAndAttributes.Race.Human;
import Support.EzLog;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class GameCharacter {
	private String name;
	private int age;
	private CharRace race;
	private CharClass cClass;
	private Field currentField;
	
	protected int condition;
	protected int strength;
	protected int agitily;
	protected int intelligence;
	

	
	
	
	public GameCharacter(int[] fieldCoordinates) {
		this.name = EzLog.in("What is your Name");
		
		age = Integer.parseInt(
				EzLog.in("How old are you?"));
		race = new Human();
		cClass = new Warrior();
		setCurrentField(WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);
	} 

	public GameCharacter(String name, int age,int[] fieldCoordinates) {
		this.name = name;
		
		this.age = age;
		race = new Human();
		cClass = new Warrior();
		setCurrentField(WorldMap.getField(fieldCoordinates));
		this.currentField.addCharakter(this);
	}

	public void getAllInfo() {
		String strRace = FormatingOut.getLastPackage(
				race.getClass().getName());
		String strClass = FormatingOut.getLastPackage(
				cClass.getClass().getName());
		
		System.out.println("You are "+name+", a "+age+" year old " +strRace+". Your Class is "+strClass);
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
		resStr = "["+getCharakterPosition()[0]+"|"+getCharakterPosition()[1]+"]";
		return resStr;
	}

	public void switchField(int[] newCoord) {
		this.getCurrentField().removeCharakter(this);
		Field newField = WorldMap.getField(newCoord);
		newField.addCharakter(this);
		setCurrentField(newField);
	}


}
