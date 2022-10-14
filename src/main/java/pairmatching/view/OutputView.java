package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.common.Constant;
import pairmatching.domain.Course;
import pairmatching.domain.Menu;

public class OutputView {
	public static void printMenu() {
		System.out.println(Constant.MENU_NOTIFICATION_MESSAGE);
		System.out.print(Menu.getValuesAsString());
	}

	public static void printPairMatching() {
		System.out.println(Constant.PAIR_MATCHING_BORDER_MESSAGE);

		String delimiter = " | ";
		List<String> courseList = Stream.of(Course.values())
			.map(Course::getName)
			.collect(Collectors.toList());
		String coursesAsString = String.join(delimiter, courseList);
		System.out.println(Constant.COURSE_AS_STRING + ": " + coursesAsString);
	}
}
