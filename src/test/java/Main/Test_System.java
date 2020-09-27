package Main;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Character.GameCharacter;
import Support.EzLog;
import Test.SuperTest;

public class Test_System extends SuperTest {
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
		  GameRound.nextRound();
	  }
	  
	  String actual = EzLog.getLastConsoleOutput(1);
	  
	  String expect = "tried to exceed";
	  assertTrue(actual.contains(expect),"The actual Console Output '"+actual+"' does not Contain: "+expect);
  }
}
