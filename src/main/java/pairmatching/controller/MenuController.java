package pairmatching.controller;

import pairmatching.service.MenuService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MenuController {
	private static MenuController instance;

	public static MenuController getInstance() {
		if (instance == null) {
			instance = new MenuController();
		}
		return instance;
	}

	private MenuController() {
	}

	public void run() {
		do {
			OutputView.printMenu();
		} while (MenuService.getInstance().startMenu(InputView.input()));
	}
}
