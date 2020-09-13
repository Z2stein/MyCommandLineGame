
package Support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileLogger {

	static FileWriter wWriter;
	
	static File file = new File("C:\\Users\\Chris\\OneDrive\\Desktop\\GameOut.txt");
	
	public static void writeToNewFile(String input) throws IOException {
		wWriter = new FileWriter(file, false);
		wWriter.write(input);
		wWriter.write(System.getProperty("line.separator"));
		wWriter.flush(); // wait until the buffer is empty
		wWriter.close();
		
	}
	
	public static void writeToExistingFile(String input) throws IOException {
		wWriter = new FileWriter(file, true);
		wWriter.write(input);
		wWriter.write(System.getProperty("line.separator"));
		wWriter.flush(); // wait until the buffer is empty
		wWriter.close();
	}
	
	
}