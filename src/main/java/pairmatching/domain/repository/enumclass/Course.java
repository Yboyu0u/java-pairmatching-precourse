package pairmatching.domain.repository.enumclass;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public static Course nameToCourse(String courseName) {
		return Arrays.stream(Course.values())
			.filter(course -> course.name.equals(courseName))
			.findFirst().get();
	}

	public String getName() {
		return name;
	}
}
