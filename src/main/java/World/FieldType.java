package World;

public enum FieldType {

	
	
	SWAMP(0),
	FOREST(1),
	PRARIE(2),
	DESERT(3),
	CEMETERY(66),
	;

	private final int chooseInt;
	
	
	
	
	private FieldType(int chooseInt) {
		this.chooseInt = chooseInt;
	}




	public static FieldType getType(int i) {
		for(FieldType typ:FieldType.values())
		{
			if (typ.chooseInt==i) return typ;
		}
		return null;
	}


}
