package jay.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerRandomNumber {
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
        return random.nextInt(9) + 1;
    }
}
