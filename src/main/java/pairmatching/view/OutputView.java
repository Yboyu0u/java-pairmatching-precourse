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
		pairList.stream().forEach(pair -> System.out.println(String.join(MATCHING_DIVISOR,pair.getCrewNames())));
		/*formatCrewNames(pairList);*/
		System.out.println();
	}

	private static void formatCrewNames(List<Pair> pairList) {
		int index = 0;
		while (index < pairList.size() - 1) {
			System.out.print(pairList.get(index) + MATCHING_DIVISOR + pairList.get(index + 1));

			if (index + 2 == pairList.size() - 1) {
				System.out.print(MATCHING_DIVISOR + pairList.get(index + 2));
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

	public static void printLineAlignment() {
		System.out.println();
	}
}
