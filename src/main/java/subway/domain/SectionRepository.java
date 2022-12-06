package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() { return Collections.unmodifiableList(sections); }

    public static void addSection(Section section) { sections.add(section); }

    static {
        addSection(new Section("교대역", "강남역", 2, 3));
        addSection(new Section("강남역", "역삼역", 2, 3));
        addSection(new Section("교대역", "남부터미널역", 3, 2));
        addSection(new Section("남부터미널역", "양재역", 6, 5));
        addSection(new Section("양재역", "매봉역", 1, 1));
        addSection(new Section("강남역", "양재역", 2, 8));
        addSection(new Section("양재역", "양재시민의숲역", 10, 3));
    }
}
