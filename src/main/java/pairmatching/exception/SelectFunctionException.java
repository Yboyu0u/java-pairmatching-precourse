package pairmatching.exception;

import pairmatching.constant.Constant;

public class SelectFunctionException {
	private static final String INVALID_FUNCTION_ERROR = "기능은 1, 2, 3, Q 중에 선택돼야 합니다.";
	private static final String IMPOSSIBLE_READ_ERROR = "등록된 매칭 기록이 없습니다, 우선 패어 매칭을 진행해주세요.";

	public static void isValid(String functionNumber) {
		if (!(functionNumber.equals(Constant.OPTION_ONE) || functionNumber.equals(Constant.OPTION_TWO) ||
			functionNumber.equals(Constant.OPTION_THREE) || functionNumber.equals(Constant.OPTION_EXIT))) {
			throw new IllegalArgumentException(INVALID_FUNCTION_ERROR);
		}
	}

	public static void isPossibleRead(boolean isEmpty) {
		if (isEmpty) {
			throw new IllegalArgumentException(IMPOSSIBLE_READ_ERROR);
		}
	}
}
