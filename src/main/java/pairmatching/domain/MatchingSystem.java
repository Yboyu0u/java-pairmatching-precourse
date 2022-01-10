package pairmatching.domain;

import pairmatching.constant.Constant;
import pairmatching.view.OutputView;

public class MatchingSystem {

	private final Function function;

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

	public boolean handleFunction(String functionNumber, String[] information) {
		if (functionNumber.equals(Constant.OPTION_ONE)) {
			return function.matching(information);
		}

		if (functionNumber.equals(Constant.OPTION_TWO)) {
			return function.check(information);
		}

		return false;
	}
}
