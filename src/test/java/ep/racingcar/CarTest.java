package ep.racingcar;

import ep.racingcar.domain.Car;
import ep.racingcar.domain.strategy.DefaultMovingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("ep");
    }


    @Test
    @DisplayName("자동차는 이름과 위치를 가질 수 있다")
    void generate_car() {
        Car newCar = new Car("ep");
        assertThat(car).isEqualTo(newCar);
    }

    @Test
    @DisplayName("자동차는 위치를 움직일 수 있다.")
    void car_move() {
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 moving 전략으로 함수형 인터페이스 인자를 받을 수 있다")
    void car_moving_strategy() {
        car.move(new DefaultMovingStrategy());
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 moving 전략으로 람다를 인자를 받을 수 있다")
    void car_moving_strategy_lambda() {
        car.move(car -> {
            car.move();
            car.move();
        });
        assertThat(car.currentPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 누가 앞에 있는지 확인할 수 있다")
    void car_is_win() {
        Car another = new Car("another");

        car.move();
        car.move();
        another.move();

        assertThat(car.isWin(another)).isTrue();
    }
}
