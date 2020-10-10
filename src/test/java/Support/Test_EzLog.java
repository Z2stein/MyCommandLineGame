package Support;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class Test_EzLog {

@Test
  public void testLogging() {
  String actual = "TestLogMassage";
  EzLog.log(actual, MsgType.UNFORMATTED);
  String expected = EzLog.getLastConsoleOutput();  
 
  assertEquals(actual, expected);
  }
  
  
}
