package World.Fields;

import World.Field;

public class Swamp extends Field {
public Swamp(int[] fieldCoordinates) {
	coordinates = fieldCoordinates;
	movementSpeed = -1;
	movementExhausting = +1;
}
}
