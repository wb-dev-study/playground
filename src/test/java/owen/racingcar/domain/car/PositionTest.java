package owen.racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("포지션 생성 Test")
    @Test
    void position_createTest() {
        Position position = new Position();
        Assertions.assertThat(position.getPosition()).isEqualTo(0);
    }

    @DisplayName("포지션 변경 move Test")
    @Test
    void position_moveTest() {
        Position position = new Position();
        position.move();
        Assertions.assertThat(position.getPosition()).isEqualTo(1);
    }
}