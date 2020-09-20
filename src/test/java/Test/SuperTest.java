package Test;

import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import CharakterAndAttributes.GameCharacter;
import CharakterAndAttributes.Race.CharRace;
import Support.FormatingOut;
import World.Field;
import World.WorldMap;

public class SuperTest {

	// TODO Problem while Executing all test form XML an once

	private static ArrayList<GameCharacter> characters = new ArrayList<>();

	@BeforeSuite
	public void SetUp() {

		final int fieldSize = 5;

		WorldMap.createWorldGrid(fieldSize);

		System.out
				.println("#####################################\n############################### Suite Setup Finished");
	}

	@BeforeClass
	public void setupClass() {
		System.out.println("## Start TestClass:" + FormatingOut.getLastPackage(this.getClass().getName()) + "  ##");
		
		//TODO delete
			System.out.println("There are "+WorldMap.getNumberOfCharsAtMap()+" Charakters Left on Map");
		
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
		GameCharacter character = new GameCharacter("TestChar", CharRace.Human, 24, new int[] { 2, 2 });
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
			ArrayList<GameCharacter> charaktersAtField = new ArrayList<>();

			for (Field[] fields : grid) {
				for (Field field : fields) {
					field.setCharaktersAtField(charaktersAtField);
					//TODO delete
					System.out.println(WorldMap.getNumberOfCharsAtMap());
					//TODO delete
					if (field.getCharaktersAtField().size()!=0) {
					System.out.println("Still  "+field.getCharaktersAtField().size()+" char at field");
					}
				}
			}
			System.out.println("  -  -> Empty world from all Charakters "+WorldMap.getNumberOfCharsAtMap() +" left");
		}
	}
}
