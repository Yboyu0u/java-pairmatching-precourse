package pairmatching.exception;

import java.util.Optional;

import pairmatching.domain.repository.enumclass.Course;
import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;

public class SelectMatchingInformationException {
	private static final String LENGTH_ERROR = "과정, 레벨, 미션 정보를 예시에 맞게 입력해야 합니다.";
	private static final String COURSE_ERROR = "올바른 과정 정보를 입력해야 합니다.";
	private static final String LEVEL_ERROR = "올바른 레벨 정보를 입력해야 합니다.";
	private static final String MISSION_ERROR = "올바른 미션 정보를 입력해야 합니다.";

	public static void isValid(String[] information) {
		length(information.length);
	}

	private static void length(int length) {
		if (!(length == 3)) {
			throw new IllegalArgumentException(LENGTH_ERROR);
		}
	}

	public static void isValidCourse(Optional<Course> course) {
		if (!course.isPresent()) {
			throw new IllegalArgumentException(COURSE_ERROR);
		}
	}

	public static void isValidLevel(Optional<Level> level) {
		if (!level.isPresent()) {
			throw new IllegalArgumentException(LEVEL_ERROR);
		}
	}

	public static void isValidMission(Optional<Mission> mission) {
		if (!mission.isPresent()) {
			throw new IllegalArgumentException(MISSION_ERROR);
		}
	}
}
