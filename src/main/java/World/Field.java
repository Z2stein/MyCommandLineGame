package World;

import java.util.ArrayList;

import CharakterAndAttributes.GameCharacter;
import World.Fields.Desert;
import World.Fields.Forest;
import World.Fields.Prairie;
import World.Fields.Swamp;

public abstract class Field {
	
	
	protected ArrayList<GameCharacter> charaktersAtField;
	protected int movementExhausting;
	protected int[] coordinates;
	

	public int getMovementExhausting() {
		return movementExhausting;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
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

	public void addCharakter(GameCharacter gameCharacter) {
		
		this.charaktersAtField.add(gameCharacter);
	}
	public void removeCharakter(GameCharacter gameCharacter) {
		charaktersAtField.remove(gameCharacter);
	}

	public ArrayList<GameCharacter> getCharaktersAtField() {
		return charaktersAtField;
	}
	
	public void setCharaktersAtField(ArrayList<GameCharacter> charaktersAtField) {
		this.charaktersAtField = charaktersAtField;
	}

}
