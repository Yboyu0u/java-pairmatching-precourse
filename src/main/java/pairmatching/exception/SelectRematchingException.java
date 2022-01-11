package pairmatching.exception;

import pairmatching.constant.Constant;

public class SelectRematchingException {
	private static final String INVALID_INPUT_ERROR = "네 또는 아니오로 선택해야 합니다.";

	public static void isValid(String input) {
		if (!(input.equals(Constant.REMATCHING_YES) || input.equals(Constant.REMATCHING_NO))) {
			throw new IllegalArgumentException(INVALID_INPUT_ERROR);
		}
	}
}
