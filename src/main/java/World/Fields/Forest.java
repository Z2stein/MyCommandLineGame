package World.Fields;

import java.util.ArrayList;

import World.Field;

public class Forest extends Field {
	public Forest(int[] fieldCoordinates) {
		charaktersAtField= new ArrayList<>();
		coordinates = fieldCoordinates;
		movementExhausting = 0;
	}
}
