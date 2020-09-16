package World.Fields;

import World.Field;

public class Desert extends Field {
public Desert(int[] fieldCoordinates) {
	coordinates = fieldCoordinates;
	movementExhausting = +3;
	}
}
