package pairmatching.exception;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;

public class MatchingChecker {
	private static final Map<Mission, Level> checkMap = new HashMap<>();

	public static void initMap() {
		initLevelOne();
		initLevelTwo();
		initLevelFour();
	}

	private static void initLevelOne() {
		Level level = Level.LEVEL1;
		checkMap.put(Mission.CAR_RACE, level);
		checkMap.put(Mission.LOTTO, level);
		checkMap.put(Mission.BASEBALL_GAME, level);
	}

	private static void initLevelTwo() {
		Level level = Level.LEVEL2;
		checkMap.put(Mission.BASKET, level);
		checkMap.put(Mission.PAYMENT, level);
		checkMap.put(Mission.SUBWAY_PATH, level);
	}

	private static void initLevelFour() {
		Level level = Level.LEVEL4;
		checkMap.put(Mission.UPGRADE, level);
		checkMap.put(Mission.DISTRIBUTION, level);
	}

	public static void isValidLevelAndMission(Level level, Mission mission) {
		if (checkMap.get(mission) != level) {
			SelectMatchingInformationException.isValidLevelAndMission();
		}
	}

}
