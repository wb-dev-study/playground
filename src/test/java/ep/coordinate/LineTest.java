package ep.coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("X, Y 좌표는 24 보다 큰 값을 입력할 수 없다")
    void create_position_max_value_error() {
        Position x = new Position(7, 8);
        Position y = new Position(4, 4);
        Line line = new Line(x, y);
        assertThat(line.length()).isEqualTo(5);
    }
}
