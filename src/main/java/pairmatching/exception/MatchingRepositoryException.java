package pairmatching.exception;

import java.util.Optional;

import pairmatching.domain.repository.Matching;

public class MatchingRepositoryException {
	private static final String READ_ERROR = "해당 정보는 매칭 기록이 없습니다.";

	public static void isValidRead(Optional<Matching> matching) {
		if (!matching.isPresent()) {
			throw new IllegalArgumentException(READ_ERROR);
		}
	}
}
