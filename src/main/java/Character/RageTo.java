package Character;

import java.util.HashMap;

public class RageTo {

	public enum RageAction {
		SPOT(1), ATTACK(3), STEAL(2), MOCK(2);
		
		private static int rageValue;

		private RageAction(int rageValue) {
		}

		public int getRageValue() {
			return rageValue;
		}
	}

	private GameCharacter rageOwner, rageTarget;
	private int rageValue;

	public RageTo(GameCharacter rageOwner, GameCharacter rageTarget) {
		super();
		this.rageOwner = rageOwner;
		this.rageTarget = rageTarget;

		rageValue = 3;
	}


	public void increaseRage(int value) {
		rageValue += value;
	}
	
	public int getRageValue() {
		return rageValue;
	}

}
