package owen.coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import owen.coordinate.domain.abstrict.Figure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PointsTest {

    @DisplayName("숫자 리스트를 통한 좌표 생성")
    @Test
    void createPoints() {
        List<List<Integer>> numberList = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(12, 3), Arrays.asList(3, 4)));
        Points points = new Points(numberList);

        Assertions.assertThat(points.getCoordinates().size()).isEqualTo(3);
    }
}