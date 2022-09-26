package hailey.baseball;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    private int position;
    private BallNumber number;

    public BallNumber getNumber() {
        return this.number;
    }
    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public static List<Ball> makeBall(List<Integer> randomNo) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < randomNo.size(); i++) {
            Ball ball = new Ball(i, randomNo.get(i));
            balls.add(ball);
        }
        return balls;
    }

    public BallStatus compareAnswer(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNo(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number.getNo() == ball.number.getNo();
    }

    private boolean matchBallNo(BallNumber number) {
        return this.number.getNo() == number.getNo();
    }
}
