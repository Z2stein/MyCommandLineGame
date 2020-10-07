package Actions;

import java.util.Arrays;

import Support.EzLog;

public enum BasicActions {

	MOVETO("moveto", "Moving 'n'-> North, 's' -> South, 'e' -> east. 'w' -> west") {
		@Override
		public void perform() {

		}
	},
	EXIT("exit", "exit game");

	private String name;
	private String help;

	private BasicActions(String name, String help) {
		this.name = name;
		this.help = help;
	}

	public String getName() {
		return name;
	}

	public void perform() {
		EzLog.log("You Connot Do this Action", 'e');
	}

	public static void help(String action) {
		BasicActions baseAction = BasicActions.valueOf(action.toUpperCase().replace(" ", ""));

		EzLog.help(baseAction.name, baseAction.help);
	}

	public static void help() {
		Arrays.stream(BasicActions.values()).forEach(s -> EzLog.help(s.name, s.help));
	}
	
	public static void doAction(String ActionString){
		String[] splittedStr = splitStrings(ActionString);

		
		
		switch (splittedStr[0]) {
		case "help":
			if (splittedStr[1] == "") {
				BasicActions.help();
			} else {
				BasicActions.help(splittedStr[1]);
			}
			break;
		case "moveto":
			ChangeField.moveTo(splittedStr[1]);
			break;
		default:
			System.out.println("unknown command, try 'help' to see all valid arguments");
			break;
		}
	}

	private static String[] splitStrings(String actionString) {
		String[] resultString = { actionString, "" };

		if (actionString.indexOf(' ') == -1) {
			return resultString;
		}

		resultString[0] = actionString.substring(0, actionString.indexOf(' '));
		resultString[1] = actionString.substring(actionString.indexOf(' ') + 1);
		return resultString;
	}

}
