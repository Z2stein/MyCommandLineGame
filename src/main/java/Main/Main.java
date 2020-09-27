package Main;

import Character.GameCharacter;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Support.EzLog;
import World.WorldMap;

public class Main {


	private static int fieldSize = 5;

	private static GameCharacter character;

	public static void main(String[] args) throws Exception {
		WorldMap.createWorld(fieldSize);

		character = createPlayserCharacter();

		while (true) {
			GameRound.nextRound();
		}
	}

	private static GameCharacter createPlayserCharacter() {
		int[] charCoordinates = { (int) fieldSize / 2, (int) fieldSize / 2 };
		boolean validEntries = false;

		String name = EzLog.in("What is your Name");

		int age = Integer.parseInt(EzLog.in("How old are you?"));

//get Race From Player
		CharRace race = null;
		while (!validEntries) {
			try {
				race = CharRace.valueOf(EzLog.in("What is Your Race?").toUpperCase());
				validEntries = true;
			} catch (IllegalArgumentException e) {
				EzLog.log("This is not a Valid Race", 'e');
			}
		}

// get Class from Player
		validEntries = false;
		CharClass cClass = null;
		while (!validEntries) {
			try {
				cClass = CharClass.valueOf(EzLog.in("What is Your Class?").toUpperCase());
				validEntries = true;
			} catch (IllegalArgumentException e) {
				EzLog.log("This is not a Valid Class", 'e');
			}
		}

		character = (new GameCharacter(name, race, cClass, age, charCoordinates));
		character.getAllInfo();
		character.setBot(false);
		return character;
	}

	public static GameCharacter getCharacter() {
		return Main.character;
	}

	public static void setCharacter(GameCharacter mainChar) {
		Main.character = mainChar;
		System.out.println("Main -> setChar");
	}
}
