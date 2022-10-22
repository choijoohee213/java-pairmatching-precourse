package pairmatching.controller;

import pairmatching.domain.PairInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.service.PairSearchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairSearchingController implements MenuItemController {
	private static PairSearchingController instance;

	public static PairSearchingController getInstance() {
		if (instance == null) {
			instance = new PairSearchingController();
		}
		return instance;
	}

	@Override
	public void run() {
		OutputView.printPairMatchingInfoMenu();
		OutputView.printPairMatchingSelectMenu();
		String selectedMenu = InputView.input();
		PairInfo pairInfo = PairMatchingService.getInstance().validatePairInfo(selectedMenu);
		OutputView.printPairMatchingResult(PairSearchingService.getInstance().searchPairMatching(pairInfo));
	}
}
