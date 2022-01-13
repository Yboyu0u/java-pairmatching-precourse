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
		// TODO: 이전의 매칭들 비교해서 같은 크루로 만난 적이 있는 크루 있을 시 재매칭
		List<String> shuffledCrewNames = Randoms.shuffle(FileUtil.read(information[Constant.COURSE_INDEX]));
		Matching matching = makeMatching(information, shuffledCrewNames);

		boolean check = isRematching(matching);
		if(!check) {
			matchingRepository.save(matching);
			OutputView.printMatchingResult(matching.getPairList());
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
		Matching matching = makeMatching(information, new ArrayList<>());

		OutputView.printMatchingResult(matchingRepository.read(matching));

		return false;
	}

	public void initialize() {
		matchingRepository.deleteAll();
		OutputView.printInitialized();
	}

	private Matching makeMatching(String[] information, List<String> crewNames) {
		return new Matching(Course.nameToCourse(information[Constant.COURSE_INDEX]),
			Level.nameToLevel(information[Constant.LEVEL_INDEX]),
			Mission.nameToMission(information[Constant.MISSION_INDEX]),
			makePairList(crewNames));
	}

	private List<Pair> makePairList(List<String> crewNames) {
		List<Pair> pairList = new ArrayList<>();

		int index = 0;
		while (index < crewNames.size() - 1) {
			Pair pair = new Pair();
			pair.add(crewNames.get(index));
			pair.add(crewNames.get(index+1));

			if (index + 2 == crewNames.size() - 1) {
				pair.add(crewNames.get(index + 2));
			}

			pairList.add(pair);
			index += 2;
		}

		return pairList;
	}

	public boolean checkMatchingRecord() {
		return matchingRepository.isEmpty();
	}
}
