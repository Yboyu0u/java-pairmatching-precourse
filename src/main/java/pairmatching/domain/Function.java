package pairmatching.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Constant;
import pairmatching.domain.repository.Matching;
import pairmatching.domain.repository.MatchingRepository;
import pairmatching.exception.SelectMatchingInformationException;
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
		if (!isRematching(new Matching(information, new ArrayList<>()))) {
			return isTry(information);
		}

		return false;
	}

	private boolean isTry(String[] information) {
		for (int i = 0; i < 3; i++) {
			Matching matching = new Matching(information,
				Randoms.shuffle(FileUtil.read(information[Constant.COURSE_INDEX])));

			if (save(matching)) {
				return true;
			}
		}

		SelectMatchingInformationException.isCanNotMatching();
		return false;
	}

	private boolean save(Matching matching) {
		if (matchingRepository.save(matching)) {
			OutputView.printMatchingResult(matching.getPairList());
			return true;
		}

		return false;
	}

	private boolean isRematching(Matching matching) {
		if (matchingRepository.isContain(matching)) {
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
		return true;
	}

	public void initialize() {
		matchingRepository.deleteAll();
		OutputView.printInitialized();
	}

	public boolean checkMatchingRecord() {
		return matchingRepository.isEmpty();
	}
}
