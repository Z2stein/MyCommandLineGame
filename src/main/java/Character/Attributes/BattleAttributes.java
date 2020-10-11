package Character.Attributes;

import Character.GameCharacter;

public class BattleAttributes {

	private static final int LifeFromConstFactor;
	private static final int LifeFixedAddition;
	private static final int LifeMinInital;

	static {
		LifeFromConstFactor = Main.Settings.BattleAttributes.LIFE_FROM_CONST_FACTOR.getValue();
		LifeFixedAddition = Main.Settings.BattleAttributes.LIFE_FIXED_ADDITION.getValue();
		LifeMinInital = Main.Settings.BattleAttributes.MIN_INIT_LIFE.getValue();
		
		

	}

	private int attackPoints;
	private int lifePoints;

	public BattleAttributes(int attackPoints, int lifePoints) {
		super();
		this.attackPoints = attackPoints;
		this.lifePoints = lifePoints;
	}

	public BattleAttributes(GameCharacter character) {
		super();
		this.lifePoints = LifeFromConstFactor*(character.charAttr.getConstitution())+LifeFixedAddition ;
		this.attackPoints = (character.charAttr.getStrength() / 2+character.charAttr.getDexterity())+1;
		
		if (attackPoints<1) this.attackPoints =1;
		if (lifePoints<LifeMinInital) this.lifePoints = LifeMinInital;
		
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public void modifyLifePoints(int modificationPoints) {
		lifePoints += modificationPoints;
		if (lifePoints < 0) lifePoints = 0;
	}

}
