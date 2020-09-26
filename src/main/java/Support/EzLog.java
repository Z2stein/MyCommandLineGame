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
	
	private enum ExecutionCase{
		NORMAL,
		TEST;
	}
	
	private static ExecutionCase executionCase = null;
	
	static {
		// Scanner for Input For Line
		userIn = new Scanner(System.in);
		executionCase = ExecutionCase.NORMAL;
		consolOutputStr = new ArrayList<String>();

		String actualDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		log("##############################",  0);
		log("######  Initalize Loger  #####",  0);
		log("###  " + actualDateTime + "   ###",  0);
		log("##############################",  0);
	}

	
	public static void log(String massage, char c) {
		String prefix = "";
		String surfix = "";

		switch (c) {
		case 'a':
			prefix = "  -  ";
			surfix=prefix;
			break;
		case 'e':
			//exeption
			prefix = " !-  ";
			surfix="  -  ";
			break;
		case '!':
			//exeption
			prefix = " !!!!!!!-  ";
			surfix="  -!!!!!!!  ";
			break;

		default:
			break;
		}
        
		writeout(prefix+massage+surfix);
		
		writeout(prefix+massage+surfix);
		
		if(c=='e') return;
		try {
			FileLogger.writeToExistingFile(prefix+massage+surfix);
		} catch (IOException e) {
			writeout("Error in FileLogger: Was not ABle to Log to FIle ");
			e.printStackTrace();
		}	
		
	}

	private static void writeout(String string) {
		if (executionCase==ExecutionCase.NORMAL) {
			System.out.println(string);
		}
		if (executionCase==ExecutionCase.TEST) {
			consolOutputStr.add(string);
		}
	}

	public static String in(String question) {
		String preAndSurFix = " -- ";
		writeout(preAndSurFix + question + preAndSurFix);
		return userIn.nextLine();
	}

	public static void help(String str1, String str2) {
		String resStr = "-------------------------------------";
		resStr = str1 + " " + resStr.substring(str1.length()) + " " + str2;
		writeout("# " + resStr);
	}

	public static void log(String massage, int n) {


		String prefix = "";

		if (n != 0) {
			prefix = "###";
			for (int i = 1; i < n + 1; i++) {
				prefix = prefix + "--";
			}
			prefix = prefix + "->  ";
		}

		writeout(prefix + massage);
		try {
			FileLogger.writeToExistingFile(prefix + massage);
		} catch (IOException e) {
			writeout("Error in FileLogger: Was not ABle to Log to FIle ");
			e.printStackTrace();
		}		
	}

	public static ExecutionCase getExecutionCase() {
		return executionCase;
	}

	public static void setExecutionCaseToTest() {
		EzLog.executionCase = ExecutionCase.TEST;
	}
	public static String getLastConsoleOutput() {
		return consolOutputStr.get(consolOutputStr.size()-1);
	}
}
