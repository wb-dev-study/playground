package jay.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    public void carNameTest(String name) {
        Car car = new Car(name);
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"poaaabi", "acccccrong", "abcdefg"})
    public void carNameFailTest(String name) {
        Assertions.assertThatThrownBy(() ->
                new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하로만 입력가능합니다.");
    }

    @Test
    public void carMoveTest() {
        Car car = new Car("a");
        car.move(4);
        car.move(3);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void carWinnerTest() {
        Car carA = new Car("a");
        carA.move(4);

        Car carB = new Car("b");
        carB.move(3);

        Car carC = new Car("c");
        carC.move(2);

        Assertions.assertThat(carA.isWinner(1)).isTrue();
    }
}