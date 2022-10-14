package pairmatching.service;

import java.util.stream.Stream;

import pairmatching.common.Constant;
import pairmatching.domain.Menu;

public class MenuService {
	private static MenuService instance;

	public static MenuService getInstance() {
		if (instance == null) {
			instance = new MenuService();
		}
		return instance;
	}

	public Menu inputMenu(String input) {
		return Stream.of(Menu.values())
			.filter(m -> input.equals(m.getCommand()))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(Constant.ERROR_INPUT_MENU_MESSAGE));
	}
}
