package World;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


import Test.SuperTest;

public class Test_Other extends SuperTest {
	
	@Test
	public void RandomCharakterTest() {
		int numberOfChars = 5;
		WorldMap.createAndSetRandChars(numberOfChars);
		assertEquals(WorldMap.getNumberOfCharsAtMap(), numberOfChars, "The total number of chartacters is not like the expected");
	}
}
