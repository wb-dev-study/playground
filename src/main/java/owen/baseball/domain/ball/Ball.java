package owen.baseball.domain.ball;


import owen.baseball.domain.BallStatus;

import java.util.Objects;

public class Ball {

    private final int ballNumber;
    private final int position;

    public Ball(int ballNumber, int position) {
        this.ballNumber = ballNumber;
        this.position = position;
    }

    public BallStatus playBall(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (isBall(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean isBall(Ball ball) {
        return this.ballNumber == ball.ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }
}
