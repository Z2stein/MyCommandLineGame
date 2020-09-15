import CharakterAndAttributes.GameCharacter;
import Quest.Prolog;
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
	}
}
