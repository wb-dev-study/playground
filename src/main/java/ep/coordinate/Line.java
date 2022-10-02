package ep.coordinate;

public class Line {

    private final Position first;
    private final Position second;

    public Line(final Position first, final Position second) {
        validate(first, second);
        this.first = first;
        this.second = second;
    }

    private void validate(Position first, Position second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Position 은 null 이 아니어야 합니다.");
        }
    }

    public Double length() {
        return first.distance(second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!first.equals(line.first)) return false;
        return second.equals(line.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
