package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository {
	private List<Matching> matchingList;

	public MatchingRepository() {
		this.matchingList = new ArrayList<>();
	}

	public boolean save(Matching matching) {
		matchingList.add(matching);

		return true;
	}

	public Matching read(Matching beFindMatching) {
		return matchingList.stream()
			.filter(matching -> matching.equals(beFindMatching))
			.findFirst().get();
	}

	public void delete(Matching matching) {

	}

	public boolean checkInList() {
		return true;
	}

}
