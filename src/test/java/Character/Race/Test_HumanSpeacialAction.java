package Character.Race;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Character.GameCharacter;
import Main.Main;
import Support.EzLog;
import Test.SuperTest;
import Test.TestOutput;

public class Test_HumanSpeacialAction extends SuperTest implements TestOutput {
	@BeforeClass
	public void createMainCharacter() {
		GameCharacter character = GameCharacter.createRandom();
		character.setBot(false);
		Main.setCharacter(character);
	}
@Test
	public void talkNonsence() {

		// TODO write this test

		Main.getCharacter().doAction("Talk Nonsence");

		checkIfTextInConsole(3, new String[] { "nonsense", "nobody", "listen" });

	}

}
