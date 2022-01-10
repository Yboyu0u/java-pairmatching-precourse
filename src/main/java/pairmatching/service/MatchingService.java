package pairmatching.service;

import pairmatching.domain.MatchingSystem;
import pairmatching.exception.GlobalException;

public class MatchingService {
	private static final String BLANK = " ";
	private static final String NULL = "";
	private static final String INFORMATION_DIVISOR = ",";

	private MatchingSystem matchingSystem;

	public MatchingService() {
		this.matchingSystem = new MatchingSystem();
	}

	public String selectFunction(String input) {
		GlobalException.isValidFunctionNumber(input);

		return matchingSystem.handleFunctionNumber(input);
	}

	public boolean selectMatchingInformation(String functionNumber, String input) {
		String[] information = input.replaceAll(BLANK, NULL).split(INFORMATION_DIVISOR);
		// TODO: validation 처리
		return matchingSystem.handleFunction(functionNumber, information);
	}
}
