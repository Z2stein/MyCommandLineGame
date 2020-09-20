package World;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Test.SuperTest;

public class Test_Other extends SuperTest {
	
	@Test
	public void RandomCharakterTest() {
		int numberOfChars = 5;
		//TODO delete
		System.out.println(WorldMap.getNumberOfCharsAtMap());
		
		WorldMap.createAndSetRandChars(numberOfChars);
		//TODO delete
		System.out.println(WorldMap.getNumberOfCharsAtMap());
		
		//TODO Delete
		System.out.println(
		WorldMap.getField(new int[] {0,0}).getCharaktersAtField().size()+"\n"+WorldMap.getNumberOfCharsAtMap()
				);

		assertEquals(WorldMap.getNumberOfCharsAtMap(), numberOfChars, "The total number of chartacters is not like the expected");
	}
}
