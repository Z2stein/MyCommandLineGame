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
		log("##############################", (char) 0);
		log("######  Initalize Loger  #####", (char) 0);
		log("###  " + actualDateTime + "   ###", (char) 0);
		log("##############################", (char) 0);
	}

	public static void log(String massage, char c) {

		if (Character.isDigit(c)) {

			int n = Character.getNumericValue(c);

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
		} else if (Character.isLetter(c)) {
			// ToDo
		} else {
			// ToDo
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
}
