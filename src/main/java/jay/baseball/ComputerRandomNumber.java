package jay.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerRandomNumber {
    private static final int MAX_RANGE = 10;

    public List<Integer> create() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = random();
            if (computerNumber.contains(randomNumber)) {
                continue;
            }
            computerNumber.add(randomNumber);
        }
        return computerNumber;
    }

    private int random() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE);
    }
}
