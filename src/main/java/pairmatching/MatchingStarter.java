package pairmatching;

import pairmatching.controller.MatchingController;

public class MatchingStarter {
	private MatchingController matchingController = new MatchingController();

	public void start() {
		boolean check;
		do {
			check = matchingController.selectFunction();
		} while(check);
	}
}
