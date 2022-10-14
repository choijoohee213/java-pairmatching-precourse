package pairmatching.controller;

import pairmatching.domain.Menu;
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

	public void run() {
		do {
			OutputView.printMenu();
			Menu menu = MenuService.getInstance().inputMenu(InputView.inputMenu());
			MenuItemController menuItemController = menu.getMenuItemController();
			menuItemController.run();

		} while (true);
	}
}
