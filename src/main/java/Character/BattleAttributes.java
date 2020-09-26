package Character;

public class BattleAttributes {
	static int basicAttackPoints;
	static int basicLifePoints;
	
	static {
		basicAttackPoints=1;
		basicLifePoints=5;
		
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
	this.lifePoints = character.getCharAttr().getConstitution()/2;
	this.attackPoints = character.getCharAttr().getStrength()/2;

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


}
