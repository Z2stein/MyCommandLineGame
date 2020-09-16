package World;

import Support.FormatingOut;

public class WorldMap {

	static private Field[][] grid;
	static private int worldDimension;

	static public void createWorldGrid(int size) {
		worldDimension = size;
		grid = new Field[size][size];
		int chooseInt;
		int x = 0,y=0;;
		for (Field[] fieldX : grid) {
			for (Field fieldY : fieldX) {
				chooseInt = (int) (Math.random() * 4); 
				int[] coordinates = {x,y};
				fieldY = Field.createField(chooseInt,coordinates);
				fieldY.setCoordinates(coordinates);
				y++;
			}
			x++;
		}
	}
	
    public static Field getField(int[] targetCoordinates) {
    	return grid[targetCoordinates[0]][targetCoordinates[1]];
	}

    public static int getWorldDimension() {
		return worldDimension;
	}
}
