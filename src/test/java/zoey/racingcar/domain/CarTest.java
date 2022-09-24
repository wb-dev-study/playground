package zoey.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("zoey");
    }


    @DisplayName("자동차이름이 6글자를 초과하면 예외발생")
    @Test
    void carNameShorterThan6(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("swimming"))
                .withMessage("자동차 이름은 5자 이하만 가능합니다");
    }

    @DisplayName("1칸 이동 후 현재 위치")
    @Test
    void getNameAndLocation가() {
        car.drive();
        String nameAndPosition = car.getNameAndPosition();
        assertThat(nameAndPosition).isEqualTo("zoey : --");
    }
}