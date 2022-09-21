package ep.baseball.domain.ball;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.strategy.BallGenerateStrategy;
import ep.baseball.exception.BallException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    private Set<Ball> balls = new HashSet<>();

    public Balls(BallGenerateStrategy generateStrategy) {
        this.balls = generateStrategy.generate();
    }

    public Balls(final Ball first, final Ball second, final Ball third) {
        this.balls.add(first);
        this.balls.add(second);
        this.balls.add(third);
        validate();
    }

    private void validate() {
        Set<BallNumber> ballNumbers = this.balls.stream().map(Ball::ballNumber).collect(Collectors.toSet());
        if (ballNumbers.size() != 3) {
            throw new BallException("볼 맞추기는 서로 다른 3개의 숫자만 가능합니다.");
        }
        Set<Position> positions = this.balls.stream().map(Ball::position).collect(Collectors.toSet());
        if (positions.size() != 3) {
            throw new BallException("중복되는 위치에 볼이 있습니다.");
        }
    }

    public Boolean isEqual(Balls target) {
        return match(target).stream().allMatch(status -> status == MatchStatus.STRIKE);
    }

    public List<MatchStatus> match(Balls targetBalls) {
        List<MatchStatus> matchResult = new ArrayList<>();
        targetBalls.balls.forEach(target -> {
            MatchStatus result = match(target);
            matchResult.add(result);
        });
        return matchResult;
    }

    private MatchStatus match(Ball target) {
        for (Ball ball : this.balls) {
            if (ball.isStrike(target)) {
                return MatchStatus.STRIKE;
            }
            if (ball.isBall(target)) {
                return MatchStatus.BALL;
            }
        }
        return MatchStatus.NOTHING;
    }

    public static Balls of(final Ball first, final Ball second, final Ball third) {
        return new Balls(first, second, third);
    }
}
