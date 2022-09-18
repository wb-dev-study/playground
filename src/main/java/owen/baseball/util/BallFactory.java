package owen.baseball.util;


import owen.baseball.domain.ball.Balls;

import java.util.*;

public class BallFactory {

    public static Balls computerBall() {
        Set<Integer> randomSet = new HashSet<>();
        Random random = new Random();
        while (randomSet.size() < 3) {
            randomSet.add(random.nextInt((9 - 1) + 1) + 1);
        }
        List<Integer> randomList = new ArrayList<>(randomSet);
        return new Balls(randomList);
    }

    public static Balls makeBall(String userInput) {
        Validate validate = new Validate();

        String[] splitInput = userInput.split("");
        validate.validCheck(splitInput);
        List<Integer> userBallList = new ArrayList<>();

        for (String inputString : splitInput) {
            userBallList.add(Integer.valueOf(inputString));
        }

        return new Balls(userBallList);
    }
}
