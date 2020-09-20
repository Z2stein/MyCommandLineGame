

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import Support.CsvReader;
import Support.EzLog;

public class CharRace {
	static protected int condition;
	static protected int strength;
	static protected int agitily;
	static protected int intelligence;
	
	static HashMap<String, int[]> raceAttributes = new HashMap<>();

//	static String attrFilePath = "D:/Workspace/Git/MyCMDGame/src/gameConfic/RaceAttributes.csv";
	static String attrFilePath = "./src/gameConfic/RaceAttributes.csv";
	
	static {
		try {
			ArrayList<ArrayList<String>> tempArray = CsvReader.csvToTwoDimArray(attrFilePath, true, ";");
			
			
			for (int i = 0; i < tempArray.size(); i++) {
				String tempKey = tempArray.get(i).get(0);
				int[] tempInt = new int[tempArray.get(0).size()-1];
				for (int j = 1; j < tempArray.get(0).size(); j++) {
					tempInt[j-1]=Integer.parseInt(tempArray.get(i).get(j));
				}
				raceAttributes.put(tempKey, tempInt);
			}
			
		} catch (FileNotFoundException e) {
			EzLog.log("Error while FileReading "+ attrFilePath, '!');
			e.printStackTrace();
		}
	}
	
	protected static void initalizeAttributes() {

	
	}
	
	public static int getCondition() {
		return condition;
	}
	public static int getStrength() {
		return strength;
	}
	public static int getAgitily() {
		return agitily;
	}
	public static int getIntelligence() {
		return intelligence;
	}
	public static void setCondition(int condition) {
		CharRace.condition = condition;
	}
	public static void setStrength(int strength) {
		CharRace.strength = strength;
	}
	public static void setAgitily(int agitily) {
		CharRace.agitily = agitily;
	}
	public static void setIntelligence(int intelligence) {
		CharRace.intelligence = intelligence;
	}
	public static void setAttr(int condition	,int strength	,int agitily	,int intelligence) {
		CharRace.intelligence = intelligence;
	}
	

}
