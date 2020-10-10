package Character;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import javax.swing.RepaintManager;

import org.testng.Reporter;
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
		int expectedLifeP, expectedAttack;

		expectedAttack = currChar.battleAttr.getAttackPoints();

		expectedLifeP = targetChar.battleAttr.getLifePoints();

		currChar.doAttack(targetChar);

		int actual = targetChar.battleAttr.getLifePoints();

		assertEquals(actual, expectedLifeP - expectedAttack);
		Reporter.log("Testcase Ended with " + actual + " LifePoints");
	}

	@Test(dependsOnMethods = "doAttack")
	public void counterAttack() {
		int expectedLifeP, expectedAttack;
		
		expectedAttack = targetChar.battleAttr.getAttackPoints();

		expectedLifeP = currChar.battleAttr.getLifePoints();
		
		Main.GameRound.doBotRound();

		int actual = currChar.battleAttr.getLifePoints();

		assertEquals(actual, expectedLifeP - expectedAttack);


	}

	@Test(dependsOnMethods = "counterAttack")
	public void killChar() {
		for (int i = 0; i < 20; i++) {
			currChar.doAttack(targetChar);
//			TODO Delete
			int is = targetChar.battleAttr.getLifePoints();
			if (targetChar.battleAttr.getLifePoints() == 0)
				break;
		}

		assertEquals(targetChar.battleAttr.getLifePoints(), 0, "LifePoints by Killing:");
		String expected = "is dead";
		assertTrue(EzLog.getLastConsoleOutput().contains(expected), "The Output Massage is not like expected");

		assertEquals(targetChar.getCurrentField(), WorldMap.getCemetery());

		assertNotNull(GameCharacter.getAllCharacters().stream().filter(s -> targetChar.equals(s)).findFirst().get(),
				"Char was deletet from GameCharacter.allCharacters");
	}

}
