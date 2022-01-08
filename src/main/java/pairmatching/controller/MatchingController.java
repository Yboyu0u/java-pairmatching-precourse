package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Constant;
import pairmatching.exception.dto.ResponseError;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;

public class MatchingController {
	private MatchingService matchingService;

	public MatchingController() {
		this.matchingService = new MatchingService();
	}

	public boolean selectFunction() {
		boolean check = false;

		try {
			InputView.selectFunction();
			check = checkFunctionNumber(matchingService.selectFunction(Console.readLine()));
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

		return check;
	}

	private boolean checkFunctionNumber(String functionNumber) {
		if(functionNumber.equals(Constant.OPTION_ONE) || functionNumber.equals(Constant.OPTION_TWO)) {
			selectMatchingInformation(functionNumber);
			return true;
		}

		if(functionNumber.equals(Constant.OPTION_THREE)) {
			return true;
		}

		return false;
	}

	public void selectMatchingInformation(String functionNumber) {
		try {
			InputView.selectMatchingInformation();
			matchingService.selectMatchingInformation(functionNumber, Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}
}
