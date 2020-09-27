package World;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;


import org.testng.annotations.Test;

import Character.GameCharacter;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Test.SuperTest;

public class Test_Field extends SuperTest {
	private GameCharacter character;
	private Field field;


	public void clearupAfterMethode() {
		
	}
	
	@Test
	public void addCharakterTest() {
		field = WorldMap.getField(new int[] { 0, 0 });
		character = new GameCharacter("TestChar", CharRace.Human,CharClass.Warrior,24, new int[] { 0, 0 });
		assertEquals(field.getCharaktersAtField().size(), 1);
	}
	
	@Test(dependsOnMethods = "addCharakterTest")
	public void diffCharAtDiffFields() {
		//TODO DElete
		System.out.println("hallo");
		
		Field field1 = WorldMap.getField(new int[] { 0, 0 });
		assertEquals(field1, field);
		
		Field field2 = WorldMap.getField(new int[] { 0, 1 });
	assertFalse(field1.getCharaktersAtField().size()==0,"No Charakter @ Fileds");
		assertNotEquals(field1.getCharaktersAtField(), field2.getCharaktersAtField(),"Same CharakterArrayList at different Fields");
	}
	
	@Test(dependsOnMethods="diffCharAtDiffFields")
	public void removeCharakterTest() {
		field.removeCharakter(character);
		assertEquals(field.getCharaktersAtField().size(), 0);
	}
	@Test(dependsOnMethods="removeCharakterTest")
	public void addMultiChar() {
		int numberOfChars=100;
		field = WorldMap.getField(new int[] { 0, 0 });
		for (int i = 0; i < numberOfChars; i++) {
			character = new GameCharacter("TestChar"+i,CharRace.Human,CharClass.Warrior, 24, new int[] { 0, 0 });
		}
		assertEquals(field.getCharaktersAtField().size(), numberOfChars);
	}

}
