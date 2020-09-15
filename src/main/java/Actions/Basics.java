package Actions;

import java.util.HashMap;
import java.util.Iterator;

import Support.EzLog;

public class Basics {
	private static HashMap<String, String> helpMap;

	static {
		setHelpHashMap();
	}

	public static void doAction(String ActionString) {
		String[] splittedStr = splitStrings(ActionString);

		
		for (String string : splittedStr) {
			System.out.println(string);
		}
		
		switch (splittedStr[0]) {
		case "help":
			if (splittedStr[1]=="") {
				help();
			}else {
				help(splittedStr[1]);
			}
			break;
		case "moveto":
			break;
		default:
			break;
		}
	}

	private static String[] splitStrings(String actionString) {
		String[] resultString= {actionString,""};
		
		
		if (actionString.indexOf(' ')==-1) {
			return resultString ;
		}
		
		resultString[0] = actionString.substring(0, actionString.indexOf(' '));
		resultString[1] = actionString.substring(actionString.indexOf(' ') + 2);
		return resultString;
	}

	private static void setHelpHashMap() {

		String[][] pairs = { { "moveTo", "Moving 'n'-> North, 's' -> South, 'e' -> east. 'w' -> west" },
				{"exit", "exit game"}
		};
		helpMap = new HashMap<String, String>();

		for (String[] strings : pairs) {
			helpMap.put(strings[0], strings[1]);
		}

	}

	private static void help() {
//special Help
		for (String key : helpMap.keySet()) {
			EzLog.help(key, helpMap.get(key));
		}
	}

	public static void help(String key) {
		EzLog.help(key, helpMap.get(key));
	}
}
