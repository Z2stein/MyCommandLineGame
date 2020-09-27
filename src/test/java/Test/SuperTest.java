package Test;

import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Character.GameCharacter;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Support.EzLog;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class SuperTest {

	private static ArrayList<GameCharacter> characters = new ArrayList<>();

	@BeforeSuite
	public void SetUp() {

		EzLog.setExecutionCaseToTest();

		final int fieldSize = 5;

		WorldMap.createWorld(fieldSize);

		System.out
				.println("#####################################\n############################### Suite Setup Finished");
	}

	@BeforeClass
	public void setupClass() {
		System.out.println("## Start TestClass:" + FormatingOut.getLastPackage(this.getClass().getName()) + "  ##");
	}

	@AfterClass
	public void cleanupClass() {
		emptyTheWorldFromChars();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("  -> method name:" + result.getMethod().getMethodName());
	}

	public static GameCharacter getTestChar() {
		GameCharacter character = new GameCharacter("TestChar", CharRace.HUMAN,CharClass.WARRIOR ,24, new int[] { 2, 2 });
		characters.add(character);
		return character;
	}

	public static void removeAllTestCharakters() {
		for (GameCharacter gameCharacter : characters) {
			gameCharacter.removeCharacter();
		}
	}

	public static void emptyTheWorldFromChars() {

		if (WorldMap.getNumberOfCharsAtMap() != 0) {
			Field[][] grid = WorldMap.getGrid();
			for (Field[] fields : grid) {
				for (Field field : fields) {
					field.setCharaktersAtField(new ArrayList<>());
				}
			}
			System.out.println("  -  -> Empty world from all Charakters " + WorldMap.getNumberOfCharsAtMap() + " left");
		}
	}
}
