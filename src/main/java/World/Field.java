package World;

import World.Fields.Desert;
import World.Fields.Forest;
import World.Fields.Prairie;
import World.Fields.Swamp;

public abstract class Field {
	
	protected int movementSpeed;
	protected int movementExhausting;
	protected int[] coordinates;
	
	public int getMovementSpeed() {
		return movementSpeed;
	}
	
	public int getMovementExhausting() {
		return movementExhausting;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	
	static public Field createField(int chooseInt, int[] fieldCoordinates) {
		
		Field type;
		
		switch (chooseInt) {
			case 0:
				return new Desert(fieldCoordinates);
			case 1:
				return new Forest(fieldCoordinates);
			case 2:
				return new Swamp(fieldCoordinates);
			case 3:
				return new Prairie(fieldCoordinates);
			default:
				return null;
		}
	}


}
