package Character.Class;

public enum CharClass {
	WARRIOR(0,0,0);
	
	/**
	 *  measuring physical power
	 */
	final public int strengthModifier;
	/**
	 * measuring endurance
	 */				 
	final public int constitutionModifier;
	/**
	 * measuring agility
	 */
	final public int dexterityModifier;
	/**
	 * measuring reasoning and memory
	 */
	final public int intelligenceModifier;
	/**
	 * measuring Perception and Insight
	 */
	final public int wisdomModifier;
	/**
	 * measuring force of personality
	 */
	final public int charismaModifier;
	
	
	private CharClass(int strengthModifier, int constitutionModifier, int dexterityModifier){
//		if((strengthModifier+constitutionModifier+dexterityModifier)!=0) throw new IllegalCharacterAttributes("Sthe Sum of all Race Modificators is not null");
		this.strengthModifier = strengthModifier;
		this.constitutionModifier = constitutionModifier;
		this.dexterityModifier = dexterityModifier;
		intelligenceModifier = 0;
		wisdomModifier=0;
		charismaModifier =0;
	}


	public void specialAction() {
		
	}


}
