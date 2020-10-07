package Character.Attributes;

import Character.GameCharacter;

public class BattleAttributes {
	static int basicAttackPoints;
	static int basicLifePoints;

	static {
		basicAttackPoints = 1;
		basicLifePoints = 15;

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
		this.lifePoints = 2*(character.charAttr.getConstitution()+5) ;
		this.attackPoints = (character.charAttr.getStrength() / 2+character.charAttr.getDexterity())+1;
		
		if (attackPoints<1) this.attackPoints =1;
		if (lifePoints<1) this.lifePoints =1;
		
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
