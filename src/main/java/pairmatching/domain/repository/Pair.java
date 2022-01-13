package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;

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
}
