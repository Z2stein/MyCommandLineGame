package Character;

import org.testng.annotations.Test;

import Character.GameCharacter;

public class Test_Fight {
  @Test
  public void DoAttack() {
	  
		GameCharacter currChar = GameCharacter.createRandom("TestChar_Main",new int[] {2,2});

		GameCharacter targetChar = GameCharacter.createRandom("TestChar_target",new int[] {2,2});
		

		
		currChar.doAttack(targetChar);
  }
}
