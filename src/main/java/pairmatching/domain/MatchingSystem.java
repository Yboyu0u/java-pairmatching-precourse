package pairmatching.domain;

import pairmatching.view.OutputView;

public class MatchingSystem {
	private Function function;
	private String functionNumber;

	public MatchingSystem() {
		this.function = new Function();
	}

	public boolean saveFunctionNumber(String input) {
		if(input.equals("1") || input.equals("2") || input.equals("3")) {
			functionNumber = input;
			checkNumberIsThree(input);
			return true;
		}

		return false;
	}

	private void checkNumberIsThree(String input) {
		if(!input.equals("3")) {
			OutputView.printMatchingInformation();
		}
	}

	public void handleFunction(String information) {
		if(functionNumber.equals("1")) {
			function.matching(information);
		}

		if(functionNumber.equals("2")) {
			function.check(information);
		}

		if(functionNumber.equals("3")) {
			function.initialize(information);
		}
	}
}
