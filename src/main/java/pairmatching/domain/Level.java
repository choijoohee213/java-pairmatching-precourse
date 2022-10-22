package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Level {
	LEVEL1("레벨1", "자동차경주", "로또", "숫자야구게임"),
	LEVEL2("레벨2", "장바구니", "결제", "지하철노선도"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4", "성능개선", "배포"),
	LEVEL5("레벨5");

	private final String name;
	private final List<String> missionList;
	private final Set<Integer> pairRecords = new HashSet<>();

	Level(String name, String... mission) {
		this.name = name;
		missionList = new ArrayList<>();
		missionList.addAll(Arrays.asList(mission));
	}

	public void addPairRecords(Crew crew1, Crew crew2) {
		pairRecords.add((crew1.toString() + crew2.toString()).hashCode());
		pairRecords.add((crew2.toString() + crew1.toString()).hashCode());
	}

	public boolean isPairedInPast(Crew crew1, Crew crew2) {
		return pairRecords.contains((crew1.toString() + crew2.toString()).hashCode());
	}

	public void clearPairRecords() {
		pairRecords.clear();
	}

	public String getName() {
		return name;
	}

	public boolean isExistedMission(String mission) {
		return missionList.stream()
			.anyMatch(m -> m.equals(mission));
	}

	@Override
	public String toString() {
		String missionsAsString = String.join(" | ", missionList);
		return name + ": " + missionsAsString;
	}
}