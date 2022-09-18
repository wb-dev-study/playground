package ep.baseball;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.Ball;
import ep.baseball.domain.ball.Balls;
import ep.baseball.exception.BallException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(2,2);
        Ball third = new Ball(3, 3);
        this.balls = new Balls(first, second, third);
    }

    @Test
    @DisplayName("중복되는 위치에 볼이 있으면 안됩니다")
    void create_balls_duplicate_position() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(2,2);
        Ball third = new Ball(3, 2);
        assertThatThrownBy(() -> new Balls(first, second, third))
                .isInstanceOf(BallException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 안됩니다")
    void create_balls_duplicate_number() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(2,2);
        Ball third = new Ball(2, 3);
        assertThatThrownBy(() -> new Balls(first, second, third))
                .isInstanceOf(BallException.class);
    }

    @Test
    @DisplayName("스트라이크 매치")
    void balls_match_strike() {
        Ball target = new Ball(1, 1);
        assertThat(balls.match(target)).isEqualTo(MatchStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 매치")
    void balls_match_ball() {
        Ball target = new Ball(1, 3);
        assertThat(balls.match(target)).isEqualTo(MatchStatus.BALL);
    }

    @Test
    @DisplayName("낫싱 매치")
    void balls_match_nothing() {
        Ball target = new Ball(9, 3);
        assertThat(balls.match(target)).isEqualTo(MatchStatus.NOTHING);
    }
}
