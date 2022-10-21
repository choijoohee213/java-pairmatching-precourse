package pairmatching.controller;

public class PairInitializationController implements MenuItemController {
	private static PairInitializationController instance;

	public static PairInitializationController getInstance() {
		if(instance == null) {
			instance = new PairInitializationController();
		}
		return instance;
	}

	@Override
	public void run() {

	}
}
