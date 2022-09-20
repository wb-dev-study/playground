package jay.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RandomNumberTest {

    @Test
    @DisplayName("컴퓨터 랜덤숫자 생성 테스트")
    void create() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> integers = computerRandomNumber.create();
        Assertions.assertThat(3).isEqualTo(integers.size());
    }

    @Test
    @DisplayName("컴퓨터 랜덤숫자 중복 테스트")
    void duplicateNumber() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> integers = computerRandomNumber.create();
        Assertions.assertThat(integers.size()).isEqualTo(integers.stream().distinct().count());
    }
}