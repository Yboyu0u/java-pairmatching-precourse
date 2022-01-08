package pairmatching.domain;

import pairmatching.view.OutputView;

public class MatchingSystem {
	private static final String OPTION_ONE = "1";
	private static final String OPTION_TWO = "2";
	private static final String OPTION_THREE = "3";

	private Function function;
	private String functionNumber;

	public MatchingSystem() {
		this.function = new Function();
	}

	public boolean saveFunctionNumber(String input) {
		if(input.equals(OPTION_ONE) || input.equals(OPTION_TWO) || input.equals(OPTION_THREE)) {
			functionNumber = input;
			checkNumberIsThree(input);
			return true;
		}

		return false;
	}

	private void checkNumberIsThree(String input) {
		if(!input.equals(OPTION_THREE)) {
			OutputView.printMatchingInformation();
		}
	}

	public void handleFunction(String[] information) {
		//TODO: 정보를 과정, 미션, 레벨로 쪼개기

		if (functionNumber.equals(OPTION_ONE)) {
			function.matching(information);
		}

		if (functionNumber.equals(OPTION_TWO)) {
			function.check(information);
		}

		if (functionNumber.equals(OPTION_THREE)) {
			function.initialize();
		}
	}
}
