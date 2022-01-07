package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.dto.ResponseError;
import pairmatching.service.MatchingService;

public class MatchingController {
	private MatchingService matchingService;

	public MatchingController() {
		this.matchingService = new MatchingService();
	}

	public boolean selectFunction() {
		try {
			if(matchingService.selectFunction(Console.readLine())) {
				selectMatchingInformation();
			}
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

		return true;
	}

	public void selectMatchingInformation() {
		try {
			matchingService.selectMatchingInformation(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}
}
