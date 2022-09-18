package ep.baseball;

import ep.baseball.domain.ball.Ball;
import ep.baseball.domain.ball.Balls;
import ep.baseball.exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    @Test
    @DisplayName("중복되는 위치에 볼이 있으면 안됩니다")
    void create_balls() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(2,2);
        Ball third = new Ball(3, 2);
        assertThatThrownBy(() -> new Balls(first, second, third))
                .isInstanceOf(BallException.class);
    }
}
