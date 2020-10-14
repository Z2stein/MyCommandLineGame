package World;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class Test_WorldBuilder {

	
	
	@Test
	public void buildWorld() {
		(new WorldMapBuilder()).setWorldDimension(5).setDropRadius(2).setNumbOfDrops(80).build();
		assertFalse(true);
	}
}
