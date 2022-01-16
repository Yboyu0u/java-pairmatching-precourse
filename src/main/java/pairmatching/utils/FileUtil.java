package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private static final String BASE_PATH = "src/main/resources/";

	private static final String COURSE_BACKEND = "백엔드";
	private static final String FILE_NAME_BACKEND = "backend-crew.md";
	private static final String FILE_NAME_FRONTEND = "frontend-crew.md";

	public static List<String> read(String fileName) {
		List<String> crewNames = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(
				new FileReader(BASE_PATH + makeFileName(fileName)));

			while (true) {
				String line = bufferedReader.readLine();
				if (line == null) {
					break;
				}
				crewNames.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

	private static String makeFileName(String course) {
		if (course.equals(COURSE_BACKEND)) {
			return FILE_NAME_BACKEND;
		}

		return FILE_NAME_FRONTEND;
	}
}
