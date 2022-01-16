package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pairmatching.constant.Constant;
import pairmatching.domain.repository.enumclass.Course;
import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;

public class Matching {
	private Course course;
	private Level level;
	private Mission mission;
	private List<Pair> pairList;

	public Matching(String[] information, List<String> crewNames) {
		this.course = Course.nameToCourse(information[Constant.COURSE_INDEX]);
		this.level = Level.nameToLevel(information[Constant.LEVEL_INDEX]);
		this.mission = Mission.nameToMission(information[Constant.MISSION_INDEX]);
		this.pairList = makePairList(crewNames);
	}

	private List<Pair> makePairList(List<String> crewNames) {
		List<Pair> pairList = new ArrayList<>();

		int index = 0;
		while (index < crewNames.size() - 1) {
			Pair pair = new Pair();
			pair.add(crewNames.get(index));
			pair.add(crewNames.get(index + 1));

			pair = checkOdd(index, pair, crewNames);

			pairList.add(pair);
			index += 2;
		}

		return pairList;
	}

	private Pair checkOdd(int index, Pair pair, List<String> crewNames) {
		if (index + 2 == crewNames.size() - 1) {
			pair.add(crewNames.get(index + 2));
		}

		return pair;
	}

	public boolean isContainPair(Matching matching) {
		return this.mission == matching.mission
			&& this.pairList.stream().anyMatch(pair -> matching.pairList.contains(pair));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Matching matching = (Matching)o;
		return course == matching.course && level == matching.level && mission == matching.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}

	public List<Pair> getPairList() {
		return pairList;
	}
}
