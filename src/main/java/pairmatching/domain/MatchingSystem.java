package pairmatching.domain;

import pairmatching.constant.Constant;
import pairmatching.view.OutputView;

public class MatchingSystem {

	private Function function;

	public MatchingSystem() {
		this.function = new Function();
	}

	public String handleFunctionNumber(String functionNumber) {
		if (functionNumber.equals(Constant.OPTION_ONE) || functionNumber.equals(Constant.OPTION_TWO)
			|| functionNumber.equals(Constant.OPTION_THREE)) {
			checkNumberIsThree(functionNumber);
		}

		return functionNumber;
	}

	private void checkNumberIsThree(String input) {
		if(!input.equals(Constant.OPTION_THREE)) {
			OutputView.printMatchingInformation();
			return;
		}

		function.initialize();
	}

	public void handleFunction(String functionNumber, String[] information) {
		//TODO: 정보를 과정, 미션, 레벨로 쪼개기

		if (functionNumber.equals(Constant.OPTION_ONE)) {
			function.matching(information);
		}

		if (functionNumber.equals(Constant.OPTION_TWO)) {
			function.check(information);
		}
	}
}
