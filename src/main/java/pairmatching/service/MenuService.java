package pairmatching.service;

import static pairmatching.common.Constant.*;

import java.util.stream.Stream;

import pairmatching.domain.Menu;

public class MenuService {
	private static MenuService instance;

	public static MenuService getInstance() {
		if (instance == null) {
			instance = new MenuService();
		}
		return instance;
	}

	private MenuService() {
	}

	public boolean startMenu(String input) throws IllegalArgumentException {
		Menu menu = Stream.of(Menu.values())
			.filter(m -> input.equals(m.getCommand()))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_MENU_MESSAGE));
		if(menu.equals(Menu.EXIT)) {
			return false;
		}
		menu.getMenuItemController().run();
		return true;
	}
}
