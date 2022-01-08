package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
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
		if(functionNumber.equals("1") || functionNumber.equals("2")) {
			selectMatchingInformation();
			return true;
		}

		if(functionNumber.equals("3")) {
			return true;
		}

		return false;
	}

	public void selectMatchingInformation() {
		try {
			InputView.selectMatchingInformation();
			matchingService.selectMatchingInformation(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}
}
