package Character;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Character.*;
import Character.RageTo.RageAction;
import Test.SuperTest;

public class Test_RageTo extends SuperTest {
	@Test
	public void attackRage() {

		GameCharacter attackerChar = GameCharacter.createRandom();
		GameCharacter targetChar = GameCharacter.createRandom();

		attackerChar.doAttack(targetChar);

		int actual = targetChar.getRageTo().get(attackerChar).getRageValue();
		
		int expected =3;

	  assertEquals(actual, expected,"RageValue after Attack not link the expected");

	}
}
