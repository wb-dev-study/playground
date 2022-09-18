package ep.baseball;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.Ball;
import ep.baseball.domain.ball.Balls;
import ep.baseball.domain.ball.strategy.RandomGenerateStrategy;
import ep.baseball.exception.BallException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @DisplayName("3스트라이크")
    void balls_match_strike() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(2, 2);
        Ball third = new Ball(3, 3);
        Balls inputBalls = new Balls(first, second, third);

        List<MatchStatus> expected = List.of(MatchStatus.STRIKE, MatchStatus.STRIKE, MatchStatus.STRIKE);
        assertThat(balls.match(inputBalls)).containsAll(expected);
    }

    @Test
    @DisplayName("1 스트라이크 2 볼")
    void balls_match_ball() {
        Ball first = new Ball(2, 1);
        Ball second = new Ball(1, 2);
        Ball third = new Ball(3, 3);
        Balls inputBalls = new Balls(first, second, third);

        List<MatchStatus> expected = List.of(MatchStatus.BALL, MatchStatus.BALL, MatchStatus.STRIKE);
        assertThat(balls.match(inputBalls)).containsAll(expected);
    }

    @Test
    @DisplayName("낫싱")
    void balls_match_nothing() {
        Ball first = new Ball(7, 1);
        Ball second = new Ball(8, 2);
        Ball third = new Ball(9, 3);
        Balls inputBalls = new Balls(first, second, third);

        List<MatchStatus> expected = List.of(MatchStatus.NOTHING, MatchStatus.NOTHING, MatchStatus.NOTHING);
        assertThat(balls.match(inputBalls)).containsAll(expected);
    }

    @Test
    @DisplayName("랜덤 볼 리스트 생성")
    void generate_balls_random() {
        Balls balls = new Balls(new RandomGenerateStrategy());
        assertThat(balls).isNotNull();
    }
}
