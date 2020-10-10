package Character;

import java.util.HashMap;

public class RageTo {

	public enum RageAction {
		SPOT(1), ATTACK(10), STEAL(2), MOCK(2);
		final private int rageValue;

		private RageAction(int rageValue) {
			this.rageValue = rageValue;
		}

		public int getRageValue() {
			return rageValue;
		}
	}

	final static private int maxRage;
	final static private int criticalAttackRage;

	private GameCharacter rageOwner, rageTarget;
	private int rageValue;

	static {
		maxRage = Main.Settings.Fight.MAXRAGE.getValue();
		criticalAttackRage=Main.Settings.Fight.CRITICAL_ATTACK_RAGE.getValue();
	}

	public RageTo(GameCharacter rageOwner, GameCharacter rageTarget) {
		super();
		this.rageOwner = rageOwner;
		this.rageTarget = rageTarget;

		rageValue = 0;
	}

	public void increaseRage(int value) {
		rageValue += value;
		if (rageValue > maxRage)
			rageValue = maxRage;
	}

	public int getRageValue() {
		return rageValue;
	}

	public void decreaseRoundBased() {
		if(rageValue==0) return;
		int modification = ((int)(rageValue*0.1+0.5));
		if(modification<1) modification=1;
		rageValue-= modification;
	}
	public static int getCriticalattackrage() {
		return criticalAttackRage;
	}
}
