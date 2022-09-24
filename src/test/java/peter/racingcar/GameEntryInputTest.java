package peter.racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import peter.racingcar.domain.Car;
import peter.racingcar.domain.GameEntryInput;
import peter.racingcar.domain.RacingCar;
import peter.racingcar.exception.NotEnoughEntryException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by peter on 2022/09/25
 */
public class GameEntryInputTest {

    @Test
    @DisplayName("게임 참가자 입력 테스트")
    void normalGameEntryTest() {
        GameEntryInput gameEntryInput = new GameEntryInput("peter,owen,ep,zoey, jay, haile", "5");
        List<Car> entry = Arrays.asList(new RacingCar("peter"), new RacingCar("owen"), new RacingCar("ep"), new RacingCar("zoey"), new RacingCar("jay"), new RacingCar("haile"));
        Assertions.assertThat(gameEntryInput.getEntries()).isEqualTo(entry);
    }


    @Test
    @DisplayName("참가자가 충분하지 않을 때 발생하는 예외")
    void notEnoughEntryException() {
        Assertions.assertThatThrownBy(() -> new GameEntryInput("peter", "5")).isInstanceOf(NotEnoughEntryException.class);
    }
}
