package pairmatching.service;

import static pairmatching.common.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.PairInfo;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchingService {
	private static PairMatchingService instance;

	public static PairMatchingService getInstance() {
		if (instance == null) {
			instance = new PairMatchingService();
		}
		return instance;
	}

	public PairInfo validatePairInfo(String selected) {
		String[] selectedInfos = selected.split(", ");
		Course course = parseCourse(selectedInfos[0]);
		Level level = parseLevel(selectedInfos[1]);
		String mission = selectedInfos[2];
		if (!level.isExistedMission(mission)) {
			throw new IllegalStateException(ERROR_PAIR_MATCHING_MENU_MESSAGE);
		}
		return new PairInfo(course, level, mission);
	}

	public String matchPair(PairInfo pairInfo) {
		List<String> crewList = pairInfo.getCourse().getCrewList();
		makeRandomPairs(crewList, pairInfo);
		return PairMatchingRepository.getInstance().getCrewListAsString(pairInfo);
	}

	public boolean isExistedPairMatching(PairInfo pairInfo) {
		return PairMatchingRepository.getInstance().isExistedPairMatching(pairInfo);
	}

	private Level parseLevel(String levelName) {
		return Arrays.stream(Level.values())
			.filter(l -> l.getName().equals(levelName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_PAIR_MATCHING_MENU_MESSAGE));
	}

	private Course parseCourse(String courseName) {
		return Arrays.stream(Course.values())
			.filter(c -> c.toString().equals(courseName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_PAIR_MATCHING_MENU_MESSAGE));
	}

	private void makeRandomPairs(List<String> crewList, PairInfo pairInfo) {
		boolean makeSuccess = false;
		List<List<String>> pairs = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			List<String> shuffledCrewList = Randoms.shuffle(crewList);
			pairs = connectPair(shuffledCrewList);
			if (validatePairs(pairs, pairInfo)) {
				makeSuccess = true;
				break;
			}
		}
		if (!makeSuccess) {
			throw new IllegalStateException(ERROR_PAIR_MATCHING_FAILURE_MESSAGE);
		}
		savePairs(pairs, pairInfo);
		PairMatchingRepository.getInstance().addPairMatching(pairs, pairInfo);
	}

	private void savePairs(List<List<String>> pairs, PairInfo pairInfo) {
		for (List<String> pair : pairs) {
			Crew crew1 = new Crew(pairInfo.getCourse(), pair.get(0));
			Crew crew2 = new Crew(pairInfo.getCourse(), pair.get(1));
			if (pair.size() == 3) {
				Crew crew3 = new Crew(pairInfo.getCourse(), pair.get(2));
				pairInfo.getLevel().addPairRecords(crew1, crew2);
				pairInfo.getLevel().addPairRecords(crew1, crew3);
				pairInfo.getLevel().addPairRecords(crew2, crew3);
				continue;
			}
			pairInfo.getLevel().addPairRecords(crew1, crew2);
		}
	}

	private boolean validatePairs(List<List<String>> pairs, PairInfo pairInfo) {
		for (List<String> pair : pairs) {
			Crew crew1 = new Crew(pairInfo.getCourse(), pair.get(0));
			Crew crew2 = new Crew(pairInfo.getCourse(), pair.get(1));
			if (pair.size() == 3) {
				Crew crew3 = new Crew(pairInfo.getCourse(), pair.get(2));
				if (pairInfo.getLevel().isPairedInPast(crew1, crew2)
					|| pairInfo.getLevel().isPairedInPast(crew1, crew3)
					|| pairInfo.getLevel().isPairedInPast(crew2, crew3)) {
					return false;
				}
				continue;
			}
			if (pairInfo.getLevel().isPairedInPast(crew1, crew2)) {
				return false;
			}
		}
		return true;
	}

	private List<List<String>> connectPair(List<String> shuffledCrewList) {
		List<List<String>> pairs = new ArrayList<>();

		for (int i = 0; i < shuffledCrewList.size(); i += 2) {
			String crew1 = shuffledCrewList.get(i);
			if (i == shuffledCrewList.size() - 1) {
				pairs.get(pairs.size() - 1).add(crew1);
				break;
			}
			String crew2 = shuffledCrewList.get(i + 1);
			List<String> pair = new ArrayList<>();
			pair.add(crew1);
			pair.add(crew2);
			pairs.add(pair);
		}
		return pairs;
	}
}
