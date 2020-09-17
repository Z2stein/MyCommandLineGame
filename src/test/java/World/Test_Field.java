package World;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import CharakterAndAttributes.GameCharacter;
import Test.SuperTest;

public class Test_Field extends SuperTest {
	private GameCharacter character;
	private Field field;

	@AfterClass()
	public void cleanUp() {
	field.setCharaktersAtField(new ArrayList<GameCharacter>());
	}
	
	
	@Test(priority = 101)
	public void addCharakterTest() {
		field = WorldMap.getField(new int[] { 0, 0 });
		character = new GameCharacter("TestChar", 24, new int[] { 0, 0 });
		Assert.assertEquals(field.getCharaktersAtField().size(), 1);
	}

	@Test(priority = 102)
	public void removeCharakterTest() {
		field.removeCharakter(character);
		Assert.assertEquals(field.getCharaktersAtField().size(), 0);
	}
	@Test(priority= 103)
	public void addMultiChar() {
		int numberOfChars=100;
		field = WorldMap.getField(new int[] { 0, 0 });
		for (int i = 0; i < numberOfChars; i++) {
			character = new GameCharacter("TestChar"+i, 24, new int[] { 0, 0 });
		}
		Assert.assertEquals(field.getCharaktersAtField().size(), numberOfChars);
		
	}

}
