package pairmatching.service;

import pairmatching.domain.MatchingSystem;

public class MatchingService {
	private static final String BLANK = " ";
	private static final String NULL = "";
	private static final String INFORMATION_DIVISOR = ",";

	private MatchingSystem matchingSystem;

	public MatchingService() {
		this.matchingSystem = new MatchingSystem();
	}

	public boolean selectFunction(String input) {
		// TODO: validation 처리
		return matchingSystem.saveFunctionNumber(input);
	}

	public void selectMatchingInformation(String input) {
		String[] information = input.replaceAll(BLANK, NULL).split(INFORMATION_DIVISOR);
		// TODO: validation 처리
		matchingSystem.handleFunction(information);
	}
}
