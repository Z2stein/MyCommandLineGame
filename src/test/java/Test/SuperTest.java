package Test;

import java.util.ArrayList;

import org.testng.annotations.BeforeSuite;

import CharakterAndAttributes.GameCharacter;
import CharakterAndAttributes.Race.CharRace;
import World.WorldMap;
public class SuperTest {

	//TODO Problem while Executing all test form XML an once 
	
	private static ArrayList<GameCharacter> characters = new ArrayList<>();
	
	@BeforeSuite
	public void SetUp() {

		final int fieldSize = 5;

		WorldMap.createWorldGrid(fieldSize);

		System.out.println("#####################################\n############################### Setup Finished");
}

	public static GameCharacter getTestChar() {
				GameCharacter character = new GameCharacter("TestChar", CharRace.Human	, 24	, new int[] {2,2});
				characters.add(character);
		return character;
	}
	
	public static void removeAllTestCharakters() {
		for (GameCharacter gameCharacter : characters) {
			gameCharacter.removeCharacter();
		}
	}
}
