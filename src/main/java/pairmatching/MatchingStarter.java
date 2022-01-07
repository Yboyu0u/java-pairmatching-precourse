package pairmatching;

import pairmatching.controller.MatchingController;

public class MatchingStarter {
	private static MatchingController matchingController = new MatchingController();

	public void start() {
		boolean check = true;
		do {
			check = matchingController.selectFunction();
		} while(check);
	}
}
