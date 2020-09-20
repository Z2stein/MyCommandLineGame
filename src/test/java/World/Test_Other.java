package World;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import CharakterAndAttributes.GameCharacter;
import Test.SuperTest;

public class Test_Other extends SuperTest {
	@Test
	public void RandomCharakterTest() {
		int numberOfChars = 5;

		WorldMap.createAndSetRandChars(numberOfChars);
		int counter = 0;

		Field[][] grid = WorldMap.getGrid();

		for (Field[] fields : grid) {
			for (Field field : fields) {
				counter += field.getCharaktersAtField().size();
			}
		}

		assertEquals(counter, numberOfChars, "The total number of chartacters is not like the expected");
	}

	@AfterClass
	public void clearUp() {
		Field[][] grid = WorldMap.getGrid();
		ArrayList<GameCharacter> charaktersAtField = null;

		for (Field[] fields : grid) {
			for (Field field : fields) {
				field.setCharaktersAtField(charaktersAtField);
			}
		}
	}
}
