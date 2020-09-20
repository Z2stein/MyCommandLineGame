package Actions;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CharakterAndAttributes.GameCharacter;
import CharakterAndAttributes.Race.CharRace;
import Test.SuperTest;

public class Test_ChangeField extends SuperTest{

	private GameCharacter mainChar;

	@BeforeClass
	public void Setup() {

		int[] charCoordinates = { 2,2 };

		mainChar = new GameCharacter("testchat",CharRace.Human, 25,charCoordinates);
		Main.Main.setCharacter(mainChar);

	}

	@Test(priority=101)
	public void charDirectionToIntArrayTest() {
		assertEquals(new int[] {0, 1},
				ChangeField.charDirectionToIntArray("n"));
		assertEquals(new int[] {0, 0},
				ChangeField.charDirectionToIntArray("t"));
		assertEquals(new int[] {0, 0},
				ChangeField.charDirectionToIntArray("asdfgt"));
	}

	@DataProvider
	private Object[][] getData_checkIfNewCoord() {
		return new Object[][] {
			{-2,0,true},
			{-3,0,false},
			{2,0,true},
			{3,0,false},
			{0,-2,true},
			{0,-3,false},
			{0,2,true},
			{0,3,false}
		};
	}
	
	@Test(dataProvider = "getData_checkIfNewCoord",priority=102)
	public void checkIfNewCoordinatesValidTest(int x,int y, boolean expected) {

		GameCharacter currentMainCharakter = Main.Main.getCharacter();

		int[] coordinateDelta = { x, y };

		boolean actual =
		ChangeField.checkIfNewCoordinatesValid(coordinateDelta, currentMainCharakter);
		
		assertEquals(actual, expected);

	}

	@Test(priority=104)
	public void moveToTest() throws Exception {
		
		ChangeField.moveTo("n");
		
assertEquals(
		mainChar.getCharakterPosition(),
		new int[] {2,3});
		
		ChangeField.moveTo(mainChar, new int[] {0,-1});
		assertEquals(
				mainChar.getCharakterPosition(),
				new int[] {2,2});
	}
}
