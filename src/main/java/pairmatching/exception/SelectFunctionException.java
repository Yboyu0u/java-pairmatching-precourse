package pairmatching.exception;

import pairmatching.constant.Constant;

public class SelectFunctionException {
	private static final String INVALID_FUNCTION_ERROR = "기능은 1, 2, 3, Q 중에 선택돼야 합니다.";

	public static void isValidFunctionNumber(String functionNumber) {
		if (!(functionNumber.equals(Constant.OPTION_ONE) || functionNumber.equals(Constant.OPTION_TWO) ||
			functionNumber.equals(Constant.OPTION_THREE) || functionNumber.equals(Constant.OPTION_EXIT))) {
			throw new IllegalArgumentException(INVALID_FUNCTION_ERROR);
		}
	}
}
