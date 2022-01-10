package pairmatching.exception;

import pairmatching.constant.Constant;

public class GlobalException {
	private static final String SELECT_FUNCTION_ERROR = "기능은 1, 2, 3, Q 중에 선택돼야 합니다.";

	public static void isValidFunctionNumber(String input) {
		if (!(input.equals(Constant.OPTION_ONE) || input.equals(Constant.OPTION_TWO) ||
			input.equals(Constant.OPTION_THREE) || input.equals(Constant.OPTION_EXIT))) {
			throw new IllegalArgumentException(SELECT_FUNCTION_ERROR);
		}
	}
}
