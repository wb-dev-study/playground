package zoey.baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    public static int MAX_SIZE = 3;
    List<Integer> numbers = new ArrayList<>();
    public List<Integer> createRandomNumbers() {
        while (!isMaxSize()) {
            int number = getRandomNumber();
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private int getRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    private boolean isMaxSize() {
        return numbers.size() == MAX_SIZE;
    }
}
