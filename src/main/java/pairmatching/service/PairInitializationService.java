package pairmatching.service;

import java.util.Arrays;

import pairmatching.domain.Level;
import pairmatching.repository.PairMatchingRepository;

public class PairInitializationService {
	private static PairInitializationService instance;

	public static PairInitializationService getInstance() {
		if(instance == null) {
			instance = new PairInitializationService();
		}
		return instance;
	}

	public void initialize() {
		PairMatchingRepository.getInstance().deleteAll();
		Arrays.stream(Level.values())
			.forEach(Level::clearPairRecords);
	}
}
