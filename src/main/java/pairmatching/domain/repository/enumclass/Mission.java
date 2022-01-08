package pairmatching.domain.repository.enumclass;

import java.util.Arrays;

public enum Mission {
	CAR_RACE("자동차경주"),
	LOTTO("로또"),
	BASEBALL_GAME("숫자야구게임"),
	BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_PATH("지하철노선도"),
	UPGRADE("성능개선"),
	DISTRIBUTION("배포");

	private final String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission nameToMission(String missionName) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.name.equals(missionName))
			.findFirst().get();
	}

	public String getName() {
		return name;
	}
}
