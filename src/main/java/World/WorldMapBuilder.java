package World;

import java.util.Arrays;

public class WorldMapBuilder extends WorldMap {

	static private int dropRadius;
	static private int numbOfDrops;
	static private double[][] doubleValueGrid;
	static private int[][] intValueGrid;

	public void build() {
		initalizeValueGrid();
		rain();
		// TODO make this function generic
		printOutGrid(intValueGrid);
		addFields();
	}

	private void addFields() {
		cemetery = new Cemetery(null, FieldType.CEMETERY);
		grid = new Field[worldDimension[0]][worldDimension[1]];

		for (int i = 0; i < intValueGrid.length; i++) {
			for (int j = 0; j < intValueGrid[0].length; j++) {
				grid[i][j] = new Field(new int[] { i, j }, FieldType.getType(intValueGrid[i][j]));
			}
		}

	}

	private static <T> void printOutGrid(int[][] intValueGrid2) {
		System.out.print("\n###");
		for (int i = 0; i < intValueGrid2[0].length; i++) {
			System.out.print("+-" + (i + 1) + "-");
		}

		for (int i = 0; i < intValueGrid2.length; i++) {
			System.out.print("\n" + (1 + i) + " #");
			for (int j = 0; j < intValueGrid2[0].length; j++) {
				System.out.printf("|%.1f", (1 + (double) intValueGrid2[i][j]));
			}
			System.out.print("\n###");
			Arrays.stream(intValueGrid2[0]).forEach(s -> System.out.print("+---"));
		}

		System.out.println("");
	}

	private static void initalizeValueGrid() {
		doubleValueGrid = new double[worldDimension[0]][worldDimension[1]];
		for (int i = 0; i < doubleValueGrid.length; i++) {
			for (int j = 0; j < doubleValueGrid[0].length; j++) {
				doubleValueGrid[i][j] = 0;
			}
		}
	}

	public WorldMapBuilder setWorldDimension(int worldDimension) {
		setWorldDimension(new int[] { worldDimension, worldDimension });
		return this;
	}

	public WorldMapBuilder setWorldDimension(int[] worldDim) {
		WorldMap.worldDimension=worldDim;
		return this;
	}

	public WorldMapBuilder setDropRadius(int dropRadius) {
		WorldMapBuilder.dropRadius = dropRadius;
		return this;
	}

	public WorldMapBuilder setNumbOfDrops(int numbOfDrops) {
		WorldMapBuilder.numbOfDrops = numbOfDrops;
		return this;
	}

	private static void rain() {

		doubleValueGrid = new double[worldDimension[0]][worldDimension[1]];
		intValueGrid = new int[worldDimension[0]][worldDimension[1]];

		for (int i = 0; i < numbOfDrops; i++) {
			int randomPositionX = (int) (Math.random() * worldDimension[0]);
			int randomPositionY = (int) (Math.random() * worldDimension[1]);

			double randomValue = Math.random();

			dropFall(randomValue, randomPositionX, randomPositionY);
		}

		for (int i = 0; i < doubleValueGrid.length; i++) {
			for (int j = 0; j < doubleValueGrid[0].length; j++) {
				intValueGrid[i][j] = (int) (doubleValueGrid[i][j] + 0.5);
			}
		}

	}

	private static void dropFall(double randomValue, int randomPositionX, int randomPositionY) {
		int startX, endX, startY, endY;

		startX = randomPositionX - dropRadius;
		if (startX < 0)
			startX = 0;
		startY = randomPositionY - dropRadius;
		if (startY < 0)
			startY = 0;
		endX = randomPositionX + dropRadius;
		if (endX > worldDimension[0])
			endX = worldDimension[0];
		endY = randomPositionY + dropRadius;
		if (endY > worldDimension[0])
			endY = worldDimension[0];

		for (int i = 0; i < doubleValueGrid.length; i++) {
			if (i >= startX && i < endX) {
				for (int j = 0; j < doubleValueGrid[0].length; j++) {
					if (j >= startY && j < endY) {
						doubleValueGrid[i][j] += randomValue;
					}
				}
			}
		}

	}

}
