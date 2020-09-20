package World;

import CharakterAndAttributes.GameCharacter;
import Support.FormatingOut;

public class WorldMap {

	static private Field[][] grid;
	static private int worldDimension;

	static public void createWorldGrid(int size) {
		worldDimension = size;
		grid = new Field[size][size];
		int chooseInt;
		int x = 0;
		int y=0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
				chooseInt = (int) (Math.random() * 4); 
				int[] coordinates = {x,y};
				grid[i][j] = Field.createField(chooseInt,coordinates);
				grid[i][j] .setCoordinates(coordinates);
				y++;
			}
			y=0;
			x++;
		}
	}
	
    public static Field getField(int[] targetCoordinates) {
    	return grid[targetCoordinates[0]][targetCoordinates[1]];
	}

    public static int getWorldDimension() {
		return worldDimension;
	}

	public static void setWorldDimension(int worldDimension) {
		WorldMap.worldDimension = worldDimension;
	}

	public static void createAndSetRandChars(int n) {
		for (int i = 0; i < n; i++) {
			int[] randCoord =	{(int) Math.random()*worldDimension,(int) Math.random()*worldDimension};
			//TODO delete
			System.out.println("++++"+WorldMap.getNumberOfCharsAtMap());
			GameCharacter.createRandom("RandomChar"+i, randCoord);
			grid=grid;
			//TODO delete
			System.out.println("++++"+WorldMap.getNumberOfCharsAtMap());
			
		} 
	}

	public static Field[][] getGrid() {
		return grid;
	}

	public static int getNumberOfCharsAtMap() {
		int counter = 0;
		Field[][] grid = WorldMap.getGrid();
		for (Field[] fields : grid) {
			for (Field field : fields) {
				counter += field.getCharaktersAtField().size();
			}
		}	
		return counter;
	}
}
