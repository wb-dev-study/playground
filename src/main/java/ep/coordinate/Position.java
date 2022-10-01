package ep.coordinate;

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
        if (MAX_VALUE < argument || argument < MIN_VALUE) {
            throw new IllegalArgumentException("x 좌표는 " + MIN_VALUE + "보다 크고 " + MAX_VALUE + "보다 작아야 합니다.");
        }
    }
}
