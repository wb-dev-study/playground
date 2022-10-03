package ep.racingcar;

import ep.baseball.exception.CreateBallException;
import ep.racingcar.domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름에 공백이 올 수 없습니다")
    void car_name_blank() {
        assertThatThrownBy(
                () -> new CarName("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 넘길 수 없습니다.")
    void car_name_over_length() {
        assertThatThrownBy(
                () -> new CarName("123456")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
