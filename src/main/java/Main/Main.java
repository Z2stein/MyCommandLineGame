package Main;

import CharakterAndAttributes.GameCharacter;
import CharakterAndAttributes.Class.CharClass;
import CharakterAndAttributes.Race.CharRace;
import Quest.Prolog;
import Support.EzLog;
import World.WorldMap;

public class Main {

	private static Prolog quest;

	private static int fieldSize = 5;
	private static int numbRandCharakters = 10;

	private static GameCharacter character;

	public static void main(String[] args) throws Exception {
		WorldMap.createWorldGrid(fieldSize);
		WorldMap.createAndSetRandChars(numbRandCharakters);

		int[] charCoordinates = { (int) fieldSize / 2, (int) fieldSize / 2 };

		String name = EzLog.in("What is your Name");

		int age = Integer.parseInt(EzLog.in("How old are you?"));

		CharRace race = CharRace.valueOf(EzLog.in("What is Your Race?"));

		character = (new GameCharacter(name, race,CharClass.Warrior, age, charCoordinates));

		character.getAllInfo();

		quest = new Quest.Prolog(character);
		quest.startNewStory();
		String input;
		while (true) {
			input = EzLog.in("What Do You wanna Do?").toLowerCase();

			if (input.equals("exit") || input.equals("quit") || input.equals("exitgame")) {
				break;
			}

			Actions.Basics.doAction(input);
		}
	}

	public static GameCharacter getCharacter() {
		return Main.character;
	}

	public static void setCharacter(GameCharacter mainChar) {
		Main.character = mainChar;
		System.out.println("Main -> setChar");
	}
}
