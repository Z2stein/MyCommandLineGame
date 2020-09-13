package CharakterAndAttributes;

import CharakterAndAttributes.Race.Human;
import CharakterAndAttributes.Race.Warrior;
import Support.EzLog;

public class GameCharacter {
	private String name;
	private int age;
	private CharRace race;
	private Charclass cClass;
	//TODO
	
	public GameCharacter() {
		this.name = EzLog.in("What is your Name");
		
		age = Integer.parseInt(
				EzLog.in("How old are you?"));
		race = new Human();
		cClass = new Warrior();
	}

	public void getAllInfo() {
		String strRace = getLastPackage(
				race.getClass().getName());
		String strClass = getLastPackage(
				cClass.getClass().getName());
		
		System.out.println("You are "+name+", a "+age+" year old " +strRace+". Your Class is "+strClass);
	}

	private String getLastPackage(String strRace) {
		String resStr
		=strRace.substring(strRace.indexOf('.')+1);
		if (strRace!=resStr) {
			resStr=getLastPackage(resStr);
		}
		return resStr;
	}
}
