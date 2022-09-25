package owen.racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이름을 부여하여 자동차 생성확인")
    @Test
    void createCar_success() {
        Car car = new Car("포르쉐");
        String carName = car.getName();
        Assertions.assertThat(carName).isEqualTo("포르쉐");
        Assertions.assertThat(carName).isNotEqualTo("르노");
    }

    @DisplayName("처음 생성된 차의 위치는 0")
    @Test
    void createCar_position0() {
        Car car = new Car("포르쉐");
        int status = car.getPosition();
        Assertions.assertThat(status).isEqualTo(0);
    }

    @DisplayName("랜덥값이 4 이상이 나와 한번 움직이게 되는 차(성공)")
    @Test
    void move_car_1position_success() {
        Car car = new Car("포르쉐");
        car.move(4);
        int status = car.getPosition();
        Assertions.assertThat(status).isEqualTo(1);
    }

    @DisplayName("랜덥값이 4 이상이 나와 한번 움직이게 되는 차(실패)")
    @Test
    void move_car_1position_fail() {
        Car car = new Car("포르쉐");
        car.move(3);
        int status = car.getPosition();
        Assertions.assertThat(status).isEqualTo(0);
        Assertions.assertThat(status).isNotEqualTo(1);
    }

}