package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("String split 테스트")
    void split() {
        String example = "1,2";
        String example1 = "1";
        String[] splitArray = example.split(",");
        String[] splitArray1 = example1.split(",");

        //중복여부, 순서에 관계 없이 값만 일치하면 테스트가 성공
        assertThat(splitArray).contains("1", "2");
        assertThat(splitArray1).contains("1");

        //순서를 포함해서 정확히 일치
        assertThat(splitArray).containsExactly("1", "2");
        assertThat(splitArray1).containsExactly("1");
    }

    @Test
    @DisplayName("String subString 테스트")
    void subString() {
        String example = "(1,2)";
        int beginIndex = example.indexOf("(");
        int lastIndex = example.lastIndexOf(")");
        String result = example.substring(beginIndex +1, lastIndex);

        assertThat(result).isEqualTo("1,2");
    }
}
