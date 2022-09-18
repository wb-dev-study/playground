package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void nothing() {
        BallStatus status = com.compare(new Ball(2,5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = com.compare(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        BallStatus status = com.compare(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("ballNo 1 ~ 9 사이 숫자가 아니면 예외 발생")
    @Test
    void valid_ballNo_between_1_9() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ball(1, 10))
                .withMessage("ballNo must be a number between 1 and 9");
    }
}