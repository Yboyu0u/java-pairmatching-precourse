package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

public class Function {
	private static final int COURSE = 0;
	private static final int LEVEL = 1;
	private static final int MISSION = 2;

	private int number;
	private MatchingSystem matchingSystem;

	public Function(int number) {
		this.number = number;
		this.matchingSystem = new MatchingSystem();
	}

	public void handleFunction(String[] information) throws IOException {
		String course = information[COURSE];
		String level = information[LEVEL];
		String mission = information[MISSION];

		if(number == 1) {
			matching(course,level,mission);
			return;
		}

		if(number == 2) {
			check(course,level,mission);
			return;
		}

		initialize(course,level,mission);
	}

	private void matching(String course, String level, String mission) throws IOException {
		String filePath = "";
		if(course.equals("백엔드")) {
			filePath = "backend-crew.md";
		}

		if(course.equals("프론트엔드")) {
			filePath = "frontend-crew.md";
		}
		List<String> matchingResult = Randoms.shuffle(getCrewNames(filePath));

		OutputView.printMatchingResult(matchingResult);
		matchingSystem.saveMatchingResult(matchingResult, course,  level, mission);
	}


	private List<String> getCrewNames(String filePath) throws IOException {
		List<String> crewName = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(
			new FileReader("src/main/resources/"+filePath));

		while(true) {
			String line = bufferedReader.readLine();
			crewName.add(line);
			if(line == null) break;
		}
		bufferedReader.close();

		return crewName;
	}

	private void check(String process, String level, String mission) {

	}

	private void initialize(String process, String level, String mission) {

	}

}
