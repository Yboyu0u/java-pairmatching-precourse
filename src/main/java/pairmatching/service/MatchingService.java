package pairmatching.service;

import pairmatching.domain.MatchingSystem;
import pairmatching.exception.SelectFunctionException;
import pairmatching.exception.SelectMatchingInformationException;

public class MatchingService {
	private static final String BLANK = " ";
	private static final String NULL = "";
	private static final String INFORMATION_DIVISOR = ",";

	private MatchingSystem matchingSystem;

	public MatchingService() {
		this.matchingSystem = new MatchingSystem();
	}

	public String selectFunction(String input) {
		SelectFunctionException.isValidFunctionNumber(input);

		return matchingSystem.handleFunctionNumber(input);
	}

	public boolean selectMatchingInformation(String functionNumber, String input) {
		String[] information = input.replaceAll(BLANK, NULL).split(INFORMATION_DIVISOR);
		SelectMatchingInformationException.isValidMatchingInformation(information);

		return matchingSystem.handleFunction(functionNumber, information);
	}
}
