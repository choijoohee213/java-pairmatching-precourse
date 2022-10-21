package pairmatching.service;

import pairmatching.common.Constant;
import pairmatching.domain.PairInfo;
import pairmatching.repository.PairMatchingRepository;

public class PairSearchingService {
	private static PairSearchingService instance;

	public static PairSearchingService getInstance() {
		if(instance == null) {
			instance = new PairSearchingService();
		}
		return instance;
	}

	public void run() {

	}

	public String searchPairMatching(PairInfo pairInfo) {
		if(!PairMatchingRepository.getInstance().isExistedPairMatching(pairInfo)) {
			throw new IllegalStateException(Constant.ERROR_PAIR_SEARCHING_NO_MATCHING_MESSAGE);
		}
		return PairMatchingRepository.getInstance().getCrewListAsString(pairInfo);
	}
}
