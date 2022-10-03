package owen.racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarNameTest {

    @DisplayName("이름 객체 생성 테스트_성공")
    @Test
    void createName_success() {
        String userInput = "테스트";
        CarName carName = new CarName(userInput);
        Assertions.assertThat(carName.getCarName()).isEqualTo("테스트");
    }

    @DisplayName("이름 객체 생성 테스트_실패_빈공란")
    @Test
    void createName_fail_blank() {
        String userInput = "";
        Assertions.assertThatThrownBy((() -> new CarName(userInput))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 빈칸일 수 없습니다.");
    }

    @DisplayName("이름 객체 생성 테스트_실패_5글자 초과")
    @Test
    void createName_fail_overRange() {
        String userInput = "가나다라마바";
        Assertions.assertThatThrownBy((() -> new CarName(userInput))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 최대 5글자 입니다.");
    }


}