package CharakterAndAttributes.Class;


public class Warrior implements CharClassAction {

	static int constitution;
	static int strenght;
	
	static {
		constitution = 10;
		strenght = 7;
	}
	
	@Override
	public int getStrengthmodifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getConstitutionmodifier() {
		// TODO Auto-generated method stub
		return 0;
	}

}
