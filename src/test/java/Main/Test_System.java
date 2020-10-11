package Main;

import org.testng.annotations.Test;

import Character.GameCharacter;
import Support.EzLog;
import Test.SuperTest;
import Test.TestOutput;

public class Test_System extends SuperTest implements TestOutput{
  @Test
  public void exceedingTheMapf() {
	  GameCharacter character = GameCharacter.createRandom();
	  character.setBot(false);
	  Main.setCharacter(character);
	  
	  String[] commands = {
			  "moveto n",
			  "moveto n",
			  "moveto n"
	  };
	  
	  EzLog.setTestInArguments(commands);
	  
	  for (int i = 0;i<3;i++) {
		  EzLog.setTestInArgsCounter(i);
		  GameRound.doPlayerRound();
	  }
	  
	  checkIfTextInConsole(3, new String[] {"exceed","Map","tried"});
  }
}
