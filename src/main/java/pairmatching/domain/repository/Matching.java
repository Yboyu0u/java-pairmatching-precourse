package pairmatching.domain.repository;

import java.util.List;
import java.util.Objects;

import pairmatching.domain.repository.enumclass.Course;
import pairmatching.domain.repository.enumclass.Level;
import pairmatching.domain.repository.enumclass.Mission;

public class Matching {
	private Course course;
	private Level level;
	private Mission mission;
	private List<String> crewNames;

	public Matching(Course course, Level level, Mission mission, List<String> crewNames) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.crewNames = crewNames;
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

	public List<String> getCrewNames() {
		return crewNames;
	}
}
