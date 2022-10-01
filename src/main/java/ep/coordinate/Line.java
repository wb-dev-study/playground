package ep.coordinate;

public class Line {

    private final Position first;
    private final Position second;

    public Line(final Position first, final Position second) {
        this.first = first;
        this.second = second;
    }

    public Double length() {
        return first.distance(second);
    }
}
