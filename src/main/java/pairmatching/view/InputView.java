package pairmatching.view;

import pairmatching.view.message.Message;

public class InputView {

	public static void selectFunction() {
		System.out.println(Message.SELECT_FUNCTION);
		System.out.println();
	}

	public static void selectMatchingInformation() {
		System.out.println(Message.SELECT_MATCHING_INFORMATION);
	}

	public static void selectRematching() {
		System.out.println();
		System.out.println(Message.ASK_REMATCHING);
	}
}
