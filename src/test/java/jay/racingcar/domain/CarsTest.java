package jay.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarsTest {
    @Test
    public void generateCars() {
        Cars cars = new Cars(Arrays.asList("1", "2", "3"));
        Assertions.assertThat(cars.getRacingCars().size()).isEqualTo(3);
    }

    @Test
    public void generateFailCars() {
        Assertions.assertThatThrownBy(() ->
                new Cars(Arrays.asList("1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 하나 이상의 자동차 이름을 입력하세요.");
    }
}