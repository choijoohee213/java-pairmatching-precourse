package pairmatching.domain;

import java.util.stream.Stream;

import pairmatching.controller.MenuItemController;
import pairmatching.controller.PairInitializationController;
import pairmatching.controller.PairMatchingController;
import pairmatching.controller.PairSearchingController;

public enum Menu {
	PAIR_MATCHING("1", "페어 매칭", PairMatchingController.getInstance()),
	PAIR_SEARCHING("2", "페어 조회", PairSearchingController.getInstance()),
	PAIR_INITIALIZATION("3", "초기화", PairInitializationController.getInstance()),
	EXIT("Q", "종료", null);

	private final String command;
	private final String name;
	private final MenuItemController menuItemController;

	Menu(String command, String name, MenuItemController menuItemController) {
		this.command = command;
		this.name = name;
		this.menuItemController = menuItemController;
	}

	public static String getValuesAsString() {
		StringBuilder sb = new StringBuilder();
		Stream.of(Menu.values())
			.forEach(menu -> sb.append(menu.command).append(". ").append(menu.name).append("\n"));
		return sb.toString();
	}

	public String getCommand() {
		return command;
	}

	public String getName() {
		return name;
	}

	public MenuItemController getMenuItemController() {
		return menuItemController;
	}
}
