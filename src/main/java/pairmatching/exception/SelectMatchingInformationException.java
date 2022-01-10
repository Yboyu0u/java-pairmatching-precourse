package pairmatching.exception;

import pairmatching.constant.Constant;

public class SelectMatchingInformationException {
	private static final String LENGTH_ERROR = "과정, 레벨, 미션 정보를 예시에 맞게 입력해야 합니다.";


	public static void isValidMatchingInformation(String[] information) {
		length(information.length);
		course(information[Constant.COURSE_INDEX]);
		level(information[Constant.LEVEL_INDEX]);
		mission(information[Constant.MISSION_INDEX]);
	}

	private static void length(int length) {
		if(!(length == 3)) {
			throw new IllegalArgumentException(LENGTH_ERROR);
		}
	}

	private static void course(String course) {

	}

	private static void level(String level) {

	}

	private static void mission(String mission) {

	}
}
