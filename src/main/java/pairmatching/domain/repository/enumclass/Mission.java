package pairmatching.domain.repository.enumclass;

import java.util.Arrays;
import java.util.Optional;

import pairmatching.exception.SelectMatchingInformationException;

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
		Optional<Mission> findMission = Arrays.stream(Mission.values())
			.filter(mission -> mission.name.equals(missionName))
			.findFirst();

		SelectMatchingInformationException.isValidMission(findMission);

		return findMission.get();
	}

	public String getName() {
		return name;
	}
}
