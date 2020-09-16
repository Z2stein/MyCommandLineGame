package Main;
import CharakterAndAttributes.GameCharacter;
import Quest.Prolog;
import Support.EzLog;
import World.WorldMap;

public class Main {
	private static GameCharacter character;
	
	private static Prolog quest;

	private static int fieldSize=5;
	
	public static GameCharacter getCharacter() {
		return character;
	}
	
	public static void main(String[] args) throws Exception {
		WorldMap.createWorldGrid(fieldSize);

		int[] charCoordinates = {(int)fieldSize/2,(int)fieldSize/2};
		
		character = new GameCharacter(charCoordinates);
		
		character.getAllInfo();
		
		quest = new Quest.Prolog(character);
		quest.startNewStory();
		String input;
		while(true) {
			input=EzLog.in("What Do You wanna Do?").toLowerCase();
			
			if (input.equals("exit")||input.equals("quit")||input.equals("exitgame")) {
				break;
			}
			
			Actions.Basics.doAction(input);
		}
	}
}
