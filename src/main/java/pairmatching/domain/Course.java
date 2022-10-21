package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum Course {
	BACKEND("백엔드", "src/main/resources/backend-crew.md"),
	FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

	private final String name;
	private final String filePath;
	private final List<String> crewList;

	Course(String name, String filePath) {
		this.name = name;
		this.filePath = filePath;
		crewList = new ArrayList<>();
		readCrewList();
	}

	private void readCrewList() {
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while ((line = br.readLine()) != null) {
				crewList.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getCrewList() {
		return crewList;
	}

	@Override
	public String toString() {
		return name;
	}

	// 추가 기능 구현
}
