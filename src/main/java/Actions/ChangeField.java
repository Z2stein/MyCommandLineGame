package Actions;

import Character.GameCharacter;
import Main.Main;
import Support.EzLog;
import Support.FormatingOut;
import Support.MsgType;
import World.WorldMap;

public class ChangeField {

	public static void moveTo(String direction){

		int[] deltaCoord = charDirectionToIntArray(direction);

		GameCharacter currChar = Main.getCharacter();
		if (moveTo(currChar, deltaCoord)) {
			String fieldType = FormatingOut.getLastPackage(WorldMap.getField(currChar.getCharakterPosition()).getClass().getName());
			
			EzLog.log("You moved in Direction '"+direction+"' and arrived at a new Area. Its a "+fieldType, MsgType.ANSWER);
			EzLog.log("Your current position is "+currChar.getCharakterPositionStr(), MsgType.ANSWER);
			
		} else {
			EzLog.log("You tried to exceed the map, but you are not able to", MsgType.INGAME_EXEPTION);
			EzLog.log("Your current position is "+currChar.getCharakterPositionStr(), MsgType.INGAME_EXEPTION);
		}
		
 
	}

	public static boolean moveTo(GameCharacter character, int[] deltaCoord) {
		
		int[] newCoord = {0,0};
		if (checkIfNewCoordinatesValid(deltaCoord, character)) {
			newCoord[0] = deltaCoord[0] + character.getCharakterPosition()[0];
			newCoord[1] = deltaCoord[1] + character.getCharakterPosition()[1];

			character.switchField(newCoord);
			return true;
		}
	return false;
	}
	
	
	protected static boolean checkIfNewCoordinatesValid(int[] coordinateDelta, GameCharacter currentMainCharakter) {
		int[] coordinateOfChar = currentMainCharakter.getCharakterPosition();

		int worldDim = WorldMap.getWorldDimension();

		int[] newCoord = {0,0};
		for (int i = 0; i < coordinateOfChar.length; i++) {
			newCoord[i] = coordinateDelta[i] + coordinateOfChar[i];
			if (newCoord[i] < 0 || newCoord[i] >= worldDim) {
				return false;
			}
			;
		}
		return true;
	}

	protected static int[] charDirectionToIntArray(String direction) {

		int[] fieldDelta = { 0, 0 };

		switch (direction) {
		case "n":
			fieldDelta[0] = 0;
			fieldDelta[1] = 1;
			break;
		case "s":
			fieldDelta[0] = 0;
			fieldDelta[1] = -1;
			break;
		case "w":
			fieldDelta[0] = -1;
			fieldDelta[1] = 0;
			break;
		case "e":
			fieldDelta[0] = 1;
			fieldDelta[1] = 0;
			break;

		default:
			EzLog.log("Invalid moveto direction use n,s,w or e", MsgType.INGAME_EXEPTION);
		}
		return fieldDelta;
	}

}
