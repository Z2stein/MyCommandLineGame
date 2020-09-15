package Support;

public class FormatingOut {
	static public String getLastPackage(String strRace) {
		String resStr
		=strRace.substring(strRace.indexOf('.')+1);
		if (strRace!=resStr) {
			resStr=getLastPackage(resStr);
		}
		return resStr;
	}
}
