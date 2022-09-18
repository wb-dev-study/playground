package ep.baseball;

import ep.baseball.domain.ball.Ball;
import ep.baseball.exception.CreateBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
