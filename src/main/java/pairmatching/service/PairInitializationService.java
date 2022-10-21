package pairmatching.service;

public class PairInitializationService {
	private static PairInitializationService instance;

	public static PairInitializationService getInstance() {
		if(instance == null) {
			instance = new PairInitializationService();
		}
		return instance;
	}

	public void run() {

	}
}
