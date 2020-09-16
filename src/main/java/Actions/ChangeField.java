package Actions;

import CharakterAndAttributes.GameCharacter;
import Main.Main;
import Support.EzLog;
import World.WorldMap;

public class ChangeField {

	public static void moveTo(String direction) throws Exception {

		int[] coordinateDelta = charDirectionToIntArray(direction);

		GameCharacter currentMainCharakter = Main.getCharacter();

		if (checkIfNewCoordinatesValid(coordinateDelta, currentMainCharakter)) {
			int[] newCoord = {0,0};
			newCoord[0] = coordinateDelta[0] + currentMainCharakter.getCharakterPosition()[0];
			newCoord[1] = coordinateDelta[1] + currentMainCharakter.getCharakterPosition()[1];

			currentMainCharakter.setCurrentField(WorldMap.getField(newCoord));
			EzLog.log("You moved in Direction '"+direction+"'", 'a');
			EzLog.log("Your current position is "+currentMainCharakter.getCharakterPositionStr(), 'a');
			
		} else {
			EzLog.log("You tried to exeed the map, but you are not able to", 'e');
			EzLog.log("Your current position is "+currentMainCharakter.getCharakterPositionStr(), 'e');
		}
		

	}

	private static boolean checkIfNewCoordinatesValid(int[] coordinateDelta, GameCharacter currentMainCharakter) {
		int[] coordinateOfChar = currentMainCharakter.getCharakterPosition();

		int worldDim = WorldMap.getWorldDimension();

		int[] newCoord = {0,0};
		for (int i = 0; i < coordinateOfChar.length; i++) {
			newCoord[i] = coordinateDelta[i] + coordinateOfChar[i];
			if (newCoord[i] < 0 && newCoord[i] >= worldDim) {
				return false;
			}
			;
		}
		return true;
	}

	private static int[] charDirectionToIntArray(String direction) throws Exception {

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
			throw new Exception();
		}
		return fieldDelta;
	}

}
