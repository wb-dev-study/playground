package peter.baseball.domain;

import peter.baseball.exception.InvalidNumberException;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by peter on 2022/09/19
 */
public class BallFactory {
    public static Set<Ball> makeBalls(String input) {

        Set<Ball> balls = new LinkedHashSet<>();
        try {
            for (String in : input.split("")) {
                balls.add(new Ball(Integer.parseInt(in)));
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
        return balls;
    }
}
