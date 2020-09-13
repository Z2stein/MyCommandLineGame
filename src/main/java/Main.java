import CharakterAndAttributes.GameCharacter;
import Quest.Prolog;

public class Main {
	private static Prolog quest;

	public static void main(String[] args) {
		GameCharacter character = new GameCharacter();
		
		character.getAllInfo();
		
		quest = new Quest.Prolog(character);
		quest.startNewStory();
	}
}
