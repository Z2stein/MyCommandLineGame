package Support;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EzLog {
	private static Scanner userIn;
	private static List<String> consolOutputStr;

	private enum ExecutionCase {
		NORMAL, TEST;
	}

	private static ExecutionCase executionCase = null;
	private static int testInArgsCounter;
	private static String[] testInArguments;

	static {
		// Scanner for Input For Line
		userIn = new Scanner(System.in);
		executionCase = ExecutionCase.NORMAL;
		consolOutputStr = new ArrayList<String>();

		String actualDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		writeout("##############################");
		writeout("######  Initalize Loger  #####");
		writeout("###  " + actualDateTime + "   ###");
		writeout("##############################");
	}

	public static void log(String massage, MsgType msgType) {

		writeout(msgType.getPrefix() + massage + msgType.getSurfix());
		if (msgType == MsgType.HARD_EXEPTION)
			return;

		try {
			FileLogger.writeToExistingFile(msgType.getPrefix() + massage + msgType.getSurfix());
		} catch (IOException e) {
			writeout("Error in FileLogger: Was not ABle to Log to FIle ");
			e.printStackTrace();
		}

	}

	private static void writeout(String string) {
		if (executionCase == ExecutionCase.NORMAL) {
			System.out.println(string);
		}
		if (executionCase == ExecutionCase.TEST) {
			consolOutputStr.add(string);
		}
	}

	public static String in(String question) {

		if (executionCase == ExecutionCase.NORMAL) {

			String preAndSurFix = " -- ";
			writeout(preAndSurFix + question + preAndSurFix);
			return userIn.nextLine().toLowerCase();
		} else if (executionCase == ExecutionCase.TEST) {
			String preAndSurFix = " -- ";
			writeout(preAndSurFix + question + preAndSurFix);

			String currenInput = testInArguments[testInArgsCounter];

			return currenInput.toLowerCase();
		}
		return null;
	}

	public static void help(String str1, String str2) {
		String resStr = "-------------------------------------";
		resStr = str1 + " " + resStr.substring(str1.length()) + " " + str2;
		writeout("# " + resStr);
	}

	public static ExecutionCase getExecutionCase() {
		return executionCase;
	}

	public static void setExecutionCaseToTest() {
		EzLog.executionCase = ExecutionCase.TEST;
	}

	public static String getLastConsoleOutput() {
		return getLastConsoleOutput(0);
	}

	public static String getLastConsoleOutput(int linesBefore) {
		return consolOutputStr.get(consolOutputStr.size() - 1 - linesBefore);
	}

	public static void setTestInArgsCounter(int testInArgsCounter) {
		EzLog.testInArgsCounter = testInArgsCounter;
	}

	public static void setTestInArguments(String[] testInArguments) {
		EzLog.testInArguments = testInArguments;
	}
}
