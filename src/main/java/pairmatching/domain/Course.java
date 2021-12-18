package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean isEqual(String name) {
		return this.name.equals(name);
	}
}
