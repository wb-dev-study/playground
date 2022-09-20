package hailey.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilsTest {

    @Test
    @DisplayName("야구 숫자 1~9 검증")
    void validateNumber() {
        Assertions.assertThat(ValidationUtils.validateNumber(9)).isEqualTo(9);
        assertThat(ValidationUtils.validateNumber(1)).isEqualTo(1);

        assertThatThrownBy(()-> ValidationUtils.validateNumber(0))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(()-> ValidationUtils.validateNumber(10))
                .isInstanceOf(IllegalStateException.class);
    }
}
