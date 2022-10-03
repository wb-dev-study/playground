package zoey.baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallGame {
    private List<Ball> answer;
    private List<Ball> player;

    public static int NUMBER_SIZE = 3;
    public static int START_POSITION = 0;

    public BallGame(List<Integer> answer, List<Integer> input) {
        this.answer = createBalls(answer);
        this.player = createBalls(input);
    }

    private void validateNumbers(List<Integer> numbers) {
        validNumbersSize(numbers);
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("Numbers must not be duplicated");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    private void validNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("The size of number list must be 3");
        }
    }


    private List<Ball> createBalls(List<Integer> balls) {
        validateNumbers(balls);
        return IntStream.range(START_POSITION, balls.size())
                .mapToObj(pos -> new Ball(pos, balls.get(pos)))
                .collect(Collectors.toList());
    }

    public BallGameResult play() {
        return new BallGameResult(countSameBallNumber(), countSamePlaceSameBallNumber());
    }

    private int countSameBallNumber() {
        return (int) player.stream().filter(player -> answer.stream().anyMatch(ball -> player.compare(ball).isBall())).count();
    }

    private int countSamePlaceSameBallNumber() {
        return (int) player.stream().filter(player -> answer.stream().anyMatch(ball -> player.compare(ball).isStrike())).count();
    }
}
