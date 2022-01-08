package pairmatching.view;

import java.util.List;

import pairmatching.view.message.Message;

public class OutputView {
	private static final String MATCHING_DIVISOR = " : ";

	public static void printMatchingInformation() {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_INFORMATION);
	}

	public static void printMatchingResult(List<String> crewNames) {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_RESULT);
		formatCrewNames(crewNames);
		System.out.println();
	}

	private static void formatCrewNames(List<String> crewNames) {
		int index = 0;
		while (index < crewNames.size() - 1) {
			System.out.print(crewNames.get(index) + MATCHING_DIVISOR + crewNames.get(index + 1));

			if (index + 2 == crewNames.size() - 1) {
				System.out.print(MATCHING_DIVISOR + crewNames.get(index + 2));
			}
			System.out.println();
			index += 2;
		}
	}

	public static void printInitialized() {
		System.out.println();
		System.out.println(Message.PRINT_INITIALIZED);
		System.out.println();
	}
}
