package World.Fields;

import java.util.ArrayList;

import World.Field;

public class Prairie extends Field {
	
	public Prairie(int[] fieldCoordinates) {
		charaktersAtField= new ArrayList<>();
		coordinates = fieldCoordinates;
		movementExhausting = 0;
	}
}
