package ep.racingcar;

import ep.racingcar.domain.Car;
import ep.racingcar.domain.CarName;
import ep.racingcar.domain.Position;
import ep.racingcar.domain.strategy.DefaultMovingStrategy;
import ep.racingcar.domain.strategy.MovingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("ep"), new Position());
    }


    @Test
    @DisplayName("자동차는 이름과 위치를 가질 수 있다")
    void generate_car() {
        Car newCar = new Car(new CarName("ep"), new Position());
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
}
