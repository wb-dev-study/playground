package ep.baseball.domain.ball;

import ep.baseball.exception.BallException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    private final Set<Ball> balls = new HashSet<>();

    public Balls(final Ball first, final Ball second, final Ball third) {
        this.balls.add(first);
        this.balls.add(second);
        this.balls.add(third);
        validate();
    }

    private void validate() {
        if (this.balls.size() != 3) {
            throw new BallException("볼 맞추기는 3개만 가능합니다.");
        }
        Set<Position> positions = this.balls.stream().map(Ball::position).collect(Collectors.toSet());
        if (positions.size() != 3) {
            throw new BallException("중복되는 위치에 볼이 있습니다.");
        }
    }
}
