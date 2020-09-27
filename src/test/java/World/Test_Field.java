package World;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

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
		character = new GameCharacter("TestChar", CharRace.HUMAN, CharClass.WARRIOR, 24, new int[] { 0, 0 });
		assertEquals(field.getCharaktersAtField().size(), 1);
	}

	@Test(dependsOnMethods = "addCharakterTest")
	public void diffCharAtDiffFields() {
		Field field1 = WorldMap.getField(new int[] { 0, 0 });
		assertEquals(field1, field);

		Field field2 = WorldMap.getField(new int[] { 0, 1 });
		assertFalse(field1.getCharaktersAtField().size() == 0, "No Charakter @ Fileds");
		assertNotEquals(field1.getCharaktersAtField(), field2.getCharaktersAtField(),
				"Same CharakterArrayList at different Fields");
	}

	@Test(dependsOnMethods = "diffCharAtDiffFields")
	public void removeCharakterTest() {
		field.removeCharakter(character);
		assertEquals(field.getCharaktersAtField().size(), 0);
	}

	@Test(dependsOnMethods = "removeCharakterTest")
	public void addMultiChar() {
		int numberOfChars = 100;
		field = WorldMap.getField(new int[] { 0, 0 });
		for (int i = 0; i < numberOfChars; i++) {
			character = new GameCharacter("TestChar" + i, CharRace.HUMAN, CharClass.WARRIOR, 24, new int[] { 0, 0 });
		}
		assertEquals(field.getCharaktersAtField().size(), numberOfChars);
	}

	@Test
	public void removeChar() {
		GameCharacter character = GameCharacter.createRandom();

		Field field = character.getCurrentField();

		character.removeCharacter();
		ArrayList<GameCharacter> allChars = GameCharacter.getAllCharacters();

		int actual = (int) allChars.stream().filter(s -> character.equals(s)).count();
		assertEquals(actual, 0, "The Charakter is in GameCharacter.allCharacters left, and was not deleted");

		actual = (int) field.charaktersAtField.stream().filter(s -> character.equals(s)).count();
		assertEquals(actual, 0, "The Charakter is in the origin filed left, and was not deleted");

	}

}
