package subway.domain;

public class Section {
    private final String departureStation;
    private final int kilometer;
    private final int requiredTime;
    private final String arrivalStation;

    public Section(String departureStation, String arrivalStation, int kilometer, int requiredTime) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.kilometer = kilometer;
        this.requiredTime = requiredTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (!departureStation.equals(section.departureStation) && !arrivalStation.equals(section.arrivalStation)) return false;
        return departureStation == section.departureStation && arrivalStation == section.arrivalStation;
    }

    @Override
    public int hashCode() {
        int result = departureStation.hashCode();
        result = 31 * result + arrivalStation.hashCode();
        return result;
    }
}
