package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallGameTest {

    @Test
    void play() {
        BallGame ballGame = new BallGame(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2));
        BallGameResult ballGameResult = ballGame.play();
        assertThat(ballGameResult.getBall()).isEqualTo(2);
        assertThat(ballGameResult.getStrike()).isEqualTo(1);

    }

    @DisplayName("중복된 숫자가 있는 경우 예외 발생")
    @Test
    void duplicate_numbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> new BallGame(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 3)))
                .withMessage("Numbers must not be duplicated");
    }

    @DisplayName("3자리 숫자가 아닌 경우 예외 발생")
    @Test
    void numbers_size_3() {
        assertThatIllegalArgumentException().isThrownBy(() -> new BallGame(Arrays.asList(1, 2, 3), Arrays.asList(1, 2)))
                .withMessage("The size of number list must be 3");
    }
}
