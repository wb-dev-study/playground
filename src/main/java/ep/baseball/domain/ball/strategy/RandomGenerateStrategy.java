package ep.baseball.domain.ball.strategy;

import ep.baseball.domain.ball.Ball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerateStrategy implements BallGenerateStrategy{

    private static final Integer MAX_BALL_NUMBER_INT = 9;
    private static final Integer MIN_BALL_NUMBER_INT = 1;

    @Override
    public Set<Ball> generate() {
        Set<Ball> balls = new HashSet<>();
        Random random = new Random();
        for (int position = 1; position <= 3; position++) {
            Ball ball = new Ball(random.nextInt(MAX_BALL_NUMBER_INT) + MIN_BALL_NUMBER_INT, position);
            balls.add(ball);
        }
        return balls;
    }
}
