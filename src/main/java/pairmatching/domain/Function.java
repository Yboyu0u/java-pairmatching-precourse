package pairmatching.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Constant;
import pairmatching.domain.repository.Matching;
import pairmatching.domain.repository.MatchingRepository;
import pairmatching.domain.repository.enumclass.Course;
import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;
import pairmatching.utils.FileUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Function {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	private final MatchingRepository matchingRepository;

	public Function() {
		matchingRepository = new MatchingRepository();
	}

	public boolean matching(String[] information) {
		List<String> matchingResult = Randoms.shuffle(FileUtil.read(information[COURSE_INDEX]));

		Matching matching = new Matching(Course.nameToCourse(information[COURSE_INDEX]),
			Level.nameToLevel(information[LEVEL_INDEX]),
			Mission.nameToMission(information[MISSION_INDEX]),
			matchingResult);

		boolean check = isRematching(matching);

		if(!check) {
			matchingRepository.save(matching);
			OutputView.printMatchingResult(matchingResult);
		}

		return check;
	}

	private boolean isRematching(Matching matching) {
		if(matchingRepository.isContain(matching)) {
			InputView.selectRematching();
			return selectRematching(Console.readLine());
		}

		return false;
	}

	private boolean selectRematching(String input) {
		// TODO: validation 처리
		OutputView.printLineAlignment();
		return input.equals(Constant.REMATCHING_NO);
	}

	public boolean check(String[] information) {
		// TODO: 매칭 기록이 없는 정보일 때 error 처리
		OutputView.printMatchingResult(matchingRepository.read(new Matching(Course.nameToCourse(information[COURSE_INDEX]),
			Level.nameToLevel(information[LEVEL_INDEX]),
			Mission.nameToMission(information[MISSION_INDEX]),
			null)));

		return false;
	}

	public void initialize() {
		matchingRepository.deleteAll();
		OutputView.printInitialized();
	}
}
