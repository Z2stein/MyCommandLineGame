package Main;

import Support.EzLog;

public class GameRound {
	public static void nextRound() {
		doWorldRound();
		doBotRound();
		doPlayerRound();
	}

	private static void doPlayerRound() {
		String input = EzLog.in("What Do You wanna Do?").toLowerCase();
		if (input.equals("exit") || input.equals("quit") || input.equals("exitgame")) {
			System.exit(0);
		}
		
		Actions.Basics.doAction(input);
	}

	private static void doBotRound() {
		// TODO Auto-generated method stub
		
	}

	private static void doWorldRound() {
		// TODO Auto-generated method stub
		
	}
}
