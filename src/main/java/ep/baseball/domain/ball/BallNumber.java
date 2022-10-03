package ep.baseball.domain.ball;

import ep.baseball.exception.CreateBallException;

public class BallNumber {
    private final Integer number;

    public BallNumber(final Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(final Integer number) {
        if (number == null) {
            throw new CreateBallException("숫자는 null 이면 안됩니다.");
        }
        if (number < 1) {
            throw new CreateBallException("숫자는 1보다 작을 수 없습니다.");
        }
        if (number > 9) {
            throw new CreateBallException("숫자는 9보다 클 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BallNumber that = (BallNumber) o;

        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
