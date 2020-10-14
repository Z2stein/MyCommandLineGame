package World;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class Test_WorldBuilder {

	
	
	@Test
	public void buildWorld() {
		(new WorldMapBuilder()).setDropRadius(2).setNumbOfDrops(80).setWorldDimension(20).build();
		assertFalse(true);
	}
}
