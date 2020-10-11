package Character.Attributes;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Character.GameCharacter;
import Character.Class.CharClass;
import Character.Race.CharRace;
import Test.SuperTest;



public class Test_BattleAttributes extends SuperTest{

	@Test
	public void inital_BattleAttr() {
		GameCharacter character = new GameCharacter("TestChar_BattleAttributes", CharRace.HUMAN, CharClass.WARRIOR, 24 , new int[] {2,2});
		
		int modiRace = CharRace.HUMAN.constitutionModifier;
		int modiClass = CharClass.WARRIOR.constitutionModifier;
		int inital = Main.Settings.Attributes.INITIAL_CONSTITUTION.getValue();
		
		int lifeFactor = Main.Settings.BattleAttributes.LIFE_FROM_CONST_FACTOR.getValue();
		int lifeAddition = Main.Settings.BattleAttributes.LIFE_FIXED_ADDITION.getValue();
		
		
		int constitution = modiClass+modiRace+inital;
		
		int expected = lifeAddition + lifeFactor		*constitution;
		
		int actual = character.battleAttr.getLifePoints();
		
		assertEquals(actual, expected,"The inital LifePoints were not like Expected. ");
		
	}
	
}
