package World;

import java.util.ArrayList;

import Character.GameCharacter;

public class Field {

//	############################################################
//	##############  Private Variables   ########################
	ArrayList<GameCharacter> charaktersAtField;
	private int[] coordinates;
	private FieldType fieldType;
	
	
	
//	############################################################
//	##############  Constructor         ########################
	
	
	public Field(int[] coordinates, FieldType fieldType) {
		super();
		this.coordinates = coordinates;
		this.fieldType = fieldType;
		this.charaktersAtField = new ArrayList<>();
	}
	
	
	
//	############################################################
//	##############  Methods             ########################

	
	
	
	
	
	




	public void addCharakter(GameCharacter gameCharacter) {
		this.charaktersAtField.add(gameCharacter);
	}

	public void removeCharakter(GameCharacter gameCharacter) {
		charaktersAtField.remove(gameCharacter);
	}
	
//	############################################################
//	##############  Getters and Setters  #######################
	

	public int[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}


	public ArrayList<GameCharacter> getCharaktersAtField() {
		return charaktersAtField;
	}

	public void setCharaktersAtField(ArrayList<GameCharacter> charaktersAtField) {
		this.charaktersAtField = charaktersAtField;
	}

}
