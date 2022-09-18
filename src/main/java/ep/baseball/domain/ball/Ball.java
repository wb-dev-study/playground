package ep.baseball.domain.ball;

import ep.baseball.domain.MatchStatus;

public class Ball {

    private final BallNumber number;
    private final Position position;


    public Ball(final Integer number, final Integer position) {
        this.number = new BallNumber(number);
        this.position = new Position(position);
    }

    public BallNumber ballNumber() {
        return this.number;
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (!number.equals(ball.number)) return false;
        return position.equals(ball.position);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    public Boolean isStrike(Ball target) {
        return this.equals(target);
    }

    public Boolean isBall(Ball target) {
        return this.number.equals(target.ballNumber()) && !this.position.equals(target.position());
    }
}
