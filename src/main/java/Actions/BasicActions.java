package Actions;

import java.util.Arrays;

import Support.EzLog;
import Support.MsgType;

public enum BasicActions {

	MOVETO("moveto", "Moving 'n'-> North, 's' -> South, 'e' -> east. 'w' -> west") {
		@Override
		public void perform() {

		}
	},
	EXIT("exit", "exit game");

	private String name;
	private String help;

	private BasicActions(String name, String help) {
		this.name = name;
		this.help = help;
	}

	public String getName() {
		return name;
	}

	public void perform() {
		EzLog.log("You Connot Do this Action", MsgType.INGAME_EXEPTION);
	}

	public static void help(String action) {
		BasicActions baseAction = BasicActions.valueOf(action.toUpperCase().replace(" ", ""));

		EzLog.help(baseAction.name, baseAction.help);
	}

	public static void help() {
		Arrays.stream(BasicActions.values()).forEach(s -> EzLog.help(s.name, s.help));
	}
}
