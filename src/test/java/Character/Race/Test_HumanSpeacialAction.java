package Character.Race;

import Character.GameCharacter;
import Main.Main;
import Test.SuperTest;
import Test.TestOutput;

public class Test_HumanSpeacialAction extends SuperTest implements TestOutput {
	
	
	public void talkNonsence() {
		//TODO write this test
		  GameCharacter character = GameCharacter.createRandom();
		  character.setBot(false);
		  Main.setCharacter(character);
		  
		  
		
	}
	
}
