import CharakterAndAttributes.GameCharacter;
import Quest.Prolog;
import Support.EzLog;
import World.WorldMap;

public class Main {
	private static Prolog quest;

	private static int fieldSize=5;
	
	public static void main(String[] args) {
		WorldMap.createWorldGrid(fieldSize);

		int[] charCoordinates = {(int)fieldSize/2,(int)fieldSize/2};
		
		GameCharacter character = new GameCharacter(charCoordinates);
		
		character.getAllInfo();
		
		quest = new Quest.Prolog(character);
		quest.startNewStory();
		String input;
		while(true) {
			input=EzLog.in("What Do You Whanna Do?");
			if (input.equals("exit")||input.equals("quit")||input.equals("exitgame")) {
				break;
			}
			Actions.Basics.doAction(input);
		}
	}
}
