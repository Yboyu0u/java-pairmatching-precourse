package pairmatching.domain;

import pairmatching.constant.Constant;
import pairmatching.exception.SelectFunctionException;
import pairmatching.view.OutputView;

public class MatchingSystem {

	private final Function function;

	public MatchingSystem() {
		this.function = new Function();
	}

	public String handleFunctionNumber(String functionNumber) {
		if (functionNumber.equals(Constant.OPTION_ONE) || functionNumber.equals(Constant.OPTION_TWO)
			|| functionNumber.equals(Constant.OPTION_THREE)) {

			checkNumber(functionNumber);
		}

		return functionNumber;
	}

	private void checkNumber(String functionNumber) {
		if(!functionNumber.equals(Constant.OPTION_THREE)) {
			handleFunctionTwo(functionNumber);
			OutputView.printMatchingInformation();
			return;
		}

		function.initialize();
	}

	private void handleFunctionTwo(String functionNumber) {
		if(functionNumber.equals(Constant.OPTION_TWO)) {
			SelectFunctionException.isPossibleRead(function.checkMatchingRecord());
		}
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
