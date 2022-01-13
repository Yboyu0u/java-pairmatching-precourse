package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair {
	private List<String> crewNames;

	public Pair() {
		crewNames = new ArrayList<>();
	}

	public void add(String name) {
		crewNames.add(name);
	}

	public List<String> getCrewNames() {
		return crewNames;
	}

	@Override
	public boolean equals(Object o) {
		Pair pair = (Pair)o;
		return crewNames.containsAll(pair.crewNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crewNames);
	}
}
