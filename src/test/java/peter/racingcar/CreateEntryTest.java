package peter.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import peter.racingcar.domain.RacingCar;
import peter.racingcar.exception.EntryNameTooLongException;

/**
 * Created by peter on 2022/09/24
 */
public class CreateEntryTest {
    @Test
    @DisplayName("참가자 생성 테스트")
    void createCar() {
        RacingCar entry = new RacingCar("peter");
        Assertions.assertThat(entry.getName()).isEqualTo("peter");
    }

    @Test
    @DisplayName("참가자 생성 테스트")
    void createCarWithEntryNameTooLongException() {
        Assertions.assertThatThrownBy(() -> new RacingCar("peter's second car")).isInstanceOf(EntryNameTooLongException.class);
    }
}
