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
	  
	  int expected = CharacterAttributes.getInitalConstitution()+character.getCharAction().get(0).getConstitutionmodifier() +  character.getCharAction().get(1).getConstitutionmodifier();
  
	  int actual = character.getCharAttr().getConstitution();
	  
	  
	  assertEquals(actual, expected);
  }
}
