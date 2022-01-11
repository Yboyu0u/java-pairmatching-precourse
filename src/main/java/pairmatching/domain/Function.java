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
import pairmatching.exception.SelectRematchingException;
import pairmatching.utils.FileUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Function {
	private final MatchingRepository matchingRepository;

	public Function() {
		matchingRepository = new MatchingRepository();
	}

	public boolean matching(String[] information) {
		List<String> matchingResult = Randoms.shuffle(FileUtil.read(information[Constant.COURSE_INDEX]));

		Matching matching = new Matching(Course.nameToCourse(information[Constant.COURSE_INDEX]),
			Level.nameToLevel(information[Constant.LEVEL_INDEX]),
			Mission.nameToMission(information[Constant.MISSION_INDEX]),
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
		SelectRematchingException.isValid(input);

		OutputView.printLineAlignment();
		return input.equals(Constant.REMATCHING_NO);
	}

	public boolean check(String[] information) {
		Matching matching = new Matching(Course.nameToCourse(information[Constant.COURSE_INDEX]),
			Level.nameToLevel(information[Constant.LEVEL_INDEX]),
			Mission.nameToMission(information[Constant.MISSION_INDEX]),
			null);

		OutputView.printMatchingResult(matchingRepository.read(matching));

		return false;
	}

	public void initialize() {
		matchingRepository.deleteAll();
		OutputView.printInitialized();
	}
}
