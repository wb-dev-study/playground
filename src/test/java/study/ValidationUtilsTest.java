package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ValidationUtils;

import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    @DisplayName("야구_숫자_1_9_검증")
    void validBallNumberTest() {
        assertThat(ValidationUtils.validNumber(9)).isTrue();
        assertThat(ValidationUtils.validNumber(1)).isTrue();
        assertThat(ValidationUtils.validNumber(10)).isFalse();
    }
}
