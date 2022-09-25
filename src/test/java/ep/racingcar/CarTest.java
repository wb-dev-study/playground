package ep.racingcar;

import ep.racingcar.domain.Car;
import ep.racingcar.domain.CarName;
import ep.racingcar.domain.Position;
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
    @DisplayName("자동차는_이름과_위치를_가질_수_있다")
    void generate_car() {
        Car newCar = new Car(new CarName("ep"), new Position());
        assertThat(car).isEqualTo(newCar);
    }
}
