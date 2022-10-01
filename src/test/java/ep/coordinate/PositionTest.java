package ep.coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
    좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다. #InputView
    X, Y좌표 모두 최대 24까지만 입력할 수 있다. #Position
    입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다. #InputView
    정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
    좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다. #InputView
    직선인 경우는 두 점 사이 거리를 계산해서 출력한다.
 */
public class PositionTest {

    @Test
    @DisplayName("X, Y 좌표는 24 보다 큰 값을 입력할 수 없다")
    void create_position_max_value_error() {
        assertThatThrownBy(() -> new Position(25, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("X, Y 좌표는 0보다 작은 값을 입력할 수 없다")
    void create_position_min_value_error() {
        assertThatThrownBy(() -> new Position(24, -1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두 포지션 사이의 거리를 구할 수 있다.")
    void distance() {
        Position x = new Position(7, 8);
        Position y = new Position(4, 4);
        Double result = x.distance(y);
        assertThat(result).isEqualTo(5);
    }
}
