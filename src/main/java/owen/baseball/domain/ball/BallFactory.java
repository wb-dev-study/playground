package owen.baseball.domain.ball;


import owen.baseball.domain.ball.Balls;
import owen.baseball.util.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


public class BallFactory {

    public static final Validate validate = new Validate();

    public static final Random random = new Random();

    public static Balls computerBall() {
        Set<Integer> randomSet = new LinkedHashSet<>();
        while (randomSet.size() < 3) {
            randomSet.add(random.nextInt(9) + 1);
        }
        List<Integer> randomList = new ArrayList<>(randomSet);
        return new Balls(randomList);
    }

    public static Balls makeBall(String userInput) {
        String[] splitInput = userInput.split("");
        validate.validCheck(splitInput);
        List<Integer> userBallList = Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
        return new Balls(userBallList);
    }
}
