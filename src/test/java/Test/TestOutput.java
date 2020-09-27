package Test;

import static org.testng.Assert.assertTrue;

import Support.EzLog;

public interface TestOutput {

	/**
	 * 
	 * @param numberOfLines number of lines in Consol which will be checked
	 * @param Phrases       Phrases which should be in at least on of the
	 *                      ConsolLines
	 */
	default void checkIfTextInConsole(int numberOfLines, String[] Phrases) {
		for (String currentPhrase : Phrases) {
			boolean phraseIsIn = false;
			for (int i = 0; i < numberOfLines; i++) {
				phraseIsIn|=EzLog.getLastConsoleOutput(i).toLowerCase().contains(currentPhrase.toLowerCase());
			}
			assertTrue(phraseIsIn,"Phrase '"+currentPhrase+"' was not is one of the last "+numberOfLines+" ConsoleLines!" );
		}
	}
}
