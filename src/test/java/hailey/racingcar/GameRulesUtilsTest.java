package hailey.racingcar;

import hailey.racingcar.util.GameRulesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRulesUtilsTest {

    @Test
    @DisplayName("자동차 이름 길이 1 ~ 5")
    void car_name_length() {
        Assertions.assertThatThrownBy(() -> GameRulesUtils.validateCarNameLength("123456")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 1 ~ 5글자까지 가능합니다. ex: 가나다라마");
        Assertions.assertThatThrownBy(() -> GameRulesUtils.validateCarNameLength("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 1 ~ 5글자까지 가능합니다. ex: 가나다라마");
    }

    @Test
    @DisplayName("자동차 이름 중복")
    void duplicate_name() {
        String[] carsNames = {"car","car","c","d"};
        Assertions.assertThatThrownBy(() -> GameRulesUtils.checkDuplicateName(0, "car", carsNames)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("car 이 중복입니다.");
    }

    @Test
    @DisplayName("전진 가능 확인")
    void possible_advance() {
        boolean possibleAdvance = GameRulesUtils.isPossibleAdvance(7);
        assertThat(possibleAdvance).isTrue();
    }

    @Test
    @DisplayName("전진 불가능 확인")
    void impossible_advance() {
        boolean impossibleAdvance = GameRulesUtils.isPossibleAdvance(3);
        assertThat(impossibleAdvance).isFalse();
    }
}
