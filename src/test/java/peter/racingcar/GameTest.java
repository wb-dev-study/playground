package peter.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import peter.racingcar.domain.Car;
import peter.racingcar.domain.Game;
import peter.racingcar.domain.RacingCar;
import peter.racingcar.exception.EmptyEntryException;
import peter.racingcar.exception.InvalidRoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2022/09/24
 */
public class GameTest {

    @Test
    @DisplayName("Game 생성 테스트")
    void createGameTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new RacingCar("peter1"));
        cars.add(new RacingCar("peter2"));
        int round = 3;

        Game game = new Game(cars, round);
        Assertions.assertThat(game.getRound()).isEqualTo(round);
        Assertions.assertThat(game.getEntry()).isEqualTo(cars);
    }

    @Test
    @DisplayName("Game 생성 중 참가자가 없는 경우 exception 발생")
    void createGameTestWithThrowEmptyEntryException() {
        List<Car> cars = new ArrayList<>();
        int round = 3;

        Assertions.assertThatThrownBy(() -> new Game(cars, round)).isInstanceOf(EmptyEntryException.class);
    }

    @Test
    @DisplayName("Game 생성 중 round 범위가 벗어났을 경우 exception 발생")
    void createGameTestWithThrowInvalidRoundException() {
        List<Car> cars = new ArrayList<>();
        cars.add(new RacingCar("peter1"));
        cars.add(new RacingCar("peter2"));
        int round = 100;

        Assertions.assertThatThrownBy(() -> new Game(cars, round)).isInstanceOf(InvalidRoundException.class);
    }
}
