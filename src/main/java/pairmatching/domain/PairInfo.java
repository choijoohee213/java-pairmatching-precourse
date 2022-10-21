package pairmatching.domain;

import java.util.Objects;

public class PairInfo {
	private final Course course;
	private final Level level;
	private final String mission;

	public PairInfo(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PairInfo pairInfo = (PairInfo)o;
		return getCourse() == pairInfo.getCourse() && getLevel() == pairInfo.getLevel() && Objects.equals(
			getMission(), pairInfo.getMission());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCourse(), getLevel(), getMission());
	}
}
