package ep.coordinate.figure.material;

public class Position {

    private static Integer MAX_VALUE = 24;
    private static Integer MIN_VALUE = 0;

    private final Integer x;
    private final Integer y;

    public Position(final Integer x, final Integer y) {
        validate(x);
        validate(y);
        this.x = x;
        this.y = y;
    }

    private void validate(final Integer argument) {
        if (argument == null) {
            throw new IllegalArgumentException("좌표는 null 이 아니어야 합니다.");
        }
        if (MAX_VALUE < argument || argument < MIN_VALUE) {
            throw new IllegalArgumentException("x 좌표는 " + MIN_VALUE + "보다 크고 " + MAX_VALUE + "보다 작아야 합니다.");
        }
    }

    public Double distance(Position second) {
        return Math.sqrt(Math.pow(this.x - second.x, 2) + Math.pow(this.y - second.y, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!x.equals(position.x)) return false;
        return y.equals(position.y);
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}
