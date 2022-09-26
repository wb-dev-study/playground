package peter.baseball.domain;

import peter.baseball.exception.InvalidNumberException;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by peter on 2022/09/19
 */
public class BallFactory {
    public static Set<Ball> makeBalls(String input) {

        Set<Ball> balls = new LinkedHashSet<>();
        List<Integer> split = convertIntArray(input);
        for (Integer in : split) {
            balls.add(new Ball(in));
        }

        return balls;
    }

    public static List<Integer> convertIntArray(String input) {
        try {
            return Arrays.asList(input.split("")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }
}
