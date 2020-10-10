package Main;

import Character.GameCharacter;
import Support.EzLog;

public class GameRound {
	public static void nextRound() {
		doWorldRound();
		doBotRound();
		doPlayerRound();
	}

	private static void doPlayerRound() {
		String input = EzLog.in("What Do You wanna Do?");
		if (input.equals("exit") || input.equals("quit") || input.equals("exitgame")) {
			System.exit(0);
		}
		Main.getCharacter().doAction(input);
	}

	public static void doBotRound() {
		for (GameCharacter character:GameCharacter.getAllCharacters()) {
			character.nextRound();
		}
	}

	private static void doWorldRound() {
		// TODO Auto-generated method stub
		
	}
}
