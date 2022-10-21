package pairmatching.common;

public class Constant {
	public static final String MENU_NOTIFICATION_MESSAGE = "기능을 선택하세요.";
	public static final String COURSE_AS_STRING = "과정";
	public static final String Level_AS_STRING = "레벨";
	public static final String MISSION_AS_STRING = "미션";

	public static final String PAIR_MATCHING_BORDER_MESSAGE = "#############################################";
	public static final String PAIR_MATCHING_EXAMPLE_MESSAGE = "ex) 백엔드, 레벨1, 자동차경주";
	public static final String PAIR_MATCHING_RESULT_HEADER_MESSAGE = "페어 매칭 결과입니다.";
	public static final String PAIR_MATCHING_REMATCH_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

	private static final String ERROR_PRE_MESSAGE = "[ERROR] ";
	public static final String ERROR_INPUT_MENU_MESSAGE = ERROR_PRE_MESSAGE + "해당하는 메뉴가 없습니다.";
	public static final String ERROR_PAIR_MATCHING_MENU_MESSAGE = ERROR_PRE_MESSAGE + "유효한 과정, 레벨, 미션을 선택해주세요.";
	public static final String ERROR_PAIR_MATCHING_FAILURE_MESSAGE = ERROR_PRE_MESSAGE + "페어 매칭에 실패하였습니다.";
	public static final String ERROR_PAIR_MATCHING_REMATCH_INPUT_MESSAGE = ERROR_PRE_MESSAGE + "네 | 아니오 중 골라주세요.";

	public static final String ERROR_PAIR_SEARCHING_NO_MATCHING_MESSAGE = ERROR_PRE_MESSAGE + "매칭 이력이 없습니다.";

	public static final String FILE_PATH_CREW_BACKEND = "src/main/resources/backend-crew.md";
	public static final String FILE_PATH_CREW_FRONTEND = "src/main/resources/frontend-crew.md";
}
