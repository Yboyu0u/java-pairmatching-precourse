package pairmatching.domain.repository.enumclass;

import java.util.Arrays;
import java.util.Optional;

import pairmatching.exception.SelectMatchingInformationException;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String name;

	Level(String name) {
		this.name = name;
	}

	public static Level nameToLevel(String levelName) {
		Optional<Level> findLevel = Arrays.stream(Level.values())
			.filter(level -> level.name.equals(levelName))
			.findFirst();

		SelectMatchingInformationException.isValidLevel(findLevel);

		return findLevel.get();
	}

	public String getName() {
		return name;
	}
}
