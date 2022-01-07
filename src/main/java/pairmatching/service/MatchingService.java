package pairmatching.service;

import pairmatching.domain.MatchingSystem;

public class MatchingService {
	private MatchingSystem matchingSystem;

	public MatchingService() {
		this.matchingSystem = new MatchingSystem();
	}

	public boolean selectFunction(String input) {
		// TODO: validation 처리
		return matchingSystem.saveFunctionNumber(input);
	}

	public void selectMatchingInformation(String input) {
		// TODO: validation 처리
		matchingSystem.handleFunction(input);
	}
}
