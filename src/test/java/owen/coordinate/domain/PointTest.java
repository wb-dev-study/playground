package owen.coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("좌표 생성")
    @Test
    void createPoint() {
        Point point = new Point(1);
        Assertions.assertThat(point.getPoint()).isEqualTo(1);
    }

    @DisplayName("좌표 생성 실패")
    @Test
    void createPoint_Fail() {
        Assertions.assertThatThrownBy(() -> new Point(25)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("24보다 큰 수는 입력할 수 없습니다");
    }


}