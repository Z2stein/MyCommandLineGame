package Actions;

import static org.testng.Assert.assertEquals;

import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CharakterAndAttributes.GameCharacter;
import World.WorldMap;

public class Test_ChangeField{

	@BeforeClass
	public void Setup() {

		final int fieldSize = 5;

		WorldMap.createWorldGrid(fieldSize);

		int[] charCoordinates = { 2,2 };

		Main.Main.setCharacter(new GameCharacter("testchat", 25,charCoordinates));

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
		
		Assert.assertEquals(actual, expected);

	}

	@Test(priority=103)
	public void moveToTest() {
		throw new RuntimeException("Test not implemented");
	}
}
