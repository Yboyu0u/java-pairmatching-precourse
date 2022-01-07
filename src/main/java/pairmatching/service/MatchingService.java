package pairmatching.service;

import pairmatching.domain.MatchingSystem;

public class MatchingService {
	private MatchingSystem matchingSystem;

	public MatchingService() {
		this.matchingSystem = new MatchingSystem();
	}

	public boolean selectFunction(String input) {
		// TODO: validation 처리
		if(input.equals("1")) {
			return matchingSystem.handleMatching();
		}

		if(input.equals("2")) {
			return matchingSystem.handleCheck();
		}

		if(input.equals("3")) {
			return matchingSystem.handleInitialize();
		}

		return false;
	}

	public void selectMatchingInformation(String input) {

	}
}
