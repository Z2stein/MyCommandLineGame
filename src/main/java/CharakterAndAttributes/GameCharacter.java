package CharakterAndAttributes;

import CharakterAndAttributes.Race.Human;
import CharakterAndAttributes.Race.Warrior;
import Support.EzLog;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class GameCharacter {
	private String name;
	private int age;
	private CharRace race;
	private Charclass cClass;
	private Field currentField;
	//TODO
	
	public GameCharacter(int[] fieldCoordinates) {
		this.name = EzLog.in("What is your Name");
		
		age = Integer.parseInt(
				EzLog.in("How old are you?"));
		race = new Human();
		cClass = new Warrior();
		setCurrentField(WorldMap.getField(fieldCoordinates));
	}

	public GameCharacter(String name, int age,int[] fieldCoordinates) {
		this.name = name;
		
		this.age = age;
		race = new Human();
		cClass = new Warrior();
		setCurrentField(WorldMap.getField(fieldCoordinates));

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


}
