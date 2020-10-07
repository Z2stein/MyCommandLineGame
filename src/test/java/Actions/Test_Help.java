package Actions;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Support.EzLog;
import Test.SuperTest;

public class Test_Help extends SuperTest {
	@Test
	public void moveToHelp() throws Exception {
		BasicActions.doAction("help moveto");
		boolean actual = EzLog.getLastConsoleOutput().contains("Moving 'n'-> North, 's' -> So");
		assertTrue(actual,"Wrong help answere for 'Help moveto'");
	}
	
}
