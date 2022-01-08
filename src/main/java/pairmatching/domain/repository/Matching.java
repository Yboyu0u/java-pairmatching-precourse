package pairmatching.domain.repository;

import java.util.List;

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
}
