package Actions;

import Character.GameCharacter;
import Character.Race.CharRace;
import Support.EzLog;
import Support.MsgType;

public class DoAction {
/**
 * GameCharacter extends  DoAction
 * @param ActionString
 */
	public void doAction(String ActionString){
		GameCharacter actingChar = (GameCharacter) this;
		
		String[] splittedStr = splitStrings(ActionString.toLowerCase());

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
			
		case "talk":
			
			switch (splittedStr[1]) {
			case "nonsence":
				if (!(actingChar.race==CharRace.HUMAN)) {
					EzLog.log("Only Humand can do this action", MsgType.INGAME_EXEPTION);
					break;
				}
				EzLog.log("You talk nonsense, nobody listens to you anymore", MsgType.ANSWER);
				break;

			default:
				break;
			}
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
