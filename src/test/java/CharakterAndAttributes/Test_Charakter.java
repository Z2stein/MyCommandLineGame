package CharakterAndAttributes;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Test.SuperTest;

public class Test_Charakter extends SuperTest {
	GameCharacter character;

	@Test
	public void TestCharAttributesNotNull() {
		character = SuperTest.getTestChar();

		assertNotNull(character.getRace(), "CharRace == Null");
		assertNotNull(character.getAge(), "Char Age == Null");
		assertNotNull(character.getCurrentField(), "Char Field == Null");
		assertNotNull(character.getName(), "Char name == Null");
		assertNotNull(character.getcClass(), "Char cClass == Null");
		assertNotNull(character.getChrActClass(), "Char ActionClass == Null");

	}

	@AfterClass
	public void cleanup() {
		character.getCurrentField().removeCharakter(character);
	}
}
