package zoey.baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallGameTest {

    private List<Integer> computer;
    @BeforeEach
    void setUp() {
        computer = Arrays.asList(1, 2, 3);
    }

    @Test
    void strike_1_ball_2() {
        BallGame ballGame = new BallGame(computer, Arrays.asList(1, 3, 2));
        BallGameResult ballGameResult = ballGame.play();
        assertThat(ballGameResult.isThreeStrike()).isFalse();
        assertThat(ballGameResult.getResult()).isEqualTo("2 볼 1 스트라이크");
    }

    @Test
    void strike_3() {
        BallGame ballGame = new BallGame(computer, Arrays.asList(1, 2, 3));
        BallGameResult ballGameResult = ballGame.play();
        assertThat(ballGameResult.isThreeStrike()).isTrue();
    }

    @Test
    void nothing() {
        BallGame ballGame = new BallGame(computer, Arrays.asList(4, 5, 6));
        BallGameResult ballGameResult = ballGame.play();
        assertThat(ballGameResult.getResult()).isEqualTo("nothing!!");
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
