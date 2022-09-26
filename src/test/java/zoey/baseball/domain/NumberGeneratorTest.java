package zoey.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class NumberGeneratorTest {
    @Test
    void generate_none_duplicate_numbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> randomNumbers =  numberGenerator.createRandomNumbers();
        List<Integer> distinctResult = randomNumbers.stream().distinct().collect(Collectors.toList());

        Assertions.assertThat(distinctResult.size()).isEqualTo(randomNumbers.size());
    }
}
