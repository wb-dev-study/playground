package ep.baseball.ui;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.Ball;
import ep.baseball.domain.ball.BallFactory;
import ep.baseball.domain.ball.Balls;
import ep.baseball.domain.ball.strategy.RandomGenerateStrategy;
import ep.baseball.exception.BallException;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class BaseballGameView {

    private final Balls answer;

    public BaseballGameView(final Balls answer) {
        this.answer = answer;
    }

    public void start() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("게임이 시작되었습니다.");
        Boolean process = Boolean.TRUE;
        while (process) {
            try {
                System.out.println("숫자를 입력해주세요 : ");

                Ball first = createBall(scanner, 1);
                Ball second = createBall(scanner, 2);
                Ball third = createBall(scanner, 3);

                Balls balls = Balls.of(first, second, third);
                List<MatchStatus> match = answer.match(balls);

                printMatchResult(match);

                if (answer.isEqual(balls)) {
                    System.out.println("정답입니다.");
                    process = false;
                }
            } catch (BallException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 잘못 입력하셨습니다.");
            }
        }
        System.out.println("게임이 끝났습니다.");
    }

    private void printMatchResult(final List<MatchStatus> match) {
        StringJoiner stringJoiner = new StringJoiner(",");
        match.forEach(status -> stringJoiner.add(status.kr()));
        System.out.println(stringJoiner);
    }

    private Ball createBall(final Scanner scanner, final Integer position) {
        String str = scanner.nextLine();
        int number = Integer.parseInt(str);
        return Ball.of(number, position);
    }
}
