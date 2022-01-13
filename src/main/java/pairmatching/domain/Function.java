package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Constant;
import pairmatching.domain.repository.Matching;
import pairmatching.domain.repository.MatchingRepository;
import pairmatching.domain.repository.Pair;
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
		Matching matching = new Matching(information,
			Randoms.shuffle(FileUtil.read(information[Constant.COURSE_INDEX])));

		boolean check = isRematching(matching);
		if (!check) {
			save(matching);
		}

		return check;
	}

	private void save(Matching matching) {
		matchingRepository.save(matching);
		OutputView.printMatchingResult(matching.getPairList());
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
		Matching matching = new Matching(information, new ArrayList<>());

		OutputView.printMatchingResult(matchingRepository.read(matching));
		return false;
	}

	public void initialize() {
		matchingRepository.deleteAll();
		OutputView.printInitialized();
	}

	public boolean checkMatchingRecord() {
		return matchingRepository.isEmpty();
	}
}
