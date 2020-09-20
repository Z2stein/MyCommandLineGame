package World.Fields;

import java.util.ArrayList;

import World.Field;

public class Swamp extends Field {
public Swamp(int[] fieldCoordinates) {
	charaktersAtField= new ArrayList<>();
	coordinates = fieldCoordinates;
	movementExhausting = +1;
}
}
