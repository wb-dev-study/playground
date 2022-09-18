package owen.baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import owen.baseball.domain.ball.Ball;
import owen.baseball.domain.ball.Balls;

import java.util.Arrays;

class BallFactoryTest {

    @Test
    @DisplayName("숫자는 1~9만 입력 가능")
    void outOfRange_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("012")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1 ~ 9 까지의 정수만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("정수가 아닐시 입력시 오류 발생")
    void inputOtherType_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("s@1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("정수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("3자리 이상의 숫자 입력시 오류 발생")
    void inputLength_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("1112")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리의 숫자를 입력 바랍니다.");

        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("11")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리의 숫자를 입력 바랍니다.");
    }

    @Test
    @DisplayName("중복된 숫자 입력시 오류 발생")
    void duplicate_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("111")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복된 숫자는 입력 불가능 합니다.");
    }

    @Test
    @DisplayName("정상 입력시 Balls.class instance return")
    void success_type() {
        Assertions.assertThat(BallFactory.makeBall("123")).isExactlyInstanceOf(Balls.class);
    }

}