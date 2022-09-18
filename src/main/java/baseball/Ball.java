package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public Ball(int position, int ballNo) {
        validNumber(ballNo);
        this.position = position;
        this.ballNo = ballNo;
    }

    private void validNumber(int ballNo) {
        if (ballNo < MIN_NUMBER || ballNo > MAX_NUMBER) {
            throw new IllegalArgumentException("ballNo must be a number between 1 and 9");
        }
    }

    public baseball.BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNo(ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
