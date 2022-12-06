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

    public String getDepartureStation() {
        return departureStation;
    }

    public int getKilometer() {
        return kilometer;
    }

    public int getRequiredTime() {
        return requiredTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public boolean ifSame(String departureStation, String arrivalStation) throws IllegalArgumentException {
        if (this.departureStation.equals(departureStation) && this.arrivalStation.equals(arrivalStation)) {
            return true;
        }
        throw new IllegalArgumentException("올바른 역 이름을 입력해주세요.");
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
