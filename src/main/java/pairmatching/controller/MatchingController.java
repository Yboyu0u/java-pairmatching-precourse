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
			if(matchingService.selectFunction(Console.readLine())) {
				check = true;
				selectMatchingInformation();
			}
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

		return check;
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
