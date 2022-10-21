package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.PairInfo;

public class PairMatchingRepository {
	private static PairMatchingRepository instance;
	private Map<PairInfo, List<List<String>>> pairMatchingInfo = new HashMap<>();

	public static PairMatchingRepository getInstance() {
		if (instance == null) {
			instance = new PairMatchingRepository();
		}
		return instance;
	}

	public boolean isExistedPairMatching(PairInfo pairInfo) {
		return pairMatchingInfo.containsKey(pairInfo);
	}

	public void addPairMatching(List<List<String>> pairs, PairInfo pairInfo) {
		pairMatchingInfo.put(pairInfo, pairs);
	}

	public String getCrewListAsString(PairInfo pairInfo) {
		List<List<String>> pairs = pairMatchingInfo.get(pairInfo);
		StringBuilder sb = new StringBuilder();
		for (List<String> pair : pairs) {
			sb.append(String.join(" : ", pair)).append('\n');
		}
		return sb.toString();
	}

	public void deleteAll() {
		pairMatchingInfo.clear();
	}
}
