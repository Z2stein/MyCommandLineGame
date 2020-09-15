package World.Fields;

import World.Field;

public class Prairie extends Field {
	
	public Prairie(int[] fieldCoordinates) {
		coordinates = fieldCoordinates;
		movementSpeed = 1;
		movementExhausting = 0;
	}
}
