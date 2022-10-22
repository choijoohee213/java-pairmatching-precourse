package pairmatching.view;

import static pairmatching.common.Constant.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Menu;

public class OutputView {
	public static void printMenu() {
		System.out.println(MENU_NOTIFICATION_MESSAGE);
		System.out.print(Menu.getValuesAsString());
	}

	public static void printPairMatchingInfoMenu() {
		System.out.println(PAIR_MATCHING_BORDER_MESSAGE);
		printCourses();
		printMissions();
		System.out.println(PAIR_MATCHING_BORDER_MESSAGE);
	}

	public static void printPairMatchingSelectMenu() {
		String delimiter = ", ";
		String sb = COURSE_AS_STRING + delimiter
			+ Level_AS_STRING + delimiter
			+ MISSION_AS_STRING + "을 선택하세요.\n"
			+ PAIR_MATCHING_EXAMPLE_MESSAGE;
		System.out.println(sb);
	}

	private static void printMissions() {
		String levelList = Arrays.stream(Level.values())
			.map(level -> "\n\t- " + level.toString())
			.collect(Collectors.joining(""));
		System.out.printf("%s: %s%n", MISSION_AS_STRING, levelList);
	}

	private static void printCourses() {
		String delimiter = " | ";

		List<String> courseList = Arrays.stream(Course.values())
			.map(Course::toString)
			.collect(Collectors.toList());
		String coursesAsString = String.join(delimiter, courseList);
		System.out.println(COURSE_AS_STRING + ": " + coursesAsString);
	}

	public static void printPairMatchingResult(String result) {
		System.out.println(result);
	}

	public static void printRematchMenu() {
		System.out.println(PAIR_MATCHING_REMATCH_MESSAGE);
	}
}
