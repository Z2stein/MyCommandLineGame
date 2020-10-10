package Support;

public enum MsgType {
	ANSWER("  -  ", "  -  "),
	INGAME_EXEPTION(" !-  ","  -  "),
	HARD_EXEPTION(" !!!!!!!-  ","  -!!!!!!!  "),
	DONE_ACTION("--> ",""),
	INFO_AREA(" - "," - "),
	UNFORMATTED("","")
	;
	

	private final String surfix, prefix;

	private MsgType(String surfix, String prefix) {
		this.surfix = surfix;
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public String getSurfix() {
		return surfix;
	}

}
