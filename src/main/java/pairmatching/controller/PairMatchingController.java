package pairmatching.controller;

import pairmatching.common.Constant;
import pairmatching.domain.PairInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements MenuItemController {
	private static PairMatchingController instance;

	public static PairMatchingController getInstance() {
		if (instance == null) {
			instance = new PairMatchingController();
		}
		return instance;
	}

	@Override
	public void run() {
		OutputView.printPairMatchingInfoMenu();
		PairInfo pairInfo;
		do {
			OutputView.printPairMatchingSelectMenu();
			String selectedMenu = InputView.input();
			pairInfo = PairMatchingService.getInstance().validatePairInfo(selectedMenu);
		} while (!checkRematching(pairInfo));
		String pairResult = PairMatchingService.getInstance().matchPair(pairInfo);
		OutputView.printPairMatchingResult(pairResult);
	}

	private boolean checkRematching(PairInfo pairInfo) {
		if (PairMatchingService.getInstance().isExistedPairMatching(pairInfo)) {
			OutputView.printRematchMenu();
			String answer = InputView.input();
			if (answer.equals("네")) {
				return true;
			} else if (answer.equals("아니오")) {
				return false;
			}
			throw new IllegalStateException(Constant.ERROR_PAIR_MATCHING_REMATCH_INPUT_MESSAGE);
		}
		return true;
	}
}
