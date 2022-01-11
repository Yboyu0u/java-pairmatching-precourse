package pairmatching.exception;

import java.util.Optional;

import pairmatching.domain.repository.Matching;

public class MatchingRepositoryException {
	private static final String READ_ERROR = "이루어진 적 앖는 매칭 정보입니다.";

	public static void isValidRead(Optional<Matching> matching) {
		if (!matching.isPresent()) {
			throw new IllegalArgumentException(READ_ERROR);
		}
	}
}
