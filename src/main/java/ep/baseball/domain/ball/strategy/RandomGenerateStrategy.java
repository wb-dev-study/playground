package ep.baseball.domain.ball.strategy;

import ep.baseball.domain.ball.Ball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RandomGenerateStrategy implements BallGenerateStrategy{

    private static final Integer MAX_BALL_NUMBER_INT = 9;
    private static final Integer MIN_BALL_NUMBER_INT = 1;

    @Override
    public Set<Ball> generate() {
        Set<Integer> numberSet = new HashSet<>();
        Random random = new Random();
        while (numberSet.size() < 3) {
            numberSet.add(random.nextInt(MAX_BALL_NUMBER_INT) + MIN_BALL_NUMBER_INT);
        }
        AtomicInteger index = new AtomicInteger();
        return numberSet.stream().map(number -> new Ball(number, index.addAndGet(1))).collect(Collectors.toSet());
    }
}
