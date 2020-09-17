package Test;

import org.testng.annotations.BeforeSuite;

import World.WorldMap;

public class SuperTest {

	@BeforeSuite
	public void SetUp() {

		final int fieldSize = 5;

		WorldMap.createWorldGrid(fieldSize);
}
}
