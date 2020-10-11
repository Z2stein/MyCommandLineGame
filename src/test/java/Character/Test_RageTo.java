package Character;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Character.*;
import Character.RageTo.RageAction;
import Main.GameRound;
import Test.SuperTest;

public class Test_RageTo extends SuperTest {
	@Test
	public void attackRage() {
		GameCharacter attackerChar = GameCharacter.createRandom();
		GameCharacter targetChar = GameCharacter.createRandom();

		attackerChar.doAttack(targetChar);

		int actual = targetChar.getRageTo().get(attackerChar).getRageValue();

		int expected = 10;

		assertEquals(actual, expected, "RageValue after Attack not link the expected");
	}

	@Test
	public void RageDecreasing() {
		int[] expecteds = { 30, 27, 24, 22, 20, 18, 16, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		GameCharacter attackerChar = GameCharacter.createRandom();
		GameCharacter targetChar = GameCharacter.createRandom();

		attackerChar.battleAttr.setLifePoints(100);
		targetChar.battleAttr.setLifePoints(100);
		attackerChar.doAttack(targetChar);
		attackerChar.doAttack(targetChar);
		attackerChar.doAttack(targetChar);

		
		int i = 0;
		for (int expected : expecteds) {
			int actual = targetChar.getRageTo().get(attackerChar).getRageValue();
			assertEquals(actual, expected,"This Rage at Round " + i + " is not like The Expected");
			targetChar.getRageTo().get(attackerChar).decreaseRoundBased();
			i++;
		}
		int actual = targetChar.getRageTo().get(attackerChar).getRageValue();
		assertEquals(actual, 0,"This Rage is not like The Expected");

	}

}
