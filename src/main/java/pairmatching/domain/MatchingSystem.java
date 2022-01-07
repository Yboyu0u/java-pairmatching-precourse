package pairmatching.domain;

import pairmatching.view.OutputView;

public class MatchingSystem {

	public boolean handleMatching() {
		OutputView.printMatchingInformation();
		return true;
	}

	public boolean handleCheck() {
		OutputView.printMatchingInformation();
		return true;
	}

	public boolean handleInitialize() {
		return true;
	}
}
