package Character;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Test.SuperTest;

public class Test_Charakter extends SuperTest {
	GameCharacter character;

	@Test
	public void TestCharAttributesNotNull() {
		character = SuperTest.getTestChar();

	assertNotNull(character.race, "CharRace == Null");
		assertNotNull(character.getAge(), "Char Age == Null");
		assertNotNull(character.getCurrentField(), "Char Field == Null");

		//TODO add New
	}

	@AfterClass
	public void cleanup() {
		character.getCurrentField().removeCharakter(character);
	}
}
