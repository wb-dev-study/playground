package ep.baseball.domain.ball;

import ep.baseball.domain.ball.strategy.RandomGenerateStrategy;

public class BallFactory {
    public static Balls answer() {
        return new Balls(new RandomGenerateStrategy());
    }
}
