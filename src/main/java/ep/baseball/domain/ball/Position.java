package ep.baseball.domain.ball;

import ep.baseball.exception.CreateBallException;

public class Position {
    private final Integer position;

    public Position(final Integer position) {
        validate(position);
        this.position = position;
    }

    public void validate(final Integer position) {
        if (position == null) {
            throw new CreateBallException("위치는 null 이면 안됩니다.");
        }
        if (position < 0 || position > 3) {
            throw new CreateBallException("숫자의 위치는 1 ~ 3 사이의 값만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position.equals(position1.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
