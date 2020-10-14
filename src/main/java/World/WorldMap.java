package World;

import java.util.ArrayList;

import Character.GameCharacter;

public class WorldMap {

	static protected Field[][] grid;
	static protected int[] worldDimension;
	protected static Cemetery cemetery;



	public static Field getField(int[] targetCoordinates) {
		return grid[targetCoordinates[0]][targetCoordinates[1]];
	}

	public static int[] getWorldDimension() {
		return worldDimension;
	}


	public static void createAndSetRandChars(int numberOfRandomChars) {
		for (int i = 0; i < numberOfRandomChars; i++) {
			int[] randCoord = { (int) Math.random() * worldDimension[0], (int) Math.random() * worldDimension[1] };
			GameCharacter.createRandom("RandomChar" + i, randCoord);
		}
	}

	public static Field[][] getGrid() {
		return grid;
	}

	public static int getNumberOfCharsAtMap() {
		int counter = 0;
		for (Field[] fields : grid) {
			for (Field field : fields) {
				ArrayList<GameCharacter> tempChars = field.getCharaktersAtField();
				counter += tempChars.size();
			}
		}
		return counter;
	}
	public static Cemetery getCemetery() {
		return cemetery;
	}
}
