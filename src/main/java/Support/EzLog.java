package Support;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EzLog {
	private static Scanner userIn;

	static {
		// Scanner for Input For Line
		userIn = new Scanner(System.in);

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

		System.out.println(prefix+massage+surfix);
		
		if(c=='e') return;
		try {
			FileLogger.writeToExistingFile(prefix+massage+surfix);
		} catch (IOException e) {
			System.out.println("Error in FileLogger: Was not ABle to Log to FIle ");
			e.printStackTrace();
		}	
		
	}

	public static String in(String question) {
		String preAndSurFix = " -- ";
		System.out.println(preAndSurFix + question + preAndSurFix);
		return userIn.nextLine();
	}

	public static void help(String str1, String str2) {
		String resStr = "-------------------------------------";
		resStr = str1 + " " + resStr.substring(str1.length()) + " " + str2;
		System.out.println("# " + resStr);
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

		System.out.println(prefix + massage);
		try {
			FileLogger.writeToExistingFile(prefix + massage);
		} catch (IOException e) {
			System.out.println("Error in FileLogger: Was not ABle to Log to FIle ");
			e.printStackTrace();
		}		
	}
}
