package Support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class CsvReader {
	
	public static ArrayList<ArrayList<String>> csvToTwoDimArray(String filePath,boolean headline,String separator) throws FileNotFoundException {
		ArrayList< ArrayList< String > > records = new ArrayList<ArrayList<String>>();
		
		Scanner scanner = new Scanner( new File(filePath));
		if (headline) scanner.nextLine();
		while (scanner.hasNextLine()) {
			records.add(getRecordsFromLine(scanner.nextLine(),separator));
		}

		return records;
	}
	private static ArrayList<String> getRecordsFromLine(String line,String separator) {
		ArrayList<String> vaList = new ArrayList<String>();
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(separator);
		while (rowScanner.hasNext()) {
			vaList.add(rowScanner.next());
		}
		
		return vaList;
	}

	
}
