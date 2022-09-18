package ep.baseball.ui;

import ep.baseball.domain.MatchStatus;
import ep.baseball.domain.ball.Ball;
import ep.baseball.domain.ball.Balls;
import ep.baseball.domain.ball.strategy.RandomGenerateStrategy;
import ep.baseball.exception.BallException;

import java.util.List;
import java.util.Scanner;

public class BaseballGameView {

    private Balls answer = new Balls(new RandomGenerateStrategy());

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임이 시작되었습니다.");
        Boolean process = Boolean.TRUE;
        while (process) {
            try {
                System.out.println("숫자를 입력해주세요 : ");
                Ball first = createBall(scanner);
                Ball second = createBall(scanner);
                Ball third = createBall(scanner);
                Balls balls = new Balls(first, second, third);
                List<MatchStatus> match = answer.match(balls);
                match.forEach(status -> {
                    System.out.print(status.kr() + ", ");
                });
                System.out.println();

                if (answer.isEqual(balls)) {
                    System.out.println("정답입니다.");
                    process = false;
                }
            } catch (BallException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private Ball createBall(Scanner scanner) {
        String firstStr = scanner.nextLine();
        int firstNumber = Integer.parseInt(firstStr);
        Ball first = new Ball(firstNumber, 1);
        return first;
    }

}
