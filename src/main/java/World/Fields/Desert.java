package World.Fields;

import java.util.ArrayList;

import World.Field;

public class Desert extends Field {
public Desert(int[] fieldCoordinates) {
	charaktersAtField= new ArrayList<>();
	coordinates = fieldCoordinates;
	movementExhausting = +3;
	}
}
