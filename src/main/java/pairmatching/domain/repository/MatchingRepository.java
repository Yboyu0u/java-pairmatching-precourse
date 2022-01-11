package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pairmatching.exception.MatchingRepositoryException;

public class MatchingRepository {
	private final List<Matching> matchingList;

	public MatchingRepository() {
		this.matchingList = new ArrayList<>();
	}

	public boolean save(Matching matching) {
		matchingList.add(matching);

		return true;
	}



	public List<String> read(Matching beFindMatching) {
		Optional<Matching> findMatching = matchingList.stream()
			.filter(matching -> matching.equals(beFindMatching))
			.findFirst();

		MatchingRepositoryException.isValidRead(findMatching);

		return findMatching.get().getCrewNames();
	}

	public void deleteAll() {
		matchingList.clear();
	}

	public boolean isContain(Matching matching) {
		if (matchingList.contains(matching)) {
			return true;
		}

		return false;
	}

	public boolean isEmpty() {
		return matchingList.isEmpty();
	}
}
