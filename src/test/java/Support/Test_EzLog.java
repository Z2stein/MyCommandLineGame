package Support;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Test_EzLog {
  @Test
  public void testLogging() {
  String actual = "TestLogMassage";
  EzLog.setExecutionCaseToTest();
  EzLog.log(actual, 0);
  String expected = EzLog.getLastConsoleOutput();  
 
  assertEquals(actual, expected);
  }
  
  
}
