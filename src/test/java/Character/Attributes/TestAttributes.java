package Character.Attributes;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Character.GameCharacter;
import Test.SuperTest;

public class TestAttributes extends SuperTest {
  @Test
  public void initalConstitution() {
	  GameCharacter character =
	  GameCharacter.createRandom("TestCharacter", new int[] {2,2});
	  
	  int expected = CharacterAttributes.initalConstitution+character.race.constitutionModifier +  character.cClass.constitutionModifier;
  
	  int actual = character.charAttr.getConstitution();
	  
	  
	  assertEquals(actual, expected);
  }
}
