package World.Fields;

import World.Field;

public class Desert extends Field {
public Desert(int[] fieldCoordinates) {
	coordinates = fieldCoordinates;
	movementSpeed = -1;
	movementExhausting = +3;
	}
}
