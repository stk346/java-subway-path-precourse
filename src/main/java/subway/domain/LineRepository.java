package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    static {
        addLine(new Line("2호선"));
        addLine(new Line("3호선"));
        addLine(new Line("신분당선"));
    }

    static {
        Line secondLine = getLine("2호선");
        secondLine.addSection(new Section("교대역", "강남역", 2, 3));
        secondLine.addSection(new Section("강남역", "역삼역", 2, 3));

        Line thirdLine = getLine("3호선");
        thirdLine.addSection(new Section("교대역", "남부터미널역", 3, 2));
        thirdLine.addSection(new Section("남부터미널역", "양재역", 6, 5));
        thirdLine.addSection(new Section("양재역", "매봉역", 1, 1));

        Line newBoondangLine = getLine("신분당선");
        newBoondangLine.addSection(new Section("강남역", "양재역", 2, 8));
        newBoondangLine.addSection(new Section("양재역", "양재시민의숲역", 10, 3));
    }

    public static Line getLine(String name) {
        for (Line line : lines) {
            if (line.equals(name)) {
                return line;
            }
        }
        return null;
    }
}
