package Main.Settings;

public enum Fight {
MAXRAGE(50), CRITICAL_ATTACK_RAGE(10)
;
	private final int value;

	private Fight(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
