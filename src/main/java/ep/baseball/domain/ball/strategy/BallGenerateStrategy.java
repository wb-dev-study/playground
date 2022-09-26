package ep.baseball.domain.ball.strategy;

import ep.baseball.domain.ball.Ball;

import java.util.Set;

@FunctionalInterface
public interface BallGenerateStrategy {
    Set<Ball> generate();
}
