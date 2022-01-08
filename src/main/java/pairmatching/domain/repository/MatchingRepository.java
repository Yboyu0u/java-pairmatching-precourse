package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository {
	private List<Matching> matchingList;

	public MatchingRepository() {
		this.matchingList = new ArrayList<>();
	}

	public void save(Matching matching) {
		matchingList.add(matching);
	}

	public void read(Matching matching) {

	}

	public void delete(Matching matching) {

	}

}
