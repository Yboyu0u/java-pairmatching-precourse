package pairmatching.view;

import java.util.List;

import pairmatching.domain.repository.Pair;
import pairmatching.view.message.Message;

public class OutputView {
	private static final String MATCHING_DIVISOR = " : ";

	public static void printMatchingInformation() {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_INFORMATION);
	}

	public static void printMatchingResult(List<Pair> pairList) {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_RESULT);
		pairList.forEach(pair ->
			System.out.println(String.join(MATCHING_DIVISOR, pair.getCrewNames())));
		System.out.println();
	}

	public static void printInitialized() {
		System.out.println();
		System.out.println(Message.PRINT_INITIALIZED);
		System.out.println();
	}

	public static void printLineAlignment() {
		System.out.println();
	}
}
