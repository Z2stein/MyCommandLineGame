package World.Fields;

import World.Field;

public class Forest extends Field {
	public Forest(int[] fieldCoordinates) {
		coordinates = fieldCoordinates;
		movementExhausting = 0;
	}
}
