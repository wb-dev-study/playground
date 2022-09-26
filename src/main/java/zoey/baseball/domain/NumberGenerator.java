package zoey.baseball.domain;

import java.util.*;

public class NumberGenerator {
    public static int MAX_SIZE = 3;
    HashSet<Integer> numbers = new LinkedHashSet<>();
    public List<Integer> createRandomNumbers() {
        while (!isMaxSize()) {
            numbers.add(getRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private int getRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    private boolean isMaxSize() {
        return numbers.size() == MAX_SIZE;
    }
}
