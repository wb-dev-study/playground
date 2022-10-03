package owen.racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CarsTest {

    @DisplayName("사용자 입력값으로 Cars 생성_성공")
    @Test
    void createCars_success() {
        Cars cars = new Cars(Arrays.asList("1번차", "2번차", "3번차"));
        List<Car> carList = cars.getCarList();
        int size = carList.size();
        Assertions.assertThat(size).isEqualTo(3);
    }

    @DisplayName("사용자 입력값으로 Cars 생성_실패(빈칸입력)")
    @Test
    void createCars_fail_blankName() {
        List<String> inputCar = Arrays.asList("", "2번차", "3번차");
        Assertions.assertThatThrownBy(() -> new Cars(inputCar)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 빈칸일 수 없습니다.");
    }

    @DisplayName("사용자 입력값으로 Cars 생성_실패(1개의 자동차 입력)")
    @Test
    void createCars_fail_minCarNum() {
        List<String> inputCar = Arrays.asList("3번차");
        Assertions.assertThatThrownBy(() -> new Cars(inputCar)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차는 최소 2개 이상 입력하여야 합니다");
    }

    @DisplayName("사용자 입력값으로 Cars 생성_실패(중복된 자동차이름 입력)")
    @Test
    void createCars_fail_duplicateCar() {
        List<String> inputCar = Arrays.asList("3번차", "3번차");
        Assertions.assertThatThrownBy(() -> new Cars(inputCar)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복된 자동차 이름은 입력할 수 없습니다.");
    }
}