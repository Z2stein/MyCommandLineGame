package Main.Settings;

public enum BattleAttributes {
	
	
	
	LIFE_FROM_CONST_FACTOR(2),LIFE_FIXED_ADDITION(5),MIN_INIT_LIFE(3);
	;
		private final int value;

		private BattleAttributes(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
	
	
}
