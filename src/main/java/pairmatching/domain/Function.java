package pairmatching.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.repository.Matching;
import pairmatching.domain.repository.MatchingRepository;
import pairmatching.domain.repository.enumclass.Course;
import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;
import pairmatching.utils.FileUtil;
import pairmatching.view.OutputView;

public class Function {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	private MatchingRepository matchingRepository;

	public Function() {
		matchingRepository = new MatchingRepository();
	}

	public void matching(String[] information) {
		//TODO: 이미 매칭된 결과과 있을 때 error 처리

		List<String> matchingResult = Randoms.shuffle(FileUtil.read(makeFilename(information[COURSE_INDEX])));
		matchingRepository.save(new Matching(Course.nameToCourse(information[COURSE_INDEX]),
			Level.nameToLevel(information[LEVEL_INDEX]),
			Mission.nameToMission(information[MISSION_INDEX]),
			matchingResult));

		OutputView.printMatchingResult(matchingResult);
	}

	private String makeFilename(String course) {
		if(course.equals("백엔드")) {
			return "backend-crew.md";
		}

		return "frontend-crew.md";
	}

	public void check(String[] information) {
		// TODO: 매칭 기록이 없는 정보일 때 error 처리
	}

	public void initialize(String[] information) {

	}
}
