package Character;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Support.EzLog;
import Test.SuperTest;
import World.WorldMap;

public class Test_Fight extends SuperTest {


	GameCharacter currChar, targetChar;

	@BeforeClass
	public void SetupFightChars() {
		currChar = GameCharacter.createRandom("TestChar_Main", new int[] { 2, 2 });
		targetChar = GameCharacter.createRandom("TestChar_target", new int[] { 2, 2 });

	}

	@Test
	public void doAttack() {
		int expectedLifeP;
		int expectedAttack;

		expectedAttack = currChar.getBattleAttr().getAttackPoints();

		expectedLifeP = targetChar.getBattleAttr().getLifePoints();

		currChar.doAttack(targetChar);

		int actual = targetChar.getBattleAttr().getLifePoints();

		assertEquals(actual, expectedLifeP - expectedAttack);
	}

	@Test
	public void killChar() {
		for (int i = 0; i < 20; i++) {
			currChar.doAttack(targetChar);
			if (targetChar.getBattleAttr().getLifePoints() == 0)
				break;
		}

		assertEquals(targetChar.getBattleAttr().getLifePoints(), 0, "LifePoints by Killing:");
		String expected = "is dead";
		assertTrue(EzLog.getLastConsoleOutput().contains(expected), "The Output Massage is not like expected");

		assertEquals(targetChar.getCurrentField(), WorldMap.getCemetery());

		assertNotNull(GameCharacter.getAllCharacters().stream().filter(s -> targetChar.equals(s)).findFirst().get(),
				"Char was deletet from GameCharacter.allCharacters");
	}

}
