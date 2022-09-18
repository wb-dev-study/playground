package ep.baseball;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.Ball;
import ep.baseball.exception.CreateBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BallTest {

    @Test
    @DisplayName("볼은 1~9 이외의 숫자를 입력했을 때 예외가 발생한다")
    void ball_number_create() {
        assertThatThrownBy(() ->
            new Ball(0, 1)
        ).isInstanceOf(CreateBallException.class);
    }

    @Test
    @DisplayName("볼의 숫자는 1~3 에만 위치합니다.")
    void ball_position_create() {
        assertThatThrownBy(() ->
                new Ball(1, 4)
        ).isInstanceOf(CreateBallException.class);
    }

    @Test
    @DisplayName("볼의 숫자와 위치가 같으면 STRIKE")
    void ball_match_strike() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(1, 1);
        assertThat(first.isStrike(second)).isTrue();
    }

    @Test
    @DisplayName("볼의 숫자가 같고 위치가 다르면 BALL")
    void ball_match_ball() {
        Ball first = new Ball(1, 1);
        Ball second = new Ball(1, 2);
        assertThat(first.isBall(second)).isTrue();
    }
}
