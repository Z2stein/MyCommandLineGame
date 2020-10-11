package Main.Settings;

public enum Attributes {
	
	INITIAL_STRENGTH(0),
	INITIAL_CONSTITUTION(5),
	INITIAL_DEXTERITY(0),
	INITIAL_INTELLIGENCE(0),
	INITIAL_WISDOM(0),
	INITIAL_CHARISMA(0)
;

	private final int value;
	

		private Attributes(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
	
	
}