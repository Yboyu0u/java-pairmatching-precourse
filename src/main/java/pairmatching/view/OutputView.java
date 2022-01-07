package pairmatching.view;

import pairmatching.view.message.Message;

public class OutputView {
	private static final String MATCHING_DIVISOR = " : ";

	public static void printMatchingInformation() {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_INFORMATION);
	}

	public static void printMatchingResult() {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_RESULT);
		//TODO: 매칭 결과 :
		System.out.println();
	}

	public static void printInitialized() {
		System.out.println();
		System.out.println(Message.PRINT_INITIALIZED);
		System.out.println();
	}
}
